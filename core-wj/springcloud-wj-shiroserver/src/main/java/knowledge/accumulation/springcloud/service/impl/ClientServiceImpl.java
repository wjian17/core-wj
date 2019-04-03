package knowledge.accumulation.springcloud.service.impl;

import knowledge.accumulation.springcloud.config.entity.Client;
import knowledge.accumulation.springcloud.mapper.ClientMapper;
import knowledge.accumulation.springcloud.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public Client createClient(Client client) {
        return null;
    }

    @Override
    public Client updateClient(Client client) {
        return null;
    }

    @Override
    public void deleteClient(Long clientId) {

    }

    @Override
    public Client findOne(Long clientId) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Client findByClientId(String clientId) {
        return clientMapper.findByClientId(clientId);
    }

    @Override
    public Client findByClientSecret(String clientSecret) {
        return null;
    }
}
