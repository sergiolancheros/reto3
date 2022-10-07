package Ciclo31.Ciclo31.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ciclo31.Ciclo31.Model.Client;
import Ciclo31.Ciclo31.Service.ClientService;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClientes(){
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getCliente(@PathVariable("id") int id){
        return clientService.getCliente(id);
    }
    
    @PostMapping("/save")
    public ResponseEntity insertClient(@RequestBody Client client){
        clientService.insertClient(client);
        return ResponseEntity.status(201).build();
    }
    
}
