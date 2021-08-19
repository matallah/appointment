package sbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sbs.model.Clients;

@Repository

public interface ClientDao extends JpaRepository<Clients, Long> {
}
