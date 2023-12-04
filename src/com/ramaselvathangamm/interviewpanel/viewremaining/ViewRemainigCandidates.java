package com.ramaselvathangamm.interviewpanel.viewremaining;

public class ViewRemainigCandidates {
	private ViewRemaingCandidatesViewModel viewRemaingCandidatesViewModel;

	public ViewRemainigCandidates() {
		viewRemaingCandidatesViewModel = new ViewRemaingCandidatesViewModel(this);
	}

	public void showRemainingCandidates() {
		viewRemaingCandidatesViewModel.showRemaingCandidates();
	}

}
