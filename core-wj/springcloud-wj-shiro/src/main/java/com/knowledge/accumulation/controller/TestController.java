package com.knowledge.accumulation.controller;

import com.knowledge.accumulation.response.ResponseBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/TestController")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/test")
    @RequiresPermissions("TestController")
    @ResponseBody
    public ResponseBean test(){
        logger.info("test is running");
        ResponseBean responseBean = new ResponseBean();
        try{

        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }
}
