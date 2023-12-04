package com.ramaselvathangamm.interviewpanel.showcurrentcandidate;

public class ShowCurrentCandidate {
	private ShowCurrentCandidateViewModel showCurrentCandidateViewModel;

	public ShowCurrentCandidate() {
		showCurrentCandidateViewModel = new ShowCurrentCandidateViewModel(this);
	}

	public void showCurrentCandidate() {
		showCurrentCandidateViewModel.showCurrentCandidate();
	}
}
