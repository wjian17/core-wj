package knowledge.accumulation.springcloud.service;

import knowledge.accumulation.springcloud.domain.User;
import org.springframework.stereotype.Service;

/**
 * 测试Service实现类
 * <p>
 *
 * @author wangjian contact by wangjian@supplyfintech.com
 * @date 2018/7/9 - 上午9:36
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public double division(int numberA, int numberB) throws Exception {
        if (numberB == 0) {
            throw new Exception("除数不能为0");
        }
        return numberA / numberB;
    }

    @Override
    public String print() {
        return "这是来自服务器中DemoService接口的print方法打印的消息";
    }

    @Override
    public int sum(int numberA, int numberB) {
        return numberA + numberB;
    }

    @Override
    public User getUserInfo() {
        User leader = new User();
        leader.setId(1);
        leader.setName("上级");
        leader.setSource(100);
        User user = new User();
        user.setSource(80);
        user.setId(0);
        user.setName("基层");
        user.setLeader(leader);
        return user;
    }
}
