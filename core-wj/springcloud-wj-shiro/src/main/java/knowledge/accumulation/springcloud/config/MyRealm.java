package knowledge.accumulation.springcloud.config;

import knowledge.accumulation.springcloud.mapper.MenuMapper;
import knowledge.accumulation.springcloud.utils.MD5Util;
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
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //授权【缓存-修改重查询】
        String usename = principalCollection.getPrimaryPrincipal().toString();
        //查询用户权限
        //null usernames are invalid
//        模拟jdbcRealm
//        if (principals == null) {
//            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
//        }
//
//        String username = (String) getAvailablePrincipal(principals);
//
//        Connection conn = null;
//        Set<String> roleNames = null;
//        Set<String> permissions = null;
//        try {
//            conn = dataSource.getConnection();
//
//            // Retrieve roles and permissions from database
//            roleNames = getRoleNamesForUser(conn, username);
//            if (permissionsLookupEnabled) {
//                permissions = getPermissions(conn, username, roleNames);
//            }
//
//        } catch (SQLException e) {
//            final String message = "There was a SQL error while authorizing user [" + username + "]";
//            if (log.isErrorEnabled()) {
//                log.error(message, e);
//            }
//
//            // Rethrow any SQL errors as an authorization exception
//            throw new AuthorizationException(message, e);
//        } finally {
//            JdbcUtils.closeConnection(conn);
//        }
//
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
//        info.setStringPermissions(permissions);
//        return info;

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //认证登录  可以参照jdbcRealm中的实现方法
        Object user = authenticationToken.getPrincipal();
        System.out.println("AuthenticationInfo");
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
//        String username = (String)authenticationToken.getPrincipal();//用户名
//        //查询密码信息
//        String password = "";
//        SimpleAuthenticationInfo simpleAuthenticationInfo = null;
    }

    public void clearCachedAuthorizationInfo() {
        Subject subject = SecurityUtils.getSubject();
        super.clearCache(subject.getPrincipals());
    }
}
