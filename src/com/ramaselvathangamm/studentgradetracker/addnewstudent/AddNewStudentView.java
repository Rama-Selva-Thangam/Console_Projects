package com.ramaselvathangamm.studentgradetracker.addnewstudent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.ramaselvathangamm.studentgradetracker.status.Status;

public class AddNewStudentView {
	private AddNewStudentViewModel addNewStudentViewModel;

	public AddNewStudentView() {
		addNewStudentViewModel = new AddNewStudentViewModel(this);
	}

	public void addNewStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Student Name : ");
		String studentName = scan.nextLine();
		System.out.print("Enter the Date of Birth in DD-MM-YYYY : ");
		String dateOfBirth = scan.nextLine();
		long dob = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date date = sdf.parse(dateOfBirth);
			dob = date.getTime();

		} catch (Exception e) {
			System.out.println("Invalid Date of Birth Format");
		}
		System.out.print("Enter the Roll Number : ");
		int rollNumber = scan.nextInt();
		scan.nextLine();
		int status = addNewStudentViewModel.addNewStudent(studentName, dob, rollNumber);
		if (status == Status.SUCCESS) {
			System.out.println("Student added Successfully");
		} else if (status == Status.EMPTY_STUDENT_NAME) {
			System.out.println("Student Name Cannot be Empty");
		} else if (status == Status.INVALID_DATEOFBIRTH) {
			System.out.println("Invalid Date of Birth");
		} else if (status == Status.EXISTING_ROLL_NUMBER) {
			System.out.println("Roll Number already Exists");
		}
	}
}
