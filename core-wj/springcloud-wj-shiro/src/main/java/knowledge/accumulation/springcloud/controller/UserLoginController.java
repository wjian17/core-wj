package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.response.ResponseBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/userLogin")
public class UserLoginController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/toLogin")
    @ResponseBody
    @RequiresPermissions("user:delete")
    @RequiresRoles("role1")
    public ResponseBean toLogin(){
        ResponseBean responseBean = new ResponseBean();
        try{
        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean login(HttpServletRequest request){
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String remember = request.getParameter("remember");

        Subject currentUser = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());

        currentUser.login(token);

//
//        //如果开启了记住我功能
//        if ("on".equals(remember)) {
//            token.setRememberMe(true);
//        } else {
//            token.setRememberMe(false);
//        }
//
//        //执行shiro登录操作
//        currentUser.login(token);
//
//        //登录成功，记录登录日志
//        ShiroUser shiroUser = ShiroKit.getUserNotNull();
//        LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), getIp()));
//
//        ShiroKit.getSession().setAttribute("sessionFlag", true);
//
//        return REDIRECT + "/";
        String className = (String)request.getAttribute("shiroLoginFailure");
        System.out.println(className);
        HttpSession session = request.getSession(false);
        if(session!=null){
            System.out.println(session.getId());
        }
        ResponseBean responseBean = new ResponseBean();
        try{
            System.out.println("1111");
        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
//        Subject subject = SecurityUtils.getSubject();
//        DisabledAccountException
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

        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }
}
