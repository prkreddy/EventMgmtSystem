package edu.iiitb.ems.dao;

import edu.iiitb.ems.model.User;

public interface UserDAO
{

	String ID = "user_id";
	String USER_NAME = "user_name";
	String EMAIL = "email";
	String PASSWORD = "user_password";
	String USER_TYPE = "user_type";
	String BIRTH_DATE = "birth_date";
	String PHONE_NUMBER = "phone_number";
	String FIRST_NAME = "first_name";
	String LAST_NAME = "last_name";
	String SECRET_QUESTION = "security_question";
	String SECRET_ANSWER = "security_answer";
	String GENDER = "gender";

	User getUserByUserName(String username);

}