package phantrivi_2011063105.lap3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import phantrivi_2011063105.lap3.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUserName(String username);
}
