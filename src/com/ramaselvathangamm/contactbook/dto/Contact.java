package com.ramaselvathangamm.contactbook.dto;

public class Contact {
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String email;

	public Contact(String firstName, String lastName, String mobileNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = mobileNumber;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
