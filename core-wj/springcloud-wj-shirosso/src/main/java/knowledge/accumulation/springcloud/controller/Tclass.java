package knowledge.accumulation.springcloud.controller;

import org.apache.shiro.crypto.hash.ConfigurableHashService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;

public class Tclass {
    public static void main(String[] args) {
        ConfigurableHashService hashService = new DefaultHashService();
//        hashService.setPrivateSalt(ByteSource.Util.bytes("."));
        hashService.setHashAlgorithmName("MD5");
        hashService.setHashIterations(1);
        HashRequest request = new HashRequest.Builder()
                .setSalt("q6taw")
                .setSource("admin")
                .build();
        String res = hashService.computeHash(request).toHex();
        System.out.println(res);
    }
}
