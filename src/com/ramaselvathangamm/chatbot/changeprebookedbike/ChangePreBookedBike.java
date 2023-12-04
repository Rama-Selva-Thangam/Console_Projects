package com.ramaselvathangamm.chatbot.changeprebookedbike;

import java.util.Scanner;

public class ChangePreBookedBike {
	private ChangePreBookedBikeViewModel changePreBookedBikeViewModel;

	ChangePreBookedBike() {
		changePreBookedBikeViewModel = new ChangePreBookedBikeViewModel(this);
	}

	public void changeBookedBike() {
		Scanner scan = new Scanner(System.in);
		changePreBookedBikeViewModel.showPreBookedBikes();
		System.out.print("Enter Booking ID : ");
		long bookingID = scan.nextLong();
		scan.nextLine();
		System.out.print("Enter the Bike Name : ");
		String bikeName = scan.nextLine();
		System.out.print("Enter the Model Name : ");
		String model = scan.nextLine();
		changePreBookedBikeViewModel.changeBookedBike(bookingID, bikeName, model);

	}
}
