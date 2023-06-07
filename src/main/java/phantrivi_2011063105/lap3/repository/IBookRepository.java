package phantrivi_2011063105.lap3.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import phantrivi_2011063105.lap3.entity.Book;

import java.util.List;

@Repository
public interface IBookRepository extends PagingAndSortingRepository<Book,Long>, JpaRepository<Book, Long>{
    @Query("""
    SELECT b FROM Book b
    WHERE b.title LIKE %?1%
    OR b.author LIKE %?1%
    OR b.category.name LIKE %?1%
    """)
    List<Book> searchBook(String keyword);
    default  List<Book> findAllBooks(Integer pageNo,
                                     Integer pageSize,
                                     String sortBy){
        return findAll(PageRequest.of(pageNo,
                pageSize,
                Sort.by(sortBy)))
                .getContent();
    }
}
