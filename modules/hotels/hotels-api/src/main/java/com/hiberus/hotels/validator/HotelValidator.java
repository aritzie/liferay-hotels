package com.hiberus.hotels.validator;

import com.hiberus.hotels.exception.HotelValidationException;

public interface HotelValidator {
	
	public void validate(String email) throws HotelValidationException;
}
