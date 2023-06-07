package phantrivi_2011063105.lap3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phantrivi_2011063105.lap3.entity.Book;
import phantrivi_2011063105.lap3.repository.IBookRepository;
import phantrivi_2011063105.lap3.repository.ICategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private IBookRepository bookRepository;
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public List<Book> getAllBooks(Integer pageNo,
                                   Integer pageSize,
                                   String sortBy) {
        return bookRepository.findAllBooks(pageNo, pageSize, sortBy);
    }
    public Book getBookById(Long id){
        Optional<Book> optional = bookRepository.findById(id);
        return optional.orElse(null);
    }
    public void addBook(Book book){
        bookRepository.save(book);
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    public  void updateBook(Book book){bookRepository.save(book);}
}