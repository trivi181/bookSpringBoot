package phantrivi_2011063105.lap3.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import phantrivi_2011063105.lap3.Validator.annotation.ValidCategoryId;
import phantrivi_2011063105.lap3.entity.Category;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context){
        return category != null && category.getId()!= null;
    }
}
