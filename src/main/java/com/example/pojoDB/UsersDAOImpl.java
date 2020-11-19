package com.example.pojoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class UsersDAOImpl implements UsersDAO {

	public User getUser(Integer id) {

		try {
			Connection connection = JDBCConfig.getConnection();

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM public.users WHERE user_id=" + id);

			if (resultSet.next()) {

				return extractUserFromResultSet(resultSet);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {

		User user = new User();

		user.setUser_id(resultSet.getInt("user_id"));
		user.setName(resultSet.getString("name"));
		user.setEmail(resultSet.getString("email"));
		user.setPassword(resultSet.getString("password"));
		user.setCountry(resultSet.getString("country"));

		return user;

	}

	public Set<User> getAllUsers() {

		try {
			Connection connection = JDBCConfig.getConnection();

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM public.users;");
			Set<User> result = new HashSet<User>();

			while (resultSet.next()) {

				User user = extractUserFromResultSet(resultSet);
				result.add(user);

			}

			return result;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public User getUserByUserNameAndPassword(String user, String pass) {
		try {
			Connection connection = JDBCConfig.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.users WHERE name = ? AND password = ? ;" );

			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			
			
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {

				return extractUserFromResultSet(resultSet);

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public String batchInsertUser(Set<User> users) {
		
		
		try {
			
			Connection connection = JDBCConfig.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT into public.users VALUES(?,?,?,?,? )");

			
			for (User user : users) {
				
				preparedStatement.setInt(1, user.getUser_id());
				preparedStatement.setString(2, user.getName());
				preparedStatement.setString(3, user.getEmail());
				preparedStatement.setString(4, user.getCountry());
				preparedStatement.setString(5, user.getPassword());
				
				preparedStatement.addBatch();
				
			}
			
			preparedStatement.executeBatch();
			return "Success";
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return "Failed";
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
