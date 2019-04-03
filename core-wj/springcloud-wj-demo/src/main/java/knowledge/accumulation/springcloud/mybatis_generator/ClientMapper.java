package knowledge.accumulation.springcloud.mybatis_generator;

import knowledge.accumulation.springcloud.mybatis_generator.Client;

public interface ClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);
}