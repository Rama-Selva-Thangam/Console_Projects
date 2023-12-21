package com.ramaselvathangamm.personaldiary.readnotes;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.ramaselvathangamm.personaldiary.dto.Diary;
import com.ramaselvathangamm.personaldiary.repository.Repository;

class ReadNotesViewModel {
	private ReadNotesView readNotesView;

	public ReadNotesViewModel(ReadNotesView readNotesView) {
		this.readNotesView = readNotesView;
	}

	public void readNotes() {
		ArrayList<Diary> notes = Repository.getInstance().readNote();
		if (notes.isEmpty()) {
			System.out.println("No more Notes are there !");
			return;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH:mm");
		for (Diary diary : notes) {
			long date = diary.getDate();
			String note = diary.getNotes();
			Date time = new Date(date);
			String formattedDate = dateFormat.format(time);
			System.out.println("Writted on : " + formattedDate + "\t" + "Note : " + note);
		}

	}

	public void searchNotes(String keyword) {
		ArrayList<Diary> searchedNotes = Repository.getInstance().searchNotes(keyword);
		if (searchedNotes.isEmpty()) {
			System.out.println("No more Notes are there !");
			return;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH:mm");
		for (Diary diary : searchedNotes) {
			long date = diary.getDate();
			String note = diary.getNotes();
			Date time = new Date(date);
			String formattedDate = dateFormat.format(time);
			System.out.println("Writted on : " + formattedDate + "\t" + "Note : " + note);
		}
	}

}
