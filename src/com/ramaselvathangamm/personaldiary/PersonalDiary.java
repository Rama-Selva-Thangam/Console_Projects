package com.ramaselvathangamm.personaldiary;

import java.util.Scanner;

import com.ramaselvathangamm.personaldiary.readnotes.ReadNotesView;
import com.ramaselvathangamm.personaldiary.repository.Repository;
import com.ramaselvathangamm.personaldiary.writenotes.WriteNoteView;

public class PersonalDiary {
	public static void main(String[] args) {
		PersonalDiary personalDiary = new PersonalDiary();
		personalDiary.init();
	}

	private void init() {
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		int choice;
		do {
			System.out.println("--- WELCOME ---");
			System.out.println("Enter your Option : \n1.Write a Note\n2.Read all Notes\n3.Search a Note\n0.Exit");
			System.out.println("---------------------------------");
			choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
			case 1:
				WriteNoteView writeNoteView = new WriteNoteView();
				writeNoteView.writeNote();
				break;
			case 2:
				ReadNotesView readNotesView = new ReadNotesView();
				readNotesView.readNotes();
				break;
			case 3:
				ReadNotesView readNotesViewSearch = new ReadNotesView();
				readNotesViewSearch.searchNotes();
				break;
			case 0:
				loop = false;
				break;
			default:
				System.out.println("Enter Valid option");
			}

		} while (loop);
		Repository.getInstance().closeConnection();
		System.out.println("--- THANK YOU ! ---");

	}
}
