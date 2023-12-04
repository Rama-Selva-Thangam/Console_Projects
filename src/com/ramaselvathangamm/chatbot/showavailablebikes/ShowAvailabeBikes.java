package com.ramaselvathangamm.chatbot.showavailablebikes;

public class ShowAvailabeBikes {
	private ShowAvailableBikesViewModel showAvailableBikesViewModel;

	ShowAvailabeBikes() {
		showAvailableBikesViewModel = new ShowAvailableBikesViewModel(this);
	}
	public void showAvailableBikes() {
		showAvailableBikesViewModel.showBikes();
	}
}
