package com.ramaselvathangamm.personaldiary.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ramaselvathangamm.personaldiary.dto.Diary;

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
			String createTableSQL = "CREATE TABLE IF NOT EXISTS notes (" + "time_of_written BIGINT PRIMARY KEY,"
					+ "note VARCHAR(255) NOT NULL)";
			Statement statement = connection.createStatement();
			statement.execute(createTableSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int writeNote(Diary diary) {
		String query = "INSERT INTO notes VALUES (?,?)";
		int noOfrows = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, diary.getDate());
			statement.setString(2, diary.getNotes());
			noOfrows = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noOfrows;
	}

	public ArrayList<Diary> readNote() {
		ArrayList<Diary> notes = new ArrayList<Diary>();
		String query = "SELECT time_of_written, note FROM notes";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				long date = resultSet.getLong(1);
				String note = resultSet.getString(2);
				Diary diary = new Diary(date, note);
				notes.add(diary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notes;

	}

	public ArrayList<Diary> searchNotes(String keyword) {
		ArrayList<Diary> notes = new ArrayList<Diary>();
		String query = "SELECT * FROM notes WHERE note LIKE ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				long date = resultSet.getLong("time_of_written");
				String note = resultSet.getString("note");
				Diary diary = new Diary(date, note);
				notes.add(diary);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return notes;
	}

	public void closeConnection() {
		DatabaseConnection.closeConnection();
	}
}
