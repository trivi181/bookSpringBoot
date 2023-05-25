package phantrivi_2011063105.lap3.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import phantrivi_2011063105.lap3.entity.Category;
import phantrivi_2011063105.lap3.services.CategoryService;

import java.util.List;
@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllCategories(Model model){
        List<Category> categories = categoryService.getAllCategories() ;
        model.addAttribute("categories", categories);
        return "category/list";
    }
    @GetMapping("/add")
    public String aCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }
    @PostMapping("/add")
    public String addCategory( @ModelAttribute("category")Category category){
        categoryService.addCategory(category);
        return "redirect:/categories";
    }
    @GetMapping("/edit/{id}")
    public String editCategories(@PathVariable("id") Long id, Model model){
        Category c = categoryService.getCategoryId(id);
        if(c != null){
            model.addAttribute("category", c);
            return "category/edit";
        }
        else{
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editCategory(@ModelAttribute("category") Category update, BindingResult result){
        Category c = categoryService.getCategoryId(update.getId());
        if(result.hasErrors()){
            return "category/edit";
        }
        categoryService.updateCategory(update);
        return "redirect:/categories";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id")Long id){
        Category category = categoryService.getCategoryId(id);
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}
