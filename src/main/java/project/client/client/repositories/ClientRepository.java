package project.client.client.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import project.client.client.entities.ClientLog;

public interface ClientRepository extends JpaRepository<ClientLog, Long>{

	Optional<ClientLog> findByCpf(String cpf);

	ClientLog getReferenceById(Long id);

}
