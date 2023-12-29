package com.ramaselvathangamm.studentgradetracker.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/student_grade_tracker";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "1#Thangam";
	private static Connection connection;

	private DatabaseConnection() {
	}

	public static Connection getConnection() throws SQLException {
		synchronized (DatabaseConnection.class) {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			}
			return connection;
		}
	}

	public static void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
