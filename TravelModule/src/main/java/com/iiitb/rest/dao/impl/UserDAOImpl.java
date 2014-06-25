package com.iiitb.rest.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iiitb.rest.DBUtil.ConnectionPool;
import com.iiitb.rest.dao.UserDAO;
import com.iiitb.rest.model.User;

public class UserDAOImpl implements UserDAO
{

	final String GET_USER_BY_USER_NAME_QRY = "select * from User where user_name=?";

	@Override
	public User getUserByUserName(String username)
	{

		User user = null;
		Connection conn = ConnectionPool.getConnection();

		PreparedStatement preparedStmt;
		try
		{
			preparedStmt = conn.prepareStatement(GET_USER_BY_USER_NAME_QRY);
			preparedStmt.setString(1, username);

			ResultSet resultSet = preparedStmt.executeQuery();
			// System.out.println(resultSet.getFetchSize());
			// System.out.println(preparedStmt);

			while (resultSet.next())
			{

				user = new User();
				user.setUserId(resultSet.getInt(UserDAO.ID));
				user.setEmail(resultSet.getString(UserDAO.EMAIL));

				user.setPassword(resultSet.getString(UserDAO.PASSWORD));
				user.setDob(resultSet.getString(UserDAO.BIRTH_DATE));

				user.setPhoneNumber(resultSet.getString(UserDAO.PHONE_NUMBER));

				user.setFirstName(resultSet.getString(UserDAO.FIRST_NAME));
				user.setLastName(resultSet.getString(UserDAO.LAST_NAME));

				user.setSecretQuestion(resultSet.getString(UserDAO.SECRET_QUESTION));

				user.setSecretAnswer(resultSet.getString(UserDAO.SECRET_ANSWER));

				user.setUsername(username);
				user.setUserType(resultSet.getString(UserDAO.USER_TYPE));

				user.setGender(resultSet.getString(UserDAO.GENDER));

			}
		}
		catch (SQLException e)
		{

			e.printStackTrace();
		}
		finally
		{
			ConnectionPool.freeConnection(conn);

		}

		return user;
	}

}
