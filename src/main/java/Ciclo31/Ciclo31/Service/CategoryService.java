package Ciclo31.Ciclo31.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ciclo31.Ciclo31.Model.Category;
import Ciclo31.Ciclo31.Repository.CategoryRepository;

@Service
public class CategoryService {    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory (int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c){
        if (c.getId()== null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> caux= categoryRepository.getCategory(c.getId());
            if (caux.isEmpty()){
                return categoryRepository.save(c);
            } else{
                return c;
            }
        }

    }


}
