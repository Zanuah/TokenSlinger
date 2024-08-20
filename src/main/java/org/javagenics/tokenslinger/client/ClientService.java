package org.javagenics.tokenslinger.client;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final BCryptPasswordEncoder bPasswordEncoder;

    public ClientService(ClientRepository clientRepository, BCryptPasswordEncoder bPasswordEncoder) {
        this.clientRepository = clientRepository;
        this.bPasswordEncoder = bPasswordEncoder;
    }

    public Client createClient(String name, String cpf, String email, String password) {
        Optional<Client> clientExists = this.clientRepository.findByEmailOrCpf(email, cpf);
        if (clientExists.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email/Cpf already exists.");
        }

        Client newClient = new Client();
        newClient.setName(name);
        newClient.setCpf(cpf);
        newClient.setEmail(email);
        newClient.setPassword(bPasswordEncoder.encode(password));

        return clientRepository.save(newClient);
    }
}
