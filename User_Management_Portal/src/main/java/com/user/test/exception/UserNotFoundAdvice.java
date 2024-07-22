package com.user.test.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(UserException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	 public Map<String,String> exceptionHandler(UserException exc)
	 {
		Map<String,String> errormap= new HashMap<>();
		errormap.put("errormessage", exc.getMessage());
		return errormap;
	 }
}
