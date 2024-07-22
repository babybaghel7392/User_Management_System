package com.user.test.exception;

public class UserException extends RuntimeException {
		public UserException(Long id)
		{
			super("User not found with this id :"+ id);
		}
}
