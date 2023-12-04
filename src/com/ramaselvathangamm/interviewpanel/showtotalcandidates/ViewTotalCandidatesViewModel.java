package com.ramaselvathangamm.interviewpanel.showtotalcandidates;

import java.util.ArrayList;
import java.util.Queue;

import com.ramaselvathangamm.interviewpanel.dto.Candidate;
import com.ramaselvathangamm.interviewpanel.repository.Repository;

class ViewTotalCandidatesViewModel {
	private ViewTotalCandidates viewTotalCandidates;

	ViewTotalCandidatesViewModel(ViewTotalCandidates viewTotalCandidates) {
		this.viewTotalCandidates = viewTotalCandidates;
	}

	void showTotalCandidates() {
		ArrayList<Candidate> list = Repository.getInstance().getTotalCandidateList();
		if(!list.isEmpty()) {
			for (Candidate candidate : list) {
				System.out.println(candidate.getCandidateName());
			}
		}
		else {
			System.out.println("No Candidates registered");
		}
	}

}
