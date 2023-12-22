package com.ramaselvathangamm.studentgradetracker.addnewstudent;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ramaselvathangamm.studentgradetracker.dto.Student;
import com.ramaselvathangamm.studentgradetracker.repository.Repository;

class AddNewStudentViewModel {
	private AddNewStudentView addNewStudentView;

	public AddNewStudentViewModel(AddNewStudentView addNewStudentView) {
		this.addNewStudentView = addNewStudentView;
	}

	public int addNewStudent(String studentName, long dateOfBirth, int rollNumber) {
		if (studentName.isEmpty()) {
			return 1;
		}
		if (!isValidDateOfBirth(dateOfBirth)) {
			return 2;
		}
		if (!isValidRollNumber(rollNumber)) {
			return 3;
		}
		Student student = new Student(rollNumber, studentName, dateOfBirth);
		Repository.getInstance().addNewStudent(student);
		Repository.getInstance().createStudentTable(student);
		return 0;
	}

	private boolean isValidRollNumber(int rollNumber) {
		return Repository.getInstance().isValidRollNumber(rollNumber);
	}

	private boolean isValidDateOfBirth(long dateOfBirth) {
		Date dobDate = new Date(dateOfBirth);
		int startYear = 1995;
		int endYear = 2003;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int birthYear = Integer.parseInt(sdf.format(dobDate));
		return birthYear >= startYear && birthYear <= endYear;
	}

}
