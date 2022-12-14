package Ciclo31.Ciclo31.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Ciclo31.Ciclo31.Model.Category;
import Ciclo31.Ciclo31.Repository.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    public List<Category> getAll(){
        return (List<Category>)categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }

    public Category save (Category c){
        return categoryCrudRepository.save(c);
    }

    public Optional<Category> getById(int idCategory) {
        return categoryCrudRepository.findById(idCategory);
    }

    public void deleteById(int idCategory){
        categoryCrudRepository.deleteById(idCategory);
    }

    
}
