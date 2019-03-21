package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.response.ResponseBean;
import net.sf.ehcache.CacheManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/userLogin")
public class UserLoginController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/toLogin")
    @ResponseBody
    @RequiresPermissions("/role/remove")
//    @RequiresRoles("role1")
    public ResponseBean toLogin(){
        ResponseBean responseBean = new ResponseBean();
        try{
            SecurityUtils.getSubject().getPrincipals();
            Object o = CacheManager.getCacheManager("").getCache(SecurityUtils.getSubject().getPrincipals().toString());
        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }

    @RequestMapping(value = "/loginUrl")
    @ResponseBody
    public ResponseBean loginUrl(){
        ResponseBean responseBean = new ResponseBean();
        try{
           responseBean.setResponseCode("0000");
           responseBean.setResponseMsg("用户未登录");
        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean login(HttpServletRequest request){
        ResponseBean responseBean = new ResponseBean();
        try{
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String remember = request.getParameter("remember");
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());//
            //如果开启了记住我功能
            if ("on".equals(remember)) {
                token.setRememberMe(true);
            } else {
                token.setRememberMe(false);
            }
            //执行shiro登录操作
            currentUser.login(token);
        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public ResponseBean index(){
        ResponseBean responseBean = new ResponseBean();
        try{
            System.out.println(SecurityUtils.getSubject().getPrincipal());
            System.out.println("index");
        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }

    @RequestMapping(value = "/unauth")
    @ResponseBody
    public ResponseBean unauth(){
        ResponseBean responseBean = new ResponseBean();
        try{
            System.out.println("unauth");
        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }

    @RequestMapping(value = "/error")
    @ResponseBody
    public ResponseBean error(){
        ResponseBean responseBean = new ResponseBean();
        try{
            System.out.println("11111111111");
        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }
    @RequestMapping(value = "/success")
    @ResponseBody
    public ResponseBean success(){
        ResponseBean responseBean = new ResponseBean();
        try{
            System.out.println("success");
        }catch (Exception e){
            logger.error("test logger success:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }
    @RequestMapping(value = "/testAopHandler")
    @ResponseBody
    public ResponseBean testAopHandler(){
        ResponseBean responseBean = new ResponseBean();
        try{
            System.out.println("testAopHandler");

        }catch (Exception e){
            logger.error("test logger testAopHandler:{}",e.getMessage());
            e.printStackTrace();
        }
        int i = 1/0;
        return responseBean;
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public ResponseBean logout(){
        ResponseBean responseBean = new ResponseBean();
        try{
            Subject subject = SecurityUtils.getSubject();
            if(subject!=null){
                subject.logout();
            }
        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }
}
