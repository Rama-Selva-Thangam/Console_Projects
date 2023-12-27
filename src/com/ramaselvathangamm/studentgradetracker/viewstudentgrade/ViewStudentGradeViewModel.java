package com.ramaselvathangamm.studentgradetracker.viewstudentgrade;

import java.util.ArrayList;

import com.ramaselvathangamm.studentgradetracker.dto.Student;
import com.ramaselvathangamm.studentgradetracker.repository.Repository;

class ViewStudentGradeViewModel {
	private ViewStudentGradeView viewStudentGradeView;

	public ViewStudentGradeViewModel(ViewStudentGradeView viewStudentGradeView) {
		this.viewStudentGradeView = viewStudentGradeView;
	}

	public Student getStudent(int rollNumber) {
		Student student = Repository.getInstance().getStudent(rollNumber);
		return student;
	}

	public ArrayList<String> getGrade(Student student) {
		ArrayList<String> data = Repository.getInstance().getData(student);
		return data;
	}

}
