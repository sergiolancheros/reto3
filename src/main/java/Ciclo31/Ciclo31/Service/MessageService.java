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

    public Message save(Message m){
        if(m.getId()== null){
            return messageRepository.save(m);
        }else{
            Optional<Message> maux= messageRepository.getMessage(m.getId());
            if (maux.isEmpty()){
                return messageRepository.save(m);
            }else{
                return m;
            }
        }
    }
 
    

}
