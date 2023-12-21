package com.ramaselvathangamm.personaldiary.readnotes;

import java.util.Scanner;

public class ReadNotesView {
	private ReadNotesViewModel readNotesViewModel;

	public ReadNotesView() {
		readNotesViewModel=new ReadNotesViewModel(this);
	}
	public void readNotes(){
		readNotesViewModel.readNotes();
	}
	public void searchNotes(){
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter the Keyword : ");
		String keyword=scan.nextLine();
		readNotesViewModel.searchNotes(keyword);
	}
}
