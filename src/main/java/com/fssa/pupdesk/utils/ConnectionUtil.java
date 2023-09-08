package com.fssa.pupdesk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for establishing database connections.
 */
public class ConnectionUtil {

	/**
	 * Establishes a connection to the database using environment variables.
	 *
	 * @return A database connection.
	 * @throws RuntimeException If there is an issue connecting to the database.
	 */
	public Connection getConnection() {

		String dbUrl;
		String dbUser;
		String dbPassword;

		// Retrieve database connection details from environment variables
		dbUrl = System.getenv("DB_URL");
		dbUser = System.getenv("DB_USER");
		dbPassword = System.getenv("DB_PASSWORD");

		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create and return a database connection
			return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to the database", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Driver Not Found");
		}
	}
}