package phantrivi_2011063105.lap3.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import phantrivi_2011063105.lap3.Validator.annotation.ValidUserId;
import phantrivi_2011063105.lap3.entity.User;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if (user==null)
            return true;
        return user.getId()!=null;
    }
}
