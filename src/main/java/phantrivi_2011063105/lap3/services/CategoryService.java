package phantrivi_2011063105.lap3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phantrivi_2011063105.lap3.entity.Book;
import phantrivi_2011063105.lap3.entity.Category;
import phantrivi_2011063105.lap3.repository.ICategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    public List<Category> getAllCategories(){return categoryRepository.findAll();}
    public Category getCategoryId(Long id){
        Optional<Category> optionalCategory=categoryRepository.findById(id);
        if (optionalCategory.isPresent()){
            return optionalCategory.get();
        } else {
            throw new RuntimeException("Category not found");
        }
    }
    public void addCategory(Category category){
        categoryRepository.save(category);
    }
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
    public void updateCategory(Category category){
        categoryRepository.save(category);
    }
}
