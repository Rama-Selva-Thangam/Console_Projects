package com.ramaselvathangamm.interviewpanel.processinterview;

import com.ramaselvathangamm.interviewpanel.repository.Repository;
import com.ramaselvathangamm.interviewpanel.dto.Candidate;

import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class InterviewProcessViewModel implements Runnable {
	private InterviewProcess interviewProcess;
	private ScheduledExecutorService scheduler;

	InterviewProcessViewModel(InterviewProcess interviewProcess) {
		this.interviewProcess = interviewProcess;
	}

	void startInterviewProcess() {
		scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(this, 0, 5, TimeUnit.SECONDS);
	}

	public void run() {
		Queue<Candidate> candidateList = Repository.getInstance().getCandidateList();
		if (!candidateList.isEmpty()) {
			System.out.println("Interview Completed for " + candidateList.poll().getCandidateName());
		} else {
			System.out.println("No more candidates are there...");
			stopInterviewProcess();
		}
	}

	private void stopInterviewProcess() {
		scheduler.shutdown();
	}
}
