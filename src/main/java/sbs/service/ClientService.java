package sbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sbs.model.Clients;
import sbs.repository.ClientDao;

@Service
public class ClientService extends AbstractService<Clients, Long> {
    @Autowired
    private ClientDao dao;

    @Override
    protected JpaRepository<Clients, Long> getRepository() {
        return dao;
    }
}
