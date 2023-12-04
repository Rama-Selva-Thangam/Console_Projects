package com.ramaselvathangamm.chatbot.showprebookedbikes;

public class ShowPreBookedBikes {
	private ShowPreBookedBikesViewModel showPreBookedBikesViewModel;

	ShowPreBookedBikes() {
		showPreBookedBikesViewModel = new ShowPreBookedBikesViewModel(this);
	}
	public void showAvailableBikes() {
		showPreBookedBikesViewModel.showPreBookedBikes();
	}
}
