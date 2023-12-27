package com.ramaselvathangamm.studentgradetracker.viewstudentgrade;

import java.util.ArrayList;
import java.util.Scanner;

import com.ramaselvathangamm.studentgradetracker.dto.Student;

public class ViewStudentGradeView {
	private ViewStudentGradeViewModel viewStudentGradeViewModel;

	public ViewStudentGradeView() {
		viewStudentGradeViewModel = new ViewStudentGradeViewModel(this);
	}

	public void viewStudentGrade() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Roll Number : ");
		int rollNumber = scan.nextInt();
		Student student = viewStudentGradeViewModel.getStudent(rollNumber);
		if (student != null) {
			showStudentInfo(student);
			ArrayList<String> data = viewStudentGradeViewModel.getGrade(student);
			if (!data.isEmpty()) {
				System.out.println("Grade Details:");
				System.out.printf("%-15s%-10s%-10s%-10s%-10s%-10s%-10s%n", "Month", "Subject1", "Subject2", "Subject3",
						"Subject4", "Subject5", "Grade");
				System.out.println("--------------------------------------------------------");

				for (String rowData : data) {
					String[] result = rowData.split(",");
					System.out.printf("%-15s%-10s%-10s%-10s%-10s%-10s%-10s%n", result[0], result[1], result[2],
							result[3], result[4], result[5], result[6]);
				}
			} else {
				System.out.println("No Data added");
			}
		} else {
			System.out.println("Student Not found");
		}
	}

	public void showStudentInfo(Student student) {
		System.out.println("Student Name : " + student.getStudentName() + " | " + "Student Roll Number : "
				+ student.getRollNumber()+" | " + "Date of Birth : " + student.getDateOfBirth());
	}
}
