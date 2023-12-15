package com.ramaselvathangamm.contactbook.contactmanager;

import java.util.Map;

import com.ramaselvathangamm.contactbook.dto.Contact;
import com.ramaselvathangamm.contactbook.repository.Repository;

class ContactViewModel {
	private ContactView contactView;

	ContactViewModel(ContactView contactView) {
		this.contactView = contactView;
	}

	int addNewContact(String firstName, String lastName, String mobileNumber, String email) {
		boolean validMobileNumber = isValidMobileNumber(mobileNumber);
		boolean validEmail = isValidEmail(email);
		if (!validMobileNumber) {
			return 1;
		}
		if (!email.equalsIgnoreCase("null")) {
			if (!validEmail) {
				return 2;
			}
		}
		Map<String, Contact> list = Repository.getInstance().getContactList();
		if (!list.containsKey(firstName + " " + lastName)) {
			Contact newContact = new Contact(firstName, lastName, mobileNumber, email);
			Repository.getInstance().addNewContact(firstName + " " + lastName, newContact);
			return 0;
		} else {
			return 3;
		}
	}

	void viewContacts() {
		Map<String, Contact> list = Repository.getInstance().getContactList();
		if (list.isEmpty()) {
			System.out.println("No Contacts Saved");
			return;
		}
		for (Map.Entry<String, Contact> entry : list.entrySet()) {
			String name = entry.getKey();
			Contact contact = entry.getValue();
			System.out.printf("Name :\t\t%s%n", name);
			System.out.printf("Contact Number :\t%s%n", contact.getContactNumber());
			System.out.printf("Email :\t\t%s%n", contact.getEmail());
			System.out.println("------------------------------");
		}

	}

	boolean isContactAvailable(String contactName) {
		Map<String, Contact> list = Repository.getInstance().getContactList();
		return list.containsKey(contactName);
	}

	int editContact(String contactName, String newName, String mobileNumber, String email) {
		Contact contact = Repository.getInstance().getContactList().get(contactName);
		if (!isValidMobileNumber(mobileNumber)) {
			return 1;
		}
		if (!email.equals("null")) {
			if (!isValidEmail(email)) {
				return 2;
			}
		}
		if (Repository.getInstance().getContactList().containsKey(newName)) {
			return 3;
		}
		contact.setFirstName(newName);
		contact.setContactNumber(mobileNumber);
		contact.setEmail(email);
		Repository.getInstance().addNewContact(newName, contact);
		Repository.getInstance().getContactList().remove(contactName);
		return 0;
	}

	boolean deleteContact(String contactName) {
		viewContacts();
		return Repository.getInstance().getContactList().remove(contactName) != null;
	}

	private boolean isValidEmail(String email) {
		return email.matches("^[a-zA-Z]+[a-zA-Z0-9._]*@[a-zA-Z]+\\.[a-zA-Z]{2,}$");
	}

	private boolean isValidMobileNumber(String mobileNumber) {
		return mobileNumber.matches("^(\\+91|91|0)?[789]\\d{9}$");
	}

}
