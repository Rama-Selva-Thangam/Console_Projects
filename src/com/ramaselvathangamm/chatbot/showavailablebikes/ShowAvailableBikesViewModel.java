package com.ramaselvathangamm.chatbot.showavailablebikes;

import com.ramaselvathangamm.chatbot.repository.Repository;
import java.util.ArrayList;
import com.ramaselvathangamm.chatbot.dto.Bike;

class ShowAvailableBikesViewModel {
	private ShowAvailabeBikes showAvailableBikes;

	ShowAvailableBikesViewModel(ShowAvailabeBikes showAvailableBikes) {
		this.showAvailableBikes = showAvailableBikes;
	}

	void showBikes() {
		ArrayList<Bike> bikes = Repository.getInstance().getBikes();
		for (Bike bike : bikes) {
			System.out.print("Bike Model : " + bike.getModelName());
			System.out.print("Bike Name : " + bike.getBikeName());
			System.out.print("Gear Model : " + (bike.isGeared() ? "Geared Type" : "Non Geared Type"));
			System.out.print("Petrol Capacity : " + bike.getPetrolCapacity());
			System.out.println("Price : " + bike.getPrice());
		}
	}

}
