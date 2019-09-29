package knowledge.accumulation.springcloud.controller;

import org.apache.shiro.crypto.hash.ConfigurableHashService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CasShiroController {
    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String loginForm(Model model){
        model.addAttribute("user", new User());
//      return "login";
//        return "redirect:" + CasShiroConfiguration.loginUrl;
        ConfigurableHashService hashService = new DefaultHashService();
//        hashService.setPrivateSalt(ByteSource.Util.bytes("."));
        hashService.setHashAlgorithmName("MD5");
        hashService.setHashIterations(2);
        HashRequest request = new HashRequest.Builder()
                .setSalt("q6taw")
                .setSource("admin")
                .build();
        String res = hashService.computeHash(request).toHex();
        System.out.println(res);
        return "tes1t";
    }
}
