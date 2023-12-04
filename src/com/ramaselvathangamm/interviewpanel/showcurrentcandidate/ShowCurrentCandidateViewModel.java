package com.ramaselvathangamm.interviewpanel.showcurrentcandidate;

import com.ramaselvathangamm.interviewpanel.repository.Repository;
import com.ramaselvathangamm.interviewpanel.dto.Candidate;

class ShowCurrentCandidateViewModel {
	private ShowCurrentCandidate showCurrentCandidate;

	ShowCurrentCandidateViewModel(ShowCurrentCandidate showCurrentCandidate) {
		this.showCurrentCandidate = showCurrentCandidate;
	}

	void showCurrentCandidate() {
		Candidate currentCandidate = Repository.getInstance().getCandidateList().peek();
		if (currentCandidate != null) {
			System.out.println("Interview Going for : " + currentCandidate.getCandidateName());
		} else {
			System.out.println("No candidates inside Interview Panel");
		}

	}

}
