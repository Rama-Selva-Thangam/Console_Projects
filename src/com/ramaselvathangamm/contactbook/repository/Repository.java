package com.ramaselvathangamm.contactbook.repository;

import java.util.Map;
import java.util.TreeMap;

import com.ramaselvathangamm.contactbook.dto.Contact;

public class Repository {
	private static Repository repository;
	private Map<String, Contact> contactList = new TreeMap<String, Contact>();

	private Repository() {

	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	public Map<String, Contact> getContactList() {
		return contactList;
	}

	public void setContactList(Map<String, Contact> contactList) {
		this.contactList = contactList;
	}

	public void addNewContact(String contactName, Contact contact) {
		contactList.put(contactName, contact);
	}
}
