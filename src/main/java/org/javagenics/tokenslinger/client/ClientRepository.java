package org.javagenics.tokenslinger.client;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);

    Optional<Client> findByCpf(String cpf);

    Optional<Client> findByEmailOrCpf(String email, String cpf);
}
