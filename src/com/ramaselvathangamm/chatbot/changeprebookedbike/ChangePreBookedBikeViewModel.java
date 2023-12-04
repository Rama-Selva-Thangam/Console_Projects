package com.ramaselvathangamm.chatbot.changeprebookedbike;

import com.ramaselvathangamm.chatbot.repository.Repository;

import java.util.HashMap;
import java.util.Map;

import com.ramaselvathangamm.chatbot.dto.Bike;
import com.ramaselvathangamm.chatbot.showprebookedbikes.ShowPreBookedBikes;

class ChangePreBookedBikeViewModel {
	private ChangePreBookedBike changePreBookedBike;

	ChangePreBookedBikeViewModel(ChangePreBookedBike changePreBookedBike) {
		this.changePreBookedBike = changePreBookedBike;
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

	void changeBookedBike(long bookingID, String bikeName, String model) {
		Bike booked = Repository.getInstance().getBookedList().get(bookingID);
		if (booked != null) {
			if (booked != null) {
				Bike newBooked = null;
				Repository.getInstance().getBookedList().replace(bookingID, newBooked);
				newBooked.setBookingID(bookingID);
			}
		} else {
			System.out.println("Sorry Invalid Booking ID or Bike Not found");
		}
	}

}
