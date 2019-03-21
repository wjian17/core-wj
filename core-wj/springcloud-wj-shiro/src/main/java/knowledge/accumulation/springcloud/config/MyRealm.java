package knowledge.accumulation.springcloud.config;

import cn.hutool.core.convert.Convert;
import cn.stylefeng.roses.core.util.ToolUtil;
import knowledge.accumulation.springcloud.mapper.MenuMapper;
import knowledge.accumulation.springcloud.mapper.RoleMapper;
import knowledge.accumulation.springcloud.mapper.UserMapper;
import knowledge.accumulation.springcloud.module.shiro.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //授权【缓存-修改重查询】
        //查询用户权限
        //null usernames are invalid
//        模拟jdbcRealm
        if (principalCollection == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        String username = (String) getAvailablePrincipal(principalCollection);
        Set<String> permissionSet = new HashSet<>();
        Set<String> roleNameSet = new HashSet<>();
        try {
            User user = userMapper.getByAccount(username);
            //用户角色数组
            Long[] roleArray = Convert.toLongArray(user.getRoleId());
            //获取用户角色列表
            for (Long roleId : roleArray) {
                List<String> permissions = menuMapper.getResUrlsByRoleId(roleId);
                if (permissions != null) {
                    for (String permission : permissions) {
                        if (ToolUtil.isNotEmpty(permission)) {
                            permissionSet.add(permission);
                        }
                    }
                }
                String roleName = roleMapper.selectNameById(roleId);
                if (ToolUtil.isNotEmpty(roleName)) {
                    roleNameSet.add(roleName);
                }
            }
        } catch (Exception e) {
            String message = "授权失败";
            throw new AuthorizationException(message, e);
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionSet);
        info.addRoles(roleNameSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //认证登录  可以参照jdbcRealm中的实现方法
        Object usename = authenticationToken.getPrincipal();
        if (usename == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = null;
        try {
            User user = userMapper.getByAccount(usename.toString());
            Md5Hash md5Hash = new Md5Hash(authenticationToken.getCredentials(),ByteSource.Util.bytes(user.getSalt()),2);
            simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getAccount(), user.getPassword().toCharArray(), ByteSource.Util.bytes(user.getSalt()), getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleAuthenticationInfo;
    }

    public void clearCachedAuthorizationInfo() {
        Subject subject = SecurityUtils.getSubject();
        super.clearCache(subject.getPrincipals());
    }
}
