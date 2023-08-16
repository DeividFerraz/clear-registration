package project.client.client.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.client.client.entities.ClientLog;

public interface ClientRepository extends JpaRepository<ClientLog, Long>{

}
