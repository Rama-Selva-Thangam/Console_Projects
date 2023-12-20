package com.ramaselvathangamm.personaldiary.writenotes;

import java.util.Date;

import com.ramaselvathangamm.personaldiary.dto.Diary;
import com.ramaselvathangamm.personaldiary.repository.Repository;

class WriteNoteViewModel {
	private WriteNoteView writeNoteView;

	public WriteNoteViewModel(WriteNoteView writeNoteView) {
		this.writeNoteView = writeNoteView;
	}

	public void writeNote(String note) {
		Diary diary = new Diary(new Date().getTime(), note);
		Repository.getInstance().writeNote(diary);
	}
}
