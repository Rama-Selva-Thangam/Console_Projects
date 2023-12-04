package com.ramaselvathangamm.interviewpanel;

import java.util.Scanner;
import com.ramaselvathangamm.interviewpanel.addcandidate.AddCandidate;
import com.ramaselvathangamm.interviewpanel.showcurrentcandidate.ShowCurrentCandidate;
import com.ramaselvathangamm.interviewpanel.processinterview.InterviewProcess;
import com.ramaselvathangamm.interviewpanel.viewremaining.ViewRemainigCandidates;
import com.ramaselvathangamm.interviewpanel.processinterview.InterviewProcess;
import com.ramaselvathangamm.interviewpanel.showtotalcandidates.ViewTotalCandidates;

public class InterviewPanel {

	public static void main(String[] args) {
		InterviewPanel interviewPanel = new InterviewPanel();
		interviewPanel.init();

	}

	private void init() {
		Scanner scan = new Scanner(System.in);
		int choice;
		boolean loop = true;
		do {
			System.out.println("\n---- WELCOME ----");
			System.out.println(
					"Enter an option \n1.Enroll New Candidate\n2.Show Current Candidate\n3.Start Interview\n4.Show Remaing Candidates\n5.Show Total Candidate\n0.Exit");
			System.out.println("------------------------");
			choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
			case 1:
				AddCandidate addCandidate = new AddCandidate();
				addCandidate.addCandidate();
				break;
			case 2:
				ShowCurrentCandidate showCurrentCandidate = new ShowCurrentCandidate();
				showCurrentCandidate.showCurrentCandidate();
				break;
			case 3:
				InterviewProcess interviewProcess = new InterviewProcess();
				interviewProcess.interviewProcess();
				break;
			case 4:
				ViewRemainigCandidates viewRemainigCandidates = new ViewRemainigCandidates();
				viewRemainigCandidates.showRemainingCandidates();
				break;
			case 5:
				ViewTotalCandidates viewTotalCandidates = new ViewTotalCandidates();
				viewTotalCandidates.showTotalCandidates();
				break;
			case 0:
				loop = false;
				break;
			default:
				System.out.println("Enter a Valid option...");
			}

		} while (loop);

	}
}
