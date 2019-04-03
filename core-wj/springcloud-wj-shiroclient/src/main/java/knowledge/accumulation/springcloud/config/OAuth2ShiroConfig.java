package knowledge.accumulation.springcloud.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class OAuth2ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager defaultWebSecurityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //拦截器
        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>(8);
        OAuth2AuthenticationFilter oAuth2AuthenticationFilter = new OAuth2AuthenticationFilter();
        oAuth2AuthenticationFilter.setAuthcCodeParam("code");
        oAuth2AuthenticationFilter.setFailureUrl("/oauth2Failure.jsp");
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl("/toLogin"); //配置logout跳转地址
        filters.put("logout",logoutFilter);
        filters.put("oauth2Authc",oAuth2AuthenticationFilter);
        shiroFilterFactoryBean.setFilters(filters);
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/oauth2-login", "oauth2Authc");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/**", "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setLoginUrl("http://localhost:8758/authorize?client_id=c1ebe466-1cdc-4bd3-ab69-77c3561b9dee&amp;response_type=code&amp;redirect_uri=http://localhost:8759/oauth2-login");
        return shiroFilterFactoryBean;
    }

    @Bean
    public OAuth2Realm userShiroRealm() {
        OAuth2Realm oAuth2Realm = new OAuth2Realm();
        oAuth2Realm.setCredentialsMatcher(hashedCredentialsMatcher());
//        property name="cachingEnabled" value="true"/>
//  <property name="authenticationCachingEnabled" value="true"/>
//  <property name="authenticationCacheName" value="authenticationCache"/>
//  <property name="authorizationCachingEnabled" value="true"/>
//  <property name="authorizationCacheName" value="authorizationCache"/>
//  <property name="clientId" value="c1ebe466-1cdc-4bd3-ab69-77c3561b9dee"/>
//  <property name="clientSecret" value="d8346ea2-6017-43ed-ad68-19c0f971738b"/>
//  <property name="accessTokenUrl"
//        value="http://localhost:8080/chapter17-server/accessToken"/>
//  <property name="userInfoUrl" value="http://localhost:8080/chapter17-server/userInfo"/>
//  <property name="redirectUrl" value="http://localhost:9080/chapter17-client/oauth2-login"/>
        oAuth2Realm.setCachingEnabled(true);
        oAuth2Realm.setAuthenticationCachingEnabled(true);
        oAuth2Realm.setAuthenticationCacheName("authenticationCache");
        oAuth2Realm.setAuthorizationCachingEnabled(true);
        oAuth2Realm.setAuthorizationCacheName("authorizationCache");
        oAuth2Realm.setClientId("c1ebe466-1cdc-4bd3-ab69-77c3561b9dee");
        oAuth2Realm.setClientSecret("d8346ea2-6017-43ed-ad68-19c0f971738b");
        oAuth2Realm.setAccessTokenUrl("http://localhost:8758/accessToken");
        oAuth2Realm.setUserInfoUrl("http://localhost:8758/userInfo");
        oAuth2Realm.setRedirectUrl("http://localhost:8759/oauth2-login");
        return oAuth2Realm;
    }

    @Bean(value = "securityMananger")
    public DefaultWebSecurityManager getSecurityMananger(OAuth2Realm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        //配置 ehcache缓存管理器 参考博客：
        defaultWebSecurityManager.setCacheManager(getEhCacheManager());
        defaultWebSecurityManager.setSessionManager(sessionManager());
        defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new AllSuccessfulStrategy());
        authenticator.setRealms(defaultWebSecurityManager.getRealms());
        defaultWebSecurityManager.setAuthenticator(authenticator);
        return defaultWebSecurityManager;
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
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean(name="ehCacheManager")
    public EhCacheManager getEhCacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
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
        //散列的次数，比如散列两次，相当于 md5(md5(""))
        hashedCredentialsMatcher.setHashIterations(2);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }
}
