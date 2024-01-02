package com.ramaselvathangamm.studentgradetracker.addnewstudent;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ramaselvathangamm.studentgradetracker.dto.Student;
import com.ramaselvathangamm.studentgradetracker.repository.Repository;
import com.ramaselvathangamm.studentgradetracker.status.Status;

class AddNewStudentViewModel {
	private AddNewStudentView addNewStudentView;

	public AddNewStudentViewModel(AddNewStudentView addNewStudentView) {
		this.addNewStudentView = addNewStudentView;
	}

	public int addNewStudent(String studentName, long dateOfBirth, int rollNumber) {
		if (studentName.isEmpty()) {
			return Status.EMPTY_STUDENT_NAME;
		}
		if (!isValidDateOfBirth(dateOfBirth)) {
			return Status.INVALID_DATEOFBIRTH;
		}
		if (!isValidRollNumber(rollNumber)) {
			return Status.EXISTING_ROLL_NUMBER;
		}
		Student student = new Student(rollNumber, studentName, dateOfBirth);
		Repository.getInstance().addNewStudent(student);
		return Status.SUCCESS;
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
