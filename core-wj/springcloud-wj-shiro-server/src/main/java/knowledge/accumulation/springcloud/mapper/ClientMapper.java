package knowledge.accumulation.springcloud.mapper;


import knowledge.accumulation.springcloud.config.entity.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);

    Client findByClientId(@Param("clientId") String clientId);

    Client findByClientSecret(@Param("clientSecret") String clientId);
}