package knowledge.accumulation.springcloud.mybatis_generator;

import knowledge.accumulation.springcloud.mybatis_generator.InsuranceBackInfo;

public interface InsuranceBackInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceBackInfo record);

    int insertSelective(InsuranceBackInfo record);

    InsuranceBackInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InsuranceBackInfo record);

    int updateByPrimaryKey(InsuranceBackInfo record);
}