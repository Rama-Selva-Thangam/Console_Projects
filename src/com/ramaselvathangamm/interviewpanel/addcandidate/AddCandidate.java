package com.ramaselvathangamm.interviewpanel.addcandidate;

import java.util.Scanner;

import com.ramaselvathangamm.interviewpanel.dto.Candidate;

public class AddCandidate {
	private AddCandidateViewModel addCandidateViewModel;

	public AddCandidate() {
		addCandidateViewModel = new AddCandidateViewModel(this);
	}

	public void addCandidate() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Candidate Name : ");
		String name = scan.nextLine();
		System.out.print("Enter the Qualification : ");
		String qualification = scan.nextLine();
		System.out.print("Enter the Date of Birth (DD-MM-YYYY): ");
		String dateOfBirth = scan.nextLine();
		System.out.print("Enter year of Passed Out : ");
		int yearOfPassedOut = scan.nextInt();
		scan.nextLine();
		boolean success = addCandidateViewModel.validate(name, qualification, dateOfBirth, yearOfPassedOut);
		if (success) {
			Candidate candidate = new Candidate(name, qualification, dateOfBirth, yearOfPassedOut);
			addCandidateViewModel.addToRepository(candidate);
		}
	}

	public void onSuccess() {
		System.out.println("Inserted Successfully");

	}

	public void showError(String errorMessage) {
		System.out.println(errorMessage);
	}
}
