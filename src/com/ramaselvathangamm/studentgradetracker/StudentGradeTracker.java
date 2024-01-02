package com.ramaselvathangamm.studentgradetracker;

import java.util.Scanner;

import com.ramaselvathangamm.studentgradetracker.addnewstudent.AddNewStudentView;
import com.ramaselvathangamm.studentgradetracker.editstudentgrade.EditStudentGradeView;
import com.ramaselvathangamm.studentgradetracker.viewstudentgrade.ViewStudentGradeView;

public class StudentGradeTracker {

	public static void main(String[] args) {
		StudentGradeTracker studentGradeTracker = new StudentGradeTracker();
		studentGradeTracker.init();
	}

	public void init() {
		Scanner scan = new Scanner(System.in);
		int choice;
		do {
			System.out.println(
					"Enter the Option :\n1.Add New Student\n2.Edit Student Marks\n3.View Student Grade\n0.Exit");
			System.out.println("--------------------------------------------------------------");
			choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
			case 1:
				AddNewStudentView addNewStudentView = new AddNewStudentView();
				addNewStudentView.addNewStudent();
				System.out.println("---------------------------------------------------------");
				break;
			case 2:
				EditStudentGradeView editStudentGradeView = new EditStudentGradeView();
				editStudentGradeView.editStudentGrade();
				System.out.println("---------------------------------------------------------");
				break;
			case 3:
				ViewStudentGradeView viewStudentGradeView = new ViewStudentGradeView();
				viewStudentGradeView.viewStudentGrade();
				System.out.println("---------------------------------------------------------");
				break;
			case 0:
				break;
			default:
				System.out.println("Enter valid Input");
			}

		} while (choice != 0);
		System.out.println("THANK YOU !");
	}

}
