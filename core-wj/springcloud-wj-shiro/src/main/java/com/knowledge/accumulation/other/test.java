package com.knowledge.accumulation.other;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


public class test {
    public static void main(String[] args) {
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("user13", "password1");
        try {
            subject.login(usernamePasswordToken);
        } catch (LockedAccountException lae) {
            //用户加锁冻结
        } catch(DisabledAccountException dia){
            //账户失效
        } catch(ExcessiveAttemptsException dia){
            //尝试次数过多
        } catch(UnknownAccountException uae) {
            //用户不正确
        } catch (IncorrectCredentialsException ice) {
            //凭证不正确
        } catch (ExpiredCredentialsException ecd){
            //凭证过期
        } catch (AuthenticationException ae) {
        }
    }
}
