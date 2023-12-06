package com.ramaselvathangamm.interviewpanel.viewremaining;

import java.util.Queue;

import com.ramaselvathangamm.interviewpanel.dto.Candidate;
import com.ramaselvathangamm.interviewpanel.repository.Repository;

class ViewRemaingCandidatesViewModel {
	private ViewRemainigCandidates viewRemaingCandidates;

	ViewRemaingCandidatesViewModel(ViewRemainigCandidates viewRemaingCandidates) {
		this.viewRemaingCandidates = viewRemaingCandidates;
	}

	void showRemaingCandidates() {
		Queue<Candidate> list = Repository.getInstance().getCandidateList();
		if (!list.isEmpty()) {
			for (Candidate candidate : list) {
				System.out.println(candidate.getCandidateName());
			}
		} else {
			System.out.println("No more Candidates are there");
		}

	}

}
