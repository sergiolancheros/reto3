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

    public Category insertCategory(Category category){
        return categoryRepository.save(category);
    }

    public boolean deleteCategory(int id){
        Optional<Category> c=categoryRepository.getById(id);
        if(c.isPresent()){
            categoryRepository.delete(c.get());
            return true;
        }else{
            return false;
        }      
    }

    public Category update(Category c){
        if(c.getId()!= null){
            Optional<Category> newc = categoryRepository.getById(c.getId());
            if(newc.isPresent()){
                Category oldc = newc.get();
                if(c.getName()!=null){
                    oldc.setName(c.getName());
                }

                if(c.getDescription()!=null){
                    oldc.setDescription(c.getDescription());
                }
                return categoryRepository.save(oldc);
            }
        }
        return c;
    }

}
