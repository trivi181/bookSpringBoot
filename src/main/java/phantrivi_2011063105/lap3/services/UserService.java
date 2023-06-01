package phantrivi_2011063105.lap3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phantrivi_2011063105.lap3.entity.User;
import phantrivi_2011063105.lap3.repository.IUserRepository;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
}
