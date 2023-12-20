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
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH:mm");
		for (Diary diary : notes) {
			long date = diary.getDate();
			String note = diary.getNotes();
			Date time = new Date(date);
			String formattedDate = dateFormat.format(time);
			System.out.println(formattedDate + " : " + note);
		}

	}

}
