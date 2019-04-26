package knowledge.accumulation.springcloud.service;

import knowledge.accumulation.springcloud.dao.InsurancePlanCriticalIllnessDao;
import knowledge.accumulation.springcloud.dao.SolrTbDao;
import knowledge.accumulation.springcloud.domain.InsurancePlanCriticalIllness;
import knowledge.accumulation.springcloud.domain.SolrTbEntity;
import knowledge.accumulation.springcloud.mapper.InsurancePlanCriticalIllnessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService {

    @Autowired
    SolrTbDao solrTbDao;

    @Autowired
    InsurancePlanCriticalIllnessDao insurancePlanCriticalIllnessDao;

    @Autowired
    InsurancePlanCriticalIllnessMapper insurancePlanCriticalIllnessMapper;

    @Transactional(value = "transactionManagerPrimary",rollbackFor = Exception.class)
    public void test() throws Exception{
        try {
            List<SolrTbEntity> lists = solrTbDao.findAll();
            InsurancePlanCriticalIllness insurancePlanCriticalIllness = new InsurancePlanCriticalIllness();
            insurancePlanCriticalIllness.setPlanNo("00000");
            Object o = insurancePlanCriticalIllnessDao.save(insurancePlanCriticalIllness);
            List<InsurancePlanCriticalIllness> list = insurancePlanCriticalIllnessMapper.queryAll();
            int i = 1/0;
            System.out.println("11");
        }catch (Exception e){
            throw e;
        }
    }
}
