package Ciclo31.Ciclo31.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ciclo31.Ciclo31.Model.Farm;
import Ciclo31.Ciclo31.Repository.FarmRepository;

@Service
public class FarmService {
    @Autowired
    private FarmRepository farmRepository;

    public List<Farm> getAll(){
        return farmRepository.getAll();
    }

    public Optional<Farm> getFinca (int id){
        return farmRepository.getFinca(id);
    } 

    public Farm save(Farm f){
        if(f.getId()==null){
            return farmRepository.save(f);
        }else{
            Optional<Farm> faux=farmRepository.getFinca(f.getId());
            if (faux.isEmpty()){
                return farmRepository.save(f);
            }else{
                return f;
            }
        }
    }
        
}
