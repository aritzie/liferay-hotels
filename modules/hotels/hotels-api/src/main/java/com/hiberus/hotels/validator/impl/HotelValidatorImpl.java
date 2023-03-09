package com.hiberus.hotels.validator.impl;

import com.hiberus.hotels.exception.HotelValidationException;
import com.hiberus.hotels.validator.HotelValidator;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		service = HotelValidator.class
	)
public class HotelValidatorImpl implements HotelValidator {

	@Override
	public void validate(String email) throws HotelValidationException {
		
		List<String> errors = new ArrayList<String>();
		
		if(!isHotelValid(email, errors)) {
			throw new HotelValidationException(errors);
		}
	}
	
	private boolean isHotelValid(String email, List<String> errors) {
		boolean result = true;
		
		result &= isEmailValid(email, errors);
		
		return result;
	}
	
	private boolean isEmailValid(String email, List<String> errors) {
		boolean result = true;
		
		if(!Validator.isEmailAddress(email)) {
			errors.add("emailInvalid");
			result = false;
		}
		
		return result;
	}

}
