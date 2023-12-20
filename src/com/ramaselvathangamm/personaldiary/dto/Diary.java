package com.ramaselvathangamm.personaldiary.dto;

public class Diary {
	private long date;
	private String notes;

	public Diary(long time, String note) {
		this.date = time;
		this.notes = note;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
