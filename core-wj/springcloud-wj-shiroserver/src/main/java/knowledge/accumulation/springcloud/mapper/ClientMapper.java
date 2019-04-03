package knowledge.accumulation.springcloud.mapper;

import knowledge.accumulation.springcloud.config.entity.Client;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientMapper extends BaseMapper {

   Client findByClientId(String clientId);
}
