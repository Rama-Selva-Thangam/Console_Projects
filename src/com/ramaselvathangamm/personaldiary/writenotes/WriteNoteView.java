package com.ramaselvathangamm.personaldiary.writenotes;

import java.util.Scanner;

public class WriteNoteView {
	private WriteNoteViewModel writeNoteViewModel;

	public WriteNoteView() {
		writeNoteViewModel = new WriteNoteViewModel(this);
	}

	public void writeNote() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Note : ");
		String note = scan.nextLine();
		writeNoteViewModel.writeNote(note);
	}

}
