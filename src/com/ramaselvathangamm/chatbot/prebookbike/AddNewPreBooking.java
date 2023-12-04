package com.ramaselvathangamm.chatbot.prebookbike;

import java.util.Scanner;

public class AddNewPreBooking {
	private AddNewPreBookingViewModel addNewPreBookingViewModel;

	AddNewPreBooking() {
		addNewPreBookingViewModel = new AddNewPreBookingViewModel(this);
	}

	public void addNewBooking() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Bike Name : ");
		String bikeName=scan.nextLine();
		System.out.print("Enter the Bike Model Name : ");
		String model=scan.nextLine();
		addNewPreBookingViewModel.preBook(bikeName,model);
		
	}
}
