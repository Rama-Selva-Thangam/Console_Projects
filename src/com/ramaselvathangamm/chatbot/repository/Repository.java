package com.ramaselvathangamm.chatbot.repository;

import com.ramaselvathangamm.chatbot.dto.Bike;

import java.util.ArrayList;
import java.util.HashMap;

public class Repository {
	private static Repository repository;
	private HashMap<Long, Bike> bikesBooked = new HashMap<Long, Bike>();
	private ArrayList<Bike> bikes=new ArrayList<Bike>();

	private Repository() {

	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	public HashMap<Long, Bike> getBookedList() {
		return bikesBooked;
	}

	private void setBikesBooked(HashMap<Long, Bike> bikesBooked) {
		this.bikesBooked = bikesBooked;
	}

	public ArrayList<Bike> getBikes() {
		return bikes;
	}

}
