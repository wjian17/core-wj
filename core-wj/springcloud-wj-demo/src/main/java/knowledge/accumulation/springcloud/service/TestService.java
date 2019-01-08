package knowledge.accumulation.springcloud.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import knowledge.accumulation.springcloud.mapper.TestMapper;
import knowledge.accumulation.springcloud.utils.SpringBeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public void test(){
        testMapper = (TestMapper) SpringBeanFactoryUtils.getBean(TestMapper.class);
        PageHelper.startPage(2, 1);
        List<Integer> list = testMapper.getIdList();
        PageInfo<Integer> pageInfo = new PageInfo<Integer>(list);//封装结果集到PageInfo bean
        System.out.println(testMapper.selectTest());
    }

}
