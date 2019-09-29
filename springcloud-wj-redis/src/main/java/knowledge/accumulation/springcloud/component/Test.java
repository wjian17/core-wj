package knowledge.accumulation.springcloud.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


@Component
public class Test {

    @Autowired
    @Qualifier("myRedisTemplate")
    private RedisTemplate myRedisTemplate;

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;


}
