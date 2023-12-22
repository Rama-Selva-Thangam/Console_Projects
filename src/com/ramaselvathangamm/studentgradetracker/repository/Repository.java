package com.ramaselvathangamm.studentgradetracker.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ramaselvathangamm.personaldiary.dto.Diary;
import com.ramaselvathangamm.studentgradetracker.dto.Student;

public class Repository {
	private static Repository repository;
	private Connection connection;

	private Repository() {
		try {
			connection = DatabaseConnection.getConnection();
			createTableIfNotExists();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	public void createTableIfNotExists() {
		try {
			String createTableSQL = "CREATE TABLE IF NOT EXISTS student_info(" + "rollNumber INT PRIMARY KEY NOT NULL,"
					+ "studentName VARCHAR(20) NOT NULL," + "dateOfBirth BIGINT NOT NULL" + ");";
			Statement statement = connection.createStatement();
			statement.execute(createTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		DatabaseConnection.closeConnection();
	}

	public void addNewStudent(Student student) {
		try {
			String insertStudentSQL = "INSERT INTO student_info(rollNumber, studentName, dateOfBirth) VALUES (?, ?, ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStudentSQL);
			preparedStatement.setInt(1, student.getRollNumber());
			preparedStatement.setString(2, student.getStudentName());
			preparedStatement.setLong(3, student.getDateOfBirth());
			int rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isValidRollNumber(int rollNumber) {
		try {
			String query = "SELECT count(*) FROM student_info WHERE rollNumber = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, rollNumber);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				return count == 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void createStudentTable(Student student) {
		try {
			int tableName = student.getRollNumber();
			String createTableSQL = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
					+ "monthOfGrade VARCHAR(10) PRIMARY KEY," + "subject1 INT," + "subject2 INT," + "subject3 INT,"
					+ "subject4 INT," + "subject5 INT," + "grade CHAR(1)" + ");";

			Statement statement = connection.createStatement();
			statement.execute(createTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Student getStudent(int rollNumber) {
		try {
			String query = "SELECT * FROM student_info WHERE rollNumber = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, rollNumber);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int retrievedRollNumber = resultSet.getInt("rollNumber");
				String studentName = resultSet.getString("studentName");
				long dateOfBirth = resultSet.getLong("dateOfBirth");

				return new Student(retrievedRollNumber, studentName, dateOfBirth);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public void editStudent(Student student, String monthName, int subject1, int subject2, int subject3, int subject4,
			int subject5, String grade) {
		int tableName = student.getRollNumber();

		try {
			String updateSQL = "UPDATE " + tableName
					+ " SET subject1 = ?, subject2 = ?, subject3 = ?, subject4 = ?, subject5 = ?, grade = ? WHERE monthOfGrade = ?";
			PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
			updateStatement.setInt(1, subject1);
			updateStatement.setInt(2, subject2);
			updateStatement.setInt(3, subject3);
			updateStatement.setInt(4, subject4);
			updateStatement.setInt(5, subject5);
			updateStatement.setString(6, grade);
			updateStatement.setString(7, monthName);
			int rowsUpdated = updateStatement.executeUpdate();
			if (rowsUpdated == 0) {
				String insertSQL = "INSERT INTO " + tableName
						+ " (monthOfGrade, subject1, subject2, subject3, subject4, subject5, grade) VALUES (?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
				insertStatement.setString(1, monthName);
				insertStatement.setInt(2, subject1);
				insertStatement.setInt(3, subject2);
				insertStatement.setInt(4, subject3);
				insertStatement.setInt(5, subject4);
				insertStatement.setInt(6, subject5);
				insertStatement.setString(7, grade);
				insertStatement.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
