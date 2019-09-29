package knowledge.accumulation.springcloud.service;

import knowledge.accumulation.springcloud.domain.Client;
import knowledge.accumulation.springcloud.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@CacheConfig(cacheNames="userCache")
@Transactional
public class ClientService {

    @Autowired
    public ClientMapper clientMapper;

    @Cacheable(key = "#p0",unless="#result == null")
    public Client getClient(long id){
        return clientMapper.selectByPrimaryKey(id);
    }
}
