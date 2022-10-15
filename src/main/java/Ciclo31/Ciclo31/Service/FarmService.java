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

    public Farm insertFarm(Farm farm){
        return farmRepository.save(farm);
    }
      
    public boolean deleteFarm(int id){
        Optional<Farm> f=farmRepository.getById(id);
        if(f.isPresent()){
            farmRepository.delete(f.get());
            return true;
        }else{
            return false;
        }      
    }

    public Farm update(Farm f){
        if(f.getId()!= null){
            Optional<Farm> newf = farmRepository.getById(f.getId());
            if(newf.isEmpty()) return f;

            else{
                Farm fdb = newf.get();

               if (f.getAddress()!= null) fdb.setAddress(f.getAddress());
               if(f.getExtension()!=null) fdb.setExtension(f.getExtension());
               if (f.getCategory()!=null) fdb.setCategory(f.getCategory());
               if(f.getName()!=null) fdb.setName(f.getName());
               if (f.getDescription()!=null) fdb.setDescription(f.getDescription());
               return farmRepository.save(fdb);
            }
        }    
        
        return f;
    }
}
