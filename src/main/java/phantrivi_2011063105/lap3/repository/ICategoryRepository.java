package phantrivi_2011063105.lap3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phantrivi_2011063105.lap3.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
