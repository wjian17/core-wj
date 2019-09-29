package knowledge.accumulation.springcloud.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(MySecurityMananger mySecurityMananger) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(mySecurityMananger);
        //拦截器
        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>(8);
        FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
        formAuthenticationFilter.setUsernameParam("username");
        formAuthenticationFilter.setPasswordParam("password");
        formAuthenticationFilter.setRememberMeParam("remerberMe");
//        formAuthenticationFilter.setSuccessUrl("/userLogin/index");
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl("/toLogin"); //配置logout跳转地址
        JWTFilter jwtFilter = new JWTFilter();
        filters.put("logout",logoutFilter);
//        filters.put("authc",formAuthenticationFilter);
//        filters.put("jwt",jwtFilter);
        shiroFilterFactoryBean.setFilters(filters);
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/web/**", "authc");
        filterChainDefinitionMap.put("/unauth", "anon");
        filterChainDefinitionMap.put("/userLogin/login", "anon");
        filterChainDefinitionMap.put("/userLogin/unauth", "anon");
        filterChainDefinitionMap.put("/userLogin/toLogin", "authc");
//        filterChainDefinitionMap.put("/userLogin/index", "anon");
        filterChainDefinitionMap.put("/userLogin/testAopHandler", "anon");
        filterChainDefinitionMap.put("/userLogin/error", "anon");
        filterChainDefinitionMap.put("/userLogin/index", "user");
        filterChainDefinitionMap.put("/TestController/**", "anon");
//        filterChainDefinitionMap.put("/jwt/**", "jwt");
        filterChainDefinitionMap.put("/**", "authc");
        filterChainDefinitionMap.put("/userLogin/logout", "logout");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setLoginUrl("/userLogin/loginUrl");
//        shiroFilterFactoryBean.setSuccessUrl("/userLogin/index");//默认跳转上一个URL   首页登录后
        shiroFilterFactoryBean.setUnauthorizedUrl("/userLogin/unauth");
        return shiroFilterFactoryBean;
    }

    @Bean
    public MyRealm userShiroRealm() {
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myRealm;
    }

    @Bean
    public JWTRealm jwtRealm() {
        JWTRealm jwtRealm = new JWTRealm();
//        jwtRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return jwtRealm;
    }

    @Bean
    public MySecurityMananger getMySecurityMananger(MyRealm myRealm,JWTRealm jwtRealm){
        MySecurityMananger mySecurityMananger = new MySecurityMananger();
        mySecurityMananger.setRealm(myRealm);
        mySecurityMananger.setRealm(jwtRealm);
        //配置 ehcache缓存管理器 参考博客：
        mySecurityMananger.setCacheManager(getEhCacheManager());
        mySecurityMananger.setSessionManager(sessionManager());
        mySecurityMananger.setRememberMeManager(rememberMeManager());
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new AllSuccessfulStrategy());
        authenticator.setRealms(mySecurityMananger.getRealms());
        mySecurityMananger.setAuthenticator(authenticator);
        return mySecurityMananger;
    }

    @Bean
    public RememberMeManager rememberMeManager(){
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        SimpleCookie cookie = new SimpleCookie();
        cookie.setMaxAge(604800);
        cookie.setName("rememberMe");
        rememberMeManager.setCookie(cookie);
        return rememberMeManager;
    }
    /**
     * https://www.cnblogs.com/tuifeideyouran/p/7696055.html
     * @return
     */
//    @Bean
//    @ConditionalOnMissingBean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
//        defaultAAP.setProxyTargetClass(true);
//        return defaultAAP;
//    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(MySecurityMananger mySecurityMananger) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(mySecurityMananger);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean(name="ehCacheManager")
    public EhCacheManager getEhCacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return cacheManager;
    }

    @Bean(name="sessionManager")
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        @Override
//        public Serializable getSessionId(SessionKey key) {
//            return super.getSessionId(key);
//        }
        sessionManager.setGlobalSessionTimeout(600000);
        //删除无效session
        sessionManager.setDeleteInvalidSessions(true);
        return sessionManager;
    }
//
//    /**
//     * 全局异常捕捉
//     * @return
//     */
//    @Bean
//    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
//        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
//        Properties properties = new Properties();
//        properties.setProperty("org.apache.shiro.authc.UnknownAccountException","refuse");
//        properties.setProperty("","");
//        properties.setProperty("","");
//        simpleMappingExceptionResolver.setExceptionMappings(properties);
//        return simpleMappingExceptionResolver;
//    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
//        hashedCredentialsMatcher.setHashAlgorithmName(SimpleHash.);
        //散列的次数，比如散列两次，相当于 md5(md5(""))
        hashedCredentialsMatcher.setHashIterations(2);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }


}
