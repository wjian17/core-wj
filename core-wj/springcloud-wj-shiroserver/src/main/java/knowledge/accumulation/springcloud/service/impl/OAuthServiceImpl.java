package knowledge.accumulation.springcloud.service.impl;

import knowledge.accumulation.springcloud.service.ClientService;
import knowledge.accumulation.springcloud.service.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

@Service
public class OAuthServiceImpl implements OAuthService {


    private Cache cache;

    @Autowired
    private ClientService clientService;

    @Override
    public void addAuthCode(String authCode, String username) {

    }

    @Override
    public void addAccessToken(String accessToken, String username) {

    }

    @Override
    public boolean checkAuthCode(String authCode) {
        return false;
    }

    @Override
    public boolean checkAccessToken(String accessToken) {
        return false;
    }

    @Override
    public String getUsernameByAuthCode(String authCode) {
        return null;
    }

    @Override
    public String getUsernameByAccessToken(String accessToken) {
        return null;
    }

    @Override
    public long getExpireIn() {
        return 0;
    }

    @Override
    public boolean checkClientId(String clientId) {
        //数据库查询clientId对应数据是否存在
        return clientService.findByClientId(clientId) != null;;
    }

    @Override
    public boolean checkClientSecret(String clientSecret) {
        return false;
    }
}
