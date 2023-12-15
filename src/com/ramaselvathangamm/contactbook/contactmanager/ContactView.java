package com.ramaselvathangamm.contactbook.contactmanager;

import java.util.Scanner;

public class ContactView {
	private ContactViewModel contactViewModel;

	public ContactView() {
		contactViewModel = new ContactViewModel(this);
	}

	public void addNewContact() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the First Name : ");
		String firstName = scan.nextLine();
		System.out.print("Enter the Last Name : ");
		String lastName = scan.nextLine();
		System.out.print("Enter the Mobile Number : ");
		String mobileNumber = scan.nextLine();
		System.out.print("Enter the Email if Exist (if Not Exist enter null): ");
		String email = scan.nextLine();
		int status = contactViewModel.addNewContact(firstName, lastName, mobileNumber, email);
		if (status == 0) {
			System.out.println("Contact Successfully Added");
		} else if (status == 1) {
			System.out.println("Invalid Mobile Number");
		} else if (status == 2) {
			System.out.println("Invalid Email Address");
		} else if (status == 3) {
			System.out.println("Contact Already Exist");
		}

	}

	public void viewContacts() {
		contactViewModel.viewContacts();
	}

	public void editContact() {
		Scanner scan = new Scanner(System.in);
		contactViewModel.viewContacts();
		System.out.print("Enter the Contact Name : ");
		String contactName = scan.nextLine();
		boolean isAvailable = contactViewModel.isContactAvailable(contactName);
		if (isAvailable) {
			System.out.print("Enter the New Name : ");
			String newName = scan.nextLine();
			System.out.print("Enter the Mobile  Number : ");
			String mobileNumber = scan.nextLine();
			System.out.print("Enter the Email if Exist (if Not Exist enter null): ");
			String email = scan.nextLine();
			int status = contactViewModel.editContact(contactName, newName, mobileNumber, email);
			if (status == 0) {
				System.out.println("Contact Successfully updated");
			} else if (status == 1) {
				System.out.println("Invalid Mobile Number");
			} else if (status == 2) {
				System.out.println("Invalid Email Address");
			} else if (status == 3) {
				System.out.println("Contact Already Exist");
			}
		} else {
			System.out.println("Contact Not Found");
		}
	}

	public void deleteContact() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Contact Name : ");
		String contactName = scan.nextLine();
		boolean isAvailable = contactViewModel.isContactAvailable(contactName);
		if (isAvailable) {
			boolean deleted = contactViewModel.deleteContact(contactName);
			if (deleted) {
				System.out.println("Successfully Deleted");
			}

		} else {
			System.out.println("Contact Not Found");
		}
	}
}
