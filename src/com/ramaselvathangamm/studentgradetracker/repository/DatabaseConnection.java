package com.ramaselvathangamm.studentgradetracker.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.ramaselvathangamm.studentgradetracker.dto.Student;

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
	public static void createTableIfNotExists() {
		try {
			String createTableSQL = "CREATE TABLE IF NOT EXISTS student_info(" + "rollNumber INT PRIMARY KEY NOT NULL,"
					+ "studentName VARCHAR(20) NOT NULL," + "dateOfBirth BIGINT NOT NULL" + ");";
			Statement statement = connection.createStatement();
			statement.execute(createTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
