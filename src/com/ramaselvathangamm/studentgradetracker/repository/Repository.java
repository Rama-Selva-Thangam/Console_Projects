package com.ramaselvathangamm.studentgradetracker.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.ramaselvathangamm.studentgradetracker.dto.Student;
import com.ramaselvathangamm.studentgradetracker.status.Status;

public class Repository {
	private static Repository repository;
	private Connection connection;

	private Repository() {
		try {
			connection = DatabaseConnection.getConnection();
			DatabaseConnection.createTableIfNotExists();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Repository getInstance() {
		synchronized (Repository.class) {
			if (repository == null) {
				repository = new Repository();
			}
			return repository;
		}
	}

	public void addNewStudent(Student student) {
		try {
			String insertStudentSQL = "INSERT INTO student_info(rollNumber, studentName, dateOfBirth) VALUES (?, ?, ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStudentSQL);
			preparedStatement.setInt(1, student.getRollNumber());
			preparedStatement.setString(2, student.getStudentName());
			preparedStatement.setLong(3, student.getDateOfBirth());
			preparedStatement.executeUpdate();
			createStudentTable(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int editStudent(Student student, String monthName, int subject1, int subject2, int subject3, int subject4,
			int subject5, String grade) {
		int rollNumber = student.getRollNumber();
		String tableName = "student_" + rollNumber;

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
				return Status.SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Status.ERROR_OCCURED;
		}
		return Status.SUCCESS;

	}

	public void createStudentTable(Student student) {
		try {
			int rollNumber = student.getRollNumber();
			String tableName = "student_" + rollNumber;
			String createTableSQL = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
					+ "monthOfGrade VARCHAR(10) PRIMARY KEY," + "subject1 INT," + "subject2 INT," + "subject3 INT,"
					+ "subject4 INT," + "subject5 INT," + "grade VARCHAR(2)" + ");";

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

	public ArrayList<String> getData(Student student) {
		ArrayList<String> rowDataList = new ArrayList<>();

		try {
			int rollNumber = student.getRollNumber();
			String tableName = "student_" + rollNumber;
			String selectDataSQL = "SELECT * FROM " + tableName + " ORDER BY CASE "
					+ "WHEN monthOfGrade = 'January' THEN 1 " + "WHEN monthOfGrade = 'February' THEN 2 "
					+ "WHEN monthOfGrade = 'March' THEN 3 " + "WHEN monthOfGrade = 'April' THEN 4 "
					+ "WHEN monthOfGrade = 'May' THEN 5 " + "WHEN monthOfGrade = 'June' THEN 6 "
					+ "WHEN monthOfGrade = 'July' THEN 7 " + "WHEN monthOfGrade = 'August' THEN 8 "
					+ "WHEN monthOfGrade = 'September' THEN 9 " + "WHEN monthOfGrade = 'October' THEN 10 "
					+ "WHEN monthOfGrade = 'November' THEN 11 " + "WHEN monthOfGrade = 'December' THEN 12 " + "END;";

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectDataSQL);

			while (resultSet.next()) {
				String rowData = resultSet.getString("monthOfGrade") + "," + resultSet.getInt("subject1") + ","
						+ resultSet.getInt("subject2") + "," + resultSet.getInt("subject3") + ","
						+ resultSet.getInt("subject4") + "," + resultSet.getInt("subject5") + ","
						+ resultSet.getString("grade");

				rowDataList.add(rowData);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowDataList;
	}

	public void closeConnection() {
		DatabaseConnection.closeConnection();
	}

}
