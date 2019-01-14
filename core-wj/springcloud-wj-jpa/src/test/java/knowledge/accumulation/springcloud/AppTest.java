package knowledge.accumulation.springcloud;

import knowledge.accumulation.springcloud.service.domain.DomeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes ={JpaApplication.class})
public class AppTest 
{

    @Autowired
    @Qualifier("domeRepository")
    private knowledge.accumulation.springcloud.service.domain.DomeRepository domeRepository;

    @Autowired
    @Qualifier("logDomeRepository")
    private knowledge.accumulation.springcloud.service.log.DomeRepository logDomeRepository;

    /**
     * Rigorous Test :-)
     */
    @Test
//    @Transactional
    public void shouldAnswerWithTrue()
    {
        knowledge.accumulation.springcloud.module.jpa.pojo.Test test = new knowledge.accumulation.springcloud.module.jpa.pojo.Test();
        knowledge.accumulation.springcloud.module.jpa.logpojo.Log log = new knowledge.accumulation.springcloud.module.jpa.logpojo.Log();
        test.setName("101");
        test.setCreateTime(new Date());
        test.setId(1111l);
        log.setCreateTime(new Date());
        log.setName("log101");
        try {
            domeRepository.save(test);
            logDomeRepository.save(log);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("111");
    }
}
