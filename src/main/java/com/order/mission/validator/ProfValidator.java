package com.order.mission.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.order.mission.model.UserModel;
import com.order.mission.services.IServiceProf;

@Component
public class ProfValidator implements Validator{

	@Autowired
    private IServiceProf sp;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserModel user = (UserModel) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matricule", "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("matricule", "Size.userForm.matricule");
        }
        if (sp.getProfByMatricule(user.getUsername()) != null) {
            errors.rejectValue("matricule", "Duplicate.userForm.matricule");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
		
	}
	
	

}
