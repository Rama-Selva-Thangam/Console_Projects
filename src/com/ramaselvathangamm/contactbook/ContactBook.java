package com.ramaselvathangamm.contactbook;

import java.util.Scanner;

import com.ramaselvathangamm.contactbook.contactmanager.ContactView;

public class ContactBook {
	public static void main(String[] args) {
		ContactBook contactBook = new ContactBook();
		contactBook.init();
	}

	private void init() {
		Scanner scan = new Scanner(System.in);
		ContactView contactView = new ContactView();
		System.out.println("--- CONTACTS ---");
		boolean loop = true;
		int choice;
		do {
			System.out.println("-------------------------------");
			System.out.println(
					"Enter an option :\n1.Add New Contact\n2.View Contacts\n3.Update Contact\n4.Delete Contact\n0.Exit");
			System.out.println("-------------------------------");
			choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
			case 1:
				contactView.addNewContact();
				break;
			case 2:
				contactView.viewContacts();
				break;
			case 3:
				contactView.editContact();
				break;
			case 4:
				contactView.deleteContact();
				break;
			case 0:
				loop = false;
				break;
			default:
				System.out.println("Enter valid option");
			}
		} while (loop);
		System.out.println("Thank you !");
	}

}
