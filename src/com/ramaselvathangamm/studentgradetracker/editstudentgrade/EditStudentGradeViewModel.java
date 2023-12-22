package com.ramaselvathangamm.studentgradetracker.editstudentgrade;

import com.ramaselvathangamm.studentgradetracker.repository.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ramaselvathangamm.studentgradetracker.dto.Student;

class EditStudentGradeViewModel {
	private EditStudentGradeView editStudentGradeView;

	public EditStudentGradeViewModel(EditStudentGradeView editStudentGradeView) {
		this.editStudentGradeView = editStudentGradeView;
	}

	public Student getStudent(int rollNumber) {
		Student student = Repository.getInstance().getStudent(rollNumber);
		return student;
	}

	public void editStudentGrade(Student student, int monthNumber, int subject1, int subject2, int subject3,
			int subject4, int subject5) {
		if (monthNumber >= 1 && monthNumber <= 12) {
			Date date = new Date();
			date.setMonth(monthNumber - 1);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM");
			String monthName = dateFormat.format(date);
			int calculate = ((subject1 + subject2 + subject3 + subject4 + subject5) / 5) * 100;
			String grade = (calculate >= 91) ? "A+"
					: (calculate >= 81) ? "A"
							: (calculate >= 71) ? "B+"
									: (calculate >= 61) ? "B" : (calculate >= 51) ? "C" : (calculate >= 41) ? "D" : "U";
			Repository.getInstance().editStudent(student, monthName, subject1, subject2, subject3, subject4, subject5,
					grade);

		} else {
			System.out.println("Invalid Month");
			return;
		}

	}

}
