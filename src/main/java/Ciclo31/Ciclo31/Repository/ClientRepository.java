package Ciclo31.Ciclo31.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Ciclo31.Ciclo31.Model.Client;
import Ciclo31.Ciclo31.Repository.crud.ClientCrudRepository;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return(List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getCliente (int id){
        return clientCrudRepository.findById(id);
    }

    public Client save (Client m){
        return clientCrudRepository.save(m);
    }
    
}
