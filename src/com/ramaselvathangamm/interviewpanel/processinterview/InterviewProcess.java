package com.ramaselvathangamm.interviewpanel.processinterview;

public class InterviewProcess {
	private InterviewProcessViewModel interviewProcessViewModel;

	public InterviewProcess() {
		this.interviewProcessViewModel = new InterviewProcessViewModel(this);
	}

	public void interviewProcess() {
		interviewProcessViewModel.startInterviewProcess();
	}
}
