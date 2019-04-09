package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.response.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/jwt")
public class JwtController {

    private Logger logger = LoggerFactory.getLogger(JwtController.class);

    @RequestMapping(value = "/test")
    @ResponseBody
    public ResponseBean test(){
        logger.info("test is running");
        ResponseBean responseBean = new ResponseBean();
        try{
            System.out.println("jwt/test");
        }catch (Exception e){
            logger.error("test logger error:{}",e.getMessage());
            e.printStackTrace();
        }
        return responseBean;
    }
}
