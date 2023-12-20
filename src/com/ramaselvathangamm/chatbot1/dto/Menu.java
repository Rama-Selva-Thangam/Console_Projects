package com.ramaselvathangamm.chatbot1.dto;

public class Menu {
	private int step;
	private int choice;
	
	public Menu(int step, int choice) {
		this.setStep(step);
		this.setChoice(choice);
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}
}