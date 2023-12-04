package com.ramaselvathangamm.chatbot.showprebookedbikes;

import com.ramaselvathangamm.chatbot.repository.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ramaselvathangamm.chatbot.dto.Bike;

class ShowPreBookedBikesViewModel {
	private ShowPreBookedBikes showPreBookedBikes;

	ShowPreBookedBikesViewModel(ShowPreBookedBikes showPreBookedBikes) {
		this.showPreBookedBikes = showPreBookedBikes;
	}

	void showPreBookedBikes() {
		HashMap<Long, Bike> bikes = Repository.getInstance().getBookedList();
		int i = 1;
		for (Map.Entry<Long, Bike> entry : bikes.entrySet()) {
			Bike bike = entry.getValue();
			System.out.println(i++ + " . ");
			System.out.print("Bike Model: " + bike.getModelName());
			System.out.print("Bike Name: " + bike.getBikeName());
			System.out.print("Booking ID: " + bike.getBookingID());
			System.out.print("Gear Model: " + (bike.isGeared() ? "Geared Type" : "Non Geared Type"));
			System.out.print("Petrol Capacity: " + bike.getPetrolCapacity());
			System.out.println("Price: " + bike.getPrice());
		}
	}

}
