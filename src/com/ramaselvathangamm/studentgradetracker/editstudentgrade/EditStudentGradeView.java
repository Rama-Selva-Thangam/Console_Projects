package com.ramaselvathangamm.studentgradetracker.editstudentgrade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.ramaselvathangamm.studentgradetracker.dto.Student;
import com.ramaselvathangamm.studentgradetracker.status.Status;

public class EditStudentGradeView {
	private EditStudentGradeViewModel editStudentGradeViewModel;

	public EditStudentGradeView() {
		editStudentGradeViewModel = new EditStudentGradeViewModel(this);
	}

	public void editStudentGrade() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Roll Number : ");
		int rollNumber = scan.nextInt();
		Student student = editStudentGradeViewModel.getStudent(rollNumber);
		if (student != null) {
			showStudentInfo(student);
			System.out.print("Enter the month number to edit or add : ");
			int month = scan.nextInt();
			System.out.println("Each Subject carry atmost 100 marks : ");
			System.out.print("Enter Subject 1 mark : ");
			int subject1 = scan.nextInt();
			System.out.print("Enter Subject 2 mark : ");
			int subject2 = scan.nextInt();
			System.out.print("Enter Subject 3 mark : ");
			int subject3 = scan.nextInt();
			System.out.print("Enter Subject 4 mark : ");
			int subject4 = scan.nextInt();
			System.out.print("Enter Subject 5 mark : ");
			int subject5 = scan.nextInt();
			scan.nextLine();
			int status = editStudentGradeViewModel.editStudentGrade(student, month, subject1, subject2, subject3,
					subject4, subject5);
			if (status == Status.SUCCESS) {
				System.out.println("Data added Successfully");
			} else if (status == Status.INVALID_MONTH) {
				System.out.println("Invalid Month");
			} else if (status == Status.ERROR_OCCURED) {
				System.out.println("Error Occured");
			}
		} else {
			System.out.println("Student Not found");
		}
	}

	public void showStudentInfo(Student student) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = dateFormat.format(new Date(student.getDateOfBirth()));

		System.out.println("Student Name : " + student.getStudentName() + " | " + "Student Roll Number : "
				+ student.getRollNumber() + " | " + "Date of Birth : " + formattedDate);
	}

}
