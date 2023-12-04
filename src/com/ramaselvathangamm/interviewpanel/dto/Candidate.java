
package com.ramaselvathangamm.interviewpanel.dto;

public class Candidate {
	private String candidateName;
	private String qualification;
	private String dateOfBirth;
	private int yearOfPassedOut;

	public Candidate(String candidateName, String qualification, String dateOfBirth, int yearOfPassedOut) {
		this.candidateName = candidateName;
		this.qualification = qualification;
		this.dateOfBirth = dateOfBirth;
		this.yearOfPassedOut = yearOfPassedOut;

	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getYearOfPassedOut() {
		return yearOfPassedOut;
	}

	public void setYearOfPassedOut(int yearOfPassedOut) {
		this.yearOfPassedOut = yearOfPassedOut;
	}

}
