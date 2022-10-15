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

    public boolean deleteClient(int id){
        Optional<Client> c=clientRepository.getById(id);
        if(c.isPresent()){
            clientRepository.delete(c.get());
            return true;
        }else{
            return false;
        }      
    }

    public Client update(Client c){
        if(c.getIdClient()!= null){
            Optional<Client> newc = clientRepository.getById(c.getIdClient());
            if(newc.isPresent()){
                Client cdb = newc.get();

                if (c.getAge()!=null) cdb.setAge(c.getAge());
                if (c.getEmail()!=null) cdb.setEmail(c.getEmail());
                if (c.getName()!=null) cdb.setName(c.getName());
                if (c.getPassword()!=null) cdb.setPassword(c.getPassword());
                return clientRepository.save(cdb);
            }
        }    
        
        return c;
    }

    
}
