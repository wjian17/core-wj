package knowledge.accumulation.springcloud.controller;

import com.alibaba.fastjson.JSON;
import knowledge.accumulation.springcloud.utils.HttpClientManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

@Controller
public class LoginController {

    private final static String APPID = "wx6a89e3b4e1c4a3ad";
    private final static String APPSECRET = "ee1ebaff6a067b1ff2d9b7d03bc8cd20";

    @RequestMapping("loginInit.do")
    public String loginInit(HttpServletRequest request, HttpServletResponse response)  {
        //回调地址,要跟下面的地址能调通(getWechatGZAccessToken.do)
        String backUrl="http://fhtpbv.natappfree.cc/getWechatGZAccessToken.do";
        /**
         *这儿一定要注意！！首尾不能有多的空格（因为直接复制往往会多出空格），其次就是参数的顺序不能变动
         **/
        //APPID微信公众号的appId
        String url = null;
        try {
            url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + APPID+
                    "&redirect_uri=" + URLEncoder.encode(backUrl,"UTF-8")+
                    "&response_type=code" +
                    "&scope=snsapi_userinfo" +
                    "&state=STATE#wechat_redirect";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "redirect:"+url;
    }

    @RequestMapping("getWechatGZAccessToken.do")
    public void getWechatGZAccessToken(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //微信公众号的APPID和APPSECRET
        String code=request.getParameter("code");
        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APPID+
                "&secret=" +APPSECRET+
                "&code=" +code+
                "&grant_type=authorization_code";
        String result = HttpClientManager.getUrlData(url);
        Map<String,Object> data = JSON.parseObject(result,Map.class);
        String openid=data.get("openid").toString();
        String token=data.get("access_token").toString();
        System.out.println(openid+"========"+token);
        //获取信息
        String infoUrl="https://api.weixin.qq.com/sns/userinfo?access_token=" +token+
                "&openid=" +openid+
                "&lang=zh_CN";
        String infoResult = HttpClientManager.getUrlData(infoUrl);
        Map<String,Object> infoData = JSON.parseObject(infoResult,Map.class);
        System.out.println(infoData);
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<font size=\"20\" color=\"red\">"+
                        infoData.get("nickname").toString().getBytes("UTF-8")+
                        infoData.get("nickname").toString()+
                        infoData.get("nickname").toString()+
                        infoData.get("nickname").toString()+
                "</font>"+
                "</body>\n" +
                "</html>");
    }

}
