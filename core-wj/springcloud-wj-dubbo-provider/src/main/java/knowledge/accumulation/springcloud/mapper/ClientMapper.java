package knowledge.accumulation.springcloud.mapper;

import knowledge.accumulation.springcloud.domain.Client;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);
}