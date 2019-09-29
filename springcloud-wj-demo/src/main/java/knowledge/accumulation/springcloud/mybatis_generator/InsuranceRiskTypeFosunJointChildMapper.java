package knowledge.accumulation.springcloud.mybatis_generator;

import knowledge.accumulation.springcloud.mybatis_generator.InsuranceRiskTypeFosunJointChild;

public interface InsuranceRiskTypeFosunJointChildMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceRiskTypeFosunJointChild record);

    int insertSelective(InsuranceRiskTypeFosunJointChild record);

    InsuranceRiskTypeFosunJointChild selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InsuranceRiskTypeFosunJointChild record);

    int updateByPrimaryKey(InsuranceRiskTypeFosunJointChild record);
}