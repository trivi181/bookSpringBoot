package phantrivi_2011063105.lap3.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import phantrivi_2011063105.lap3.daos.Item;
import phantrivi_2011063105.lap3.services.CartService;
import phantrivi_2011063105.lap3.services.CategoryService;
import phantrivi_2011063105.lap3.services.BookService;
import phantrivi_2011063105.lap3.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/books")
public class  BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories",categoryService.getAllCategories());
        return"book/add";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book")Book book, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }
    @GetMapping("/edit/{id}")
    public String editBooks(@PathVariable("id") Long id, Model model){
        Book b = bookService.getBookById(id);
        if(b != null){
            model.addAttribute("book", b);
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/edit";
        }
        else{
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@Valid @ModelAttribute("book") Book update, BindingResult result){
        Book b = bookService.getBookById(update.getId());
        if(result.hasErrors()){
            return "book/edit";
        }
        bookService.updateBook(update);
        return "redirect:/books";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id")Long id){
        Book book = bookService.getBookById(id);
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @Autowired
    private CartService cartService;
    @PostMapping("/add-to-cart")
    public String addToCart(HttpSession session,
                            @RequestParam long id,
                            @RequestParam String name,
                            @RequestParam double price,
                            @RequestParam(defaultValue = "1") int quantity)
    {
        var cart = cartService.getCart(session);
        cart.addItems(new Item(id, name, price, quantity));
        cartService.updateCart(session, cart);
        return "redirect:/books";
    }
}