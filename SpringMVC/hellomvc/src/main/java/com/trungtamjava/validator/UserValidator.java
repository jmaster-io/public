package com.trungtamjava.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.model.User;

@Component
public class UserValidator implements Validator {
	@Autowired
	UserDao userDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		///
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "input.required");

		if (user.getPassword() == null || user.getPassword().length() < 6 || user.getPassword().length() > 10) {
			errors.rejectValue("password", "password.require");
		}

		if (user.getUsername() == null || user.getUsername().length() < 6 || user.getUsername().length() > 10) {
			errors.rejectValue("username", "username.require");
		} else {
			// check db co username nay chua
			User existingUser = userDao.getByUsername(user.getUsername());
			if (existingUser != null) {
				errors.rejectValue("username", "username.existed");
			}
		}
	}

}
