package Ciclo31.Ciclo31.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ciclo31.Ciclo31.Model.Client;
import Ciclo31.Ciclo31.Repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getCliente (int id){
        return clientRepository.getCliente(id);
    }

    public Client insertClient(Client client){
        return clientRepository.save(client);
    }

    
}
