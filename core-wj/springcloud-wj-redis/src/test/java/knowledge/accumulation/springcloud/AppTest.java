package knowledge.accumulation.springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@SpringBootTest(classes = {RedisApplication.class})
@RunWith(value = SpringJUnit4ClassRunner.class)
public class AppTest {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    @Qualifier("myRedisTemplate")
    private RedisTemplate myRedisTemplate;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        redisTemplate.opsForValue().set("key1",new String("11133311"));

        myRedisTemplate.opsForValue().set("key2",new Integer(43));

        Object obj = redisTemplate.opsForValue().get("key1");
        Object json = myRedisTemplate.opsForValue().get("key2");
        assert(json==null);
        System.out.println("11");
    }
}
