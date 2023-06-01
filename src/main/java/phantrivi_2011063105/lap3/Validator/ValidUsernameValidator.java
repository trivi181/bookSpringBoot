package phantrivi_2011063105.lap3.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import phantrivi_2011063105.lap3.Validator.annotation.ValidUsername;
import phantrivi_2011063105.lap3.repository.IUserRepository;
public class ValidUsernameValidator implements ConstraintValidator<ValidUsername,String> {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        if (userRepository==null)
            return true;
        return userRepository.findByUserName(username)==null;
    }
}
