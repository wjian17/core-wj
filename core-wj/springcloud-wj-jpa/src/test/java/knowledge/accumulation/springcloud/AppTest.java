package knowledge.accumulation.springcloud;

import knowledge.accumulation.springcloud.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes ={JpaApplication.class})
public class AppTest 
{

    @Autowired
    private TestMapper testMapper;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        knowledge.accumulation.springcloud.module.jpa.pojo.Test test = new knowledge.accumulation.springcloud.module.jpa.pojo.Test();
        test.setName("100");
        test.setCreateTime(new Date());
        testMapper.save(test);
        System.out.println("111");
    }
}
