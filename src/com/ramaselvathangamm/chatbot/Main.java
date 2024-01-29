package com.ramaselvathangamm.chatbot;

import org.json.simple.parser.ParseException;

import com.ramaselvathangamm.chatbot.viewmodel.SelectChoice;

public class Main {

	public static void main(String[] args) {
		Main restaurant = new Main();
		restaurant.start();
	}

	private void start() {
		System.out.println("--- WELCOME ---");
		SelectChoice sc = null;
		try {
			sc = new SelectChoice();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sc.addChoice();
	}
}