package com.knowledge.accumulation.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

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
        formAuthenticationFilter.setUsernameParam("account");
        formAuthenticationFilter.setPasswordParam("password");
        filters.put("authc",formAuthenticationFilter);
        shiroFilterFactoryBean.setFilters(filters);
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/web/**", "authc");
        filterChainDefinitionMap.put("/unauth", "anon");
        filterChainDefinitionMap.put("/captcha/**", "anon");
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**", "anon");
        filterChainDefinitionMap.put("/ins/manage/userLogin", "anon");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setLoginUrl("/ins/report/toLogin");
        shiroFilterFactoryBean.setSuccessUrl("/ins/report/toLogin");//默认跳转上一个URL   首页登录后
        shiroFilterFactoryBean.setUnauthorizedUrl("/ins/report/unAuth");
        return shiroFilterFactoryBean;
    }

    @Bean
    public MyRealm userShiroRealm() {
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myRealm;
    }

    @Bean
    public MySecurityMananger getMySecurityMananger(MyRealm myRealm){
        MySecurityMananger mySecurityMananger = new MySecurityMananger();
        mySecurityMananger.setRealm(myRealm);
        //配置 ehcache缓存管理器 参考博客：
        mySecurityMananger.setCacheManager(getEhCacheManager());
        mySecurityMananger.setSessionManager(sessionManager());
        return mySecurityMananger;
    }

    /**
     * https://www.cnblogs.com/tuifeideyouran/p/7696055.html
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

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
        sessionManager.setGlobalSessionTimeout(6000);
        //删除无效session
        sessionManager.setDeleteInvalidSessions(true);
        return sessionManager;
    }

    /**
     * 全局异常捕捉
     * @return
     */
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("org.apache.shiro.authc.UnknownAccountException","refuse");
        properties.setProperty("","");
        properties.setProperty("","");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //散列的次数，比如散列两次，相当于 md5(md5(""))
        hashedCredentialsMatcher.setHashIterations(1);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }


}
