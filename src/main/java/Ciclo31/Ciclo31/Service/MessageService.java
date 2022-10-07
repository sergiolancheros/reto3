package Ciclo31.Ciclo31.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ciclo31.Ciclo31.Model.Message;
import Ciclo31.Ciclo31.Repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage (int id){
        return messageRepository.getMessage(id);
    }

    public Message insertmeMessage(Message message){
        return messageRepository.save(message);
    }
 
    

}
