package Ciclo31.Ciclo31.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Ciclo31.Ciclo31.Model.Farm;
import Ciclo31.Ciclo31.Repository.crud.FarmCrudRepository;

@Repository
public class FarmRepository {
    @Autowired
    private FarmCrudRepository farmCrudRepository; 
    
    public List<Farm> getAll(){
        return (List<Farm>) farmCrudRepository.findAll();
    } 

public Optional<Farm> getFinca(int id){
    return farmCrudRepository.findById(id);
}  

public Farm save (Farm f){
    return farmCrudRepository.save(f);
}
    
}
