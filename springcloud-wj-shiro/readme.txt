======shiro配置
<!-- 登录地址 -->
        <property name="loginUrl" value="/login.jsp"/>
        <!-- 登录后跳转到业务页面 -->
        <property name="successUrl" value="/main.jsp"/>

1.配置securityManager
    @Bean
    public MySecurityMananger getMySecurityMananger(MyRealm myRealm){
        MySecurityMananger mySecurityMananger = new MySecurityMananger();
        mySecurityMananger.setRealm(myRealm);
        //配置 ehcache缓存管理器 参考博客：
        mySecurityMananger.setCacheManager(getEhCacheManager());
        mySecurityMananger.setSessionManager(sessionManager());
        mySecurityMananger.setRememberMeManager(rememberMeManager());
        return mySecurityMananger;
    }

2.获取subject实例
3.封装toke信息
4.通过subject.login(token)进行用户认证
    通过DelegatingSubject将token托管给SecurityMananger来完成

    DefaultSecurityManager
     public Subject login(Subject subject, AuthenticationToken token) throws AuthenticationException {
            AuthenticationInfo info;
            try {
                info = authenticate(token);

    AuthenticatingSecurityManager
     public AuthenticationInfo authenticate(AuthenticationToken token) throws AuthenticationException {
            return this.authenticator.authenticate(token);
        }

    ModularRealmAuthenticator
      protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
            assertRealmsConfigured();
            Collection<Realm> realms = getRealms();
            if (realms.size() == 1) {
                return doSingleRealmAuthentication(realms.iterator().next(), authenticationToken);
            } else {
                return doMultiRealmAuthentication(realms, authenticationToken);
            }
        }
    ModularRealmAuthenticator extends AbstractAuthenticator
        public void setAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
            this.authenticationStrategy = authenticationStrategy;
        }


    AuthenticatingRealm
     public final AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

            AuthenticationInfo info = getCachedAuthenticationInfo(token);
            if (info == null) {
                //otherwise not cached, perform the lookup:
                info = doGetAuthenticationInfo(token);
                log.debug("Looked up AuthenticationInfo [{}] from doGetAuthenticationInfo", info);
                if (token != null && info != null) {
                    cacheAuthenticationInfoIfPossible(token, info);
                }
            } else {
                log.debug("Using cached authentication info [{}] to perform credentials matching.", info);
            }

            if (info != null) {
                assertCredentialsMatch(token, info);
            } else {
                log.debug("No AuthenticationInfo found for submitted AuthenticationToken [{}].  Returning null.", token);
            }

            return info;
        }

    SecurityManager extends Authenticator, Authorizer, SessionManager [认证，授权，会话]

    ShiroFilterFactoryBean shiroFilter（Filter bean="shiroFilter"）
        protected AbstractShiroFilter createInstance() throws Exception {

            log.debug("Creating Shiro Filter instance.");

            SecurityManager securityManager = getSecurityManager();
            if (securityManager == null) {
                String msg = "SecurityManager property must be set.";
                throw new BeanInitializationException(msg);
            }

            if (!(securityManager instanceof WebSecurityManager)) {
                String msg = "The security manager does not implement the WebSecurityManager interface.";
                throw new BeanInitializationException(msg);
            }

            FilterChainManager manager = createFilterChainManager();

            //Expose the constructed FilterChainManager by first wrapping it in a
            // FilterChainResolver implementation. The AbstractShiroFilter implementations
            // do not know about FilterChainManagers - only resolvers:
            PathMatchingFilterChainResolver chainResolver = new PathMatchingFilterChainResolver();
            chainResolver.setFilterChainManager(manager);

            //Now create a concrete ShiroFilter instance and apply the acquired SecurityManager and built
            //FilterChainResolver.  It doesn't matter that the instance is an anonymous inner class
            //here - we're just using it because it is a concrete AbstractShiroFilter instance that accepts
            //injection of the SecurityManager and FilterChainResolver:
            return new SpringShiroFilter((WebSecurityManager) securityManager, chainResolver);
        }

    AuthenticatingRealm  注入密码加密策略
        public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
            this.credentialsMatcher = credentialsMatcher;
        }

    PermissionResolver
        解析权限

    SimpleHash 加密算法

5 LifecycleBeanPostProcessor【自动配置，可以不写】
<bean id="lifecycleBeanPostProcessor" class="org.apache.shiro.spring.LifecycleBeanPostProcessor" />

<bean id="annotationProxy"
class="org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator"
depends-on="lifecycleBeanPostProcessor">
<property name="proxyTargetClass" value="true" />
</bean>



2.AuthenticationException异常
DisabledAccountException
ExcessiveAccessException
UnknownAccountException
IncorrectCredentialsException

try { currentUser.login(token);
} catch ( UnknownAccountException uae ) { …
} catch ( IncorrectCredentialsException ice ) { …
} catch (LockedAccountException lae ) { …
} catch (ExcessiveAttemptsException eae ) { …
} … catch your own …
} catch ( AuthenticationException ae ) {
 //unexpected error?
}


https://www.cnblogs.com/dreamowneryong/p/5610748.html

ssm web.xml配置   shiroFilter生命周期spring创建，由servlet容器管理
<!-- shiro的拦截器 -->
   <filter>
        <filter-name>shiroFilter</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
        <init-param>
            <param-name>targetFilterLifecycle</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>shiroFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>


ShiroFilterFactoryBean
loginUrl    ==== 【访问认证资源时】未认证，如果不配置，默认跳转到login.jsp
successUrl  ====  认证后跳转页，
unauthorizedUrl  ==== 用户没有权限访问时，跳转的页面


<bean id="shiroFilter" class="org.apache.shiro.spring.web.ShiroFilterFactoryBean">
        <!-- 权限管理器 -->
        <property name="securityManager" ref="securityManager"/>
        <!-- 登录地址 -->
        <property name="loginUrl" value="/login.jsp"/>
        <!-- 登录后跳转到业务页面 -->
        <property name="successUrl" value="/main.jsp"/>
        <!-- 错误页面 -->
        <property name="unauthorizedUrl" value="/error.jsp"/>
        <!-- 权限配置 -->
        <property name="filterChainDefinitions">
            <value>
                <!-- anon无权限访问请求，此处是登录页面和登录请求 -->
                /login.do = anon
                /static/**=anon
                <!-- 需要权限为add的用户才能访问此请求-->
                /user=perms[user:add]
                <!-- 需要管理员角色才能访问此页面 -->
                /user/add=roles[admin]
                <!--拦截非静态资源的所有请求-->
                /** = authc
            </value>
        </property>
    </bean>