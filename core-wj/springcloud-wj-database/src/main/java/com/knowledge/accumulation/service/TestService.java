package com.knowledge.accumulation.service;

import com.knowledge.accumulation.mapper.TestMapper;
import com.knowledge.accumulation.utils.SpringBeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public void test(){
        testMapper = (TestMapper) SpringBeanFactoryUtils.getBean(TestMapper.class);
        System.out.println(testMapper.selectTest());
    }

}
