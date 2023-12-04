package com.ramaselvathangamm.interviewpanel.showtotalcandidates;

public class ViewTotalCandidates {
	private ViewTotalCandidatesViewModel viewRemaingCandidatesViewModel;

	public ViewTotalCandidates() {
		viewRemaingCandidatesViewModel = new ViewTotalCandidatesViewModel(this);
	}

	public void showTotalCandidates() {
		viewRemaingCandidatesViewModel.showTotalCandidates();
	}

}
