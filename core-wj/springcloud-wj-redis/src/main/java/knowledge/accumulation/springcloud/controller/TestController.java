package knowledge.accumulation.springcloud.controller;

import knowledge.accumulation.springcloud.domain.Client;
import knowledge.accumulation.springcloud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.thymeleaf.util.ArrayUtils;

@Controller
public class TestController {


    @Autowired
    @Qualifier(value = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    @Qualifier(value = "myRedisTemplate")
    private RedisTemplate myRedisTemplate;

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public void test(){
        System.out.println("123234");
        myRedisTemplate.opsForValue().set("key1", ArrayUtils.toArray(new String[]{"1","2","3","5"}));
        redisTemplate.opsForValue().set("key1", ArrayUtils.toArray(new String[]{"132432","2","3","5"}));
        System.out.println("11");

    }

    @RequestMapping(value = "client")
    @ResponseBody
    public Client getClietn(@RequestParam("id") long id){
        return clientService.getClient(id);
    }
}
