package com.ramaselvathangamm.studentgradetracker.dto;

import java.util.HashMap;
import java.util.Map;

public class Student {
	private int rollNumber;
	private String studentName;
	private long dateOfBirth;

	public Student(int rollNumber, String studentName, long dateOfBirth) {
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.dateOfBirth = dateOfBirth;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public long getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
