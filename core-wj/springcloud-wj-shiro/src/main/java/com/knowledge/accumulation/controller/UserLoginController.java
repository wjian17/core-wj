package com.knowledge.accumulation.controller;

import com.knowledge.accumulation.response.ResponseBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/userLogin")
public class UserLoginController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/toLogin")
    @ResponseBody
    public ResponseBean toLogin(){
        ResponseBean responseBean = new ResponseBean();
        try{
        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResponseBean login(HttpServletRequest request){
        String className = (String)request.getAttribute("shiroLoginFailure");
        System.out.println(className);
        System.out.println(request.getSession(false).getId());
        ResponseBean responseBean = new ResponseBean();
        try{
            System.out.println("1111");
        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        Subject subject = SecurityUtils.getSubject();
        return responseBean;
    }

    @RequestMapping(value = "/index")
    @ResponseBody
    public ResponseBean index(){
        ResponseBean responseBean = new ResponseBean();
        try{

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

        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }
}
