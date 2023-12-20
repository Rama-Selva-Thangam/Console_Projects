package com.ramaselvathangamm.personaldiary.readnotes;

public class ReadNotesView {
	private ReadNotesViewModel readNotesViewModel;

	public ReadNotesView() {
		readNotesViewModel=new ReadNotesViewModel(this);
	}
	public void readNotes(){
		readNotesViewModel.readNotes();
	}
}
