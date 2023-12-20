package com.ramaselvathangamm.chatbot1;

import org.json.simple.parser.ParseException;

import com.ramaselvathangamm.chatbot1.viewmodel.SelectChoice;

public class Main {

	public static void main(String[] args) {
		
		Main restaurant = new Main();
		restaurant.start();
	}

	private void start() {
	        System.out.println("*+---Tamil Mersal Restaurant-----+*");
	        SelectChoice sc = null;
			try {
				sc = new SelectChoice();
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        sc.addChoice();  
	}
}