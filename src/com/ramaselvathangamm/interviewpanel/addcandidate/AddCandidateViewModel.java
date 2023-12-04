package com.ramaselvathangamm.interviewpanel.addcandidate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ramaselvathangamm.interviewpanel.dto.Candidate;
import com.ramaselvathangamm.interviewpanel.repository.Repository;

class AddCandidateViewModel {

	private AddCandidate addCandidate;

	public AddCandidateViewModel(AddCandidate addCandidate) {
		this.addCandidate = addCandidate;
	}

	public boolean validate(String name, String qualification, String dateOfBirth, int yearOfPassedOut) {
		if (name.length() >= 3 && name.length() < 50 && qualification.contains("BE") && isValidDateOfBirth(dateOfBirth)
				&& isValidYearOfPassedOut(yearOfPassedOut)) {
			this.addCandidate.onSuccess();
			return true;
		} else {
			this.addCandidate.showError("Invalid candidate details. Please check the input criteria.");
			return false;
		}
	}

	private boolean isValidDateOfBirth(String dateOfBirth) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date currentDate = new Date();

		try {
			Date dob = dateFormat.parse(dateOfBirth);
			Date cutoffDate = dateFormat.parse("01-01-1999");
			Date cutoffDate2 = dateFormat.parse("01-01-2005");

			return dob.after(cutoffDate) && dob.before(cutoffDate2);
		} catch (ParseException e) {
			return false;
		}
	}

	private boolean isValidYearOfPassedOut(int yearOfPassedOut) {
		return yearOfPassedOut >= 2017 && yearOfPassedOut <= 2023;
	}

	public void addToRepository(Candidate candidate) {
		Repository.getInstance().insertCandidate(candidate);

	}

}