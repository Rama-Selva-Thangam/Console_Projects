package com.ramaselvathangamm.interviewpanel.repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.ramaselvathangamm.interviewpanel.dto.Candidate;

public class Repository {
	private static Repository repository;
	private Queue<Candidate> candidateList = new LinkedList<Candidate>();
	private ArrayList<Candidate> totalCandidateList = new ArrayList<Candidate>();

	private Repository() {

	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	public Queue<Candidate> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(Queue<Candidate> candidateList) {
		this.candidateList = candidateList;
	}

	public void insertCandidate(Candidate candidate) {
		candidateList.add(candidate);
		totalCandidateList.add(candidate);
	}

	public ArrayList<Candidate> getTotalCandidateList() {
		return totalCandidateList;
	}

}
