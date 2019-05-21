package knowledge.accumulation.springcloud.controller;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccessTokenController {

    @RequestMapping("/oauth2-login")
    public Object toLogin(HttpServletRequest request)throws OAuthProblemException {
//        String  code = request.getParameter("code");
//        System.out.println("==> 服务端回调，获取的code："+code);
//        OAuthClient oAuthClient =new OAuthClient(new URLConnectionClient());
//        try {
//
//            OAuthClientRequest accessTokenRequest = OAuthClientRequest
//                    .tokenLocation(accessTokenUrl)
//                    .setGrantType(GrantType.AUTHORIZATION_CODE)
//                    .setClientId(clientId)
//                    .setClientSecret(clientSecret)
//                    .setCode(code)
//                    .setRedirectURI(redirectUrl)
//                    .buildQueryMessage();
//
//            //去服务端请求access token，并返回响应
//            OAuthAccessTokenResponse oAuthResponse =oAuthClient.accessToken(accessTokenRequest, OAuth.HttpMethod.POST);
//            //获取服务端返回过来的access token
//            String accessToken = oAuthResponse.getAccessToken();
//            //查看access token是否过期
//            Long expiresIn =oAuthResponse.getExpiresIn();
//            System.out.println("==> 客户端根据 code值 "+code +" 到服务端获取的access_token为："+accessToken+" 过期时间为："+expiresIn);
//
//            System.out.println("==> 拿到access_token然后重定向到 客户端 /oauth-client/getUserInfo服务,传过去accessToken");
//
//            return"redirect:/oauth-client/getUserInfo?accessToken="+accessToken;
//
//        } catch (OAuthSystemException e) {
//            e.printStackTrace();
//        }
        return null;
    }
//
//    @RequestMapping("/getUserInfo")
//    @ResponseBody
//    public String accessToken(String accessToken) {
//
//        OAuthClient oAuthClient =new OAuthClient(new URLConnectionClient());
//        try {
//            OAuthClientRequest userInfoRequest =new OAuthBearerClientRequest(userInfoUrl)
//                    .setAccessToken(accessToken).buildQueryMessage();
//
//            OAuthResourceResponse resourceResponse =oAuthClient.resource(userInfoRequest, OAuth.HttpMethod.GET, OAuthResourceResponse.class);
//            String body = resourceResponse.getBody();
//            System.out.println("==> 客户端通过accessToken："+accessToken +"  从服务端获取用户信息为："+body);
//            return body;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
    @RequestMapping("/oauth2Failure")
    public String accessToken(String accessToken) {
        return "oauth2Failure";
    }

}
