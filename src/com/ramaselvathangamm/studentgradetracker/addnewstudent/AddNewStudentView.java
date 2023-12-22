package com.ramaselvathangamm.studentgradetracker.addnewstudent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
		if (status == 0) {
			System.out.println("Student added Successfully");
		} else if (status == 1) {
			System.out.println("Student Name Cannot be Empty");
		} else if (status == 2) {
			System.out.println("Invalid Date of Birth");
		} else if (status == 3) {
			System.out.println("Roll Number already Exists");
		}
	}

	public static void main(String[] args) {
		new AddNewStudentView().addNewStudent();
	}
}
