package com.knowledge.accumulation.config;

import com.knowledge.accumulation.utils.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //授权【缓存-修改重查询】
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //认证登录
        Object user = authenticationToken.getPrincipal();
        SimpleAuthenticationInfo simpleAuthenticationInfo = null;
        try {
            String passwordEcr = MD5Util.MD5("password", ByteSource.Util.bytes("salt").getBytes(),1);
            System.out.println(passwordEcr);
            if(user.equals("username")) {
                simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, "67a1e09bb1f83f5007dc119c14d663aa", ByteSource.Util.bytes("salt"), getName());
            }else if(user.equals("username1")){
                simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, "62b2648f052d6599bdc84863d712a2d6", ByteSource.Util.bytes("salt"), getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return simpleAuthenticationInfo;
    }

    public void clearCachedAuthorizationInfo() {
        Subject subject = SecurityUtils.getSubject();
        super.clearCache(subject.getPrincipals());
    }
}
