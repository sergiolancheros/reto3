package Ciclo31.Ciclo31.Repository.crud;

import org.springframework.data.repository.CrudRepository;
import Ciclo31.Ciclo31.Model.Message;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
        
}
