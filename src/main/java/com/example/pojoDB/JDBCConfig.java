package com.example.pojoDB;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConfig {

	private static String jdbcURL = "jdbc:postgresql://localhost:5432/demo";
	private static String jdbcUsername = "postgres";
	private static String jdbcPassword = "-klimkar-";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			Connection connection = JDBCConfig.getConnection();
			System.out.println("Success");

		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
    }
}
