package knowledge.accumulation.springcloud.service.impl;

import knowledge.accumulation.springcloud.service.ClientService;
import knowledge.accumulation.springcloud.service.OAuthService;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OAuthServiceImpl implements OAuthService {

    private Cache cache;

    @Autowired
    private ClientService clientService;

    @Autowired
    public OAuthServiceImpl(@Qualifier("ehCacheManager")EhCacheManager ehCacheManager) {
        this.cache = ehCacheManager.getCache("code-cache");
    }


    @Override
    public void addAuthCode(String authCode, String username) {
        this.cache.put(authCode, username);
    }

    @Override
    public void addAccessToken(String accessToken, String username) {
        this.cache.put(accessToken, username);
    }

    @Override
    public boolean checkAuthCode(String authCode) {
        return cache.get(authCode) != null;
    }

    @Override
    public boolean checkAccessToken(String accessToken) {
        return this.cache.get(accessToken) != null;
    }

    @Override
    public String getUsernameByAuthCode(String authCode) {
        return (String)this.cache.get(authCode);
    }

    @Override
    public String getUsernameByAccessToken(String accessToken) {
        return (String)this.cache.get(accessToken);
    }

    @Override
    public long getExpireIn() {
        return 3600L;
    }

    @Override
    public boolean checkClientId(String clientId) {
        //数据库查询clientId对应数据是否存在
        return clientService.findByClientId(clientId) != null;
    }

    @Override
    public boolean checkClientSecret(String clientSecret) {
        return clientService.findByClientSecret(clientSecret) != null;
    }
}
