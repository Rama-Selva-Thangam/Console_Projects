package com.ramaselvathangamm.automatedtellermachine.changepin;

import java.util.Scanner;

import com.ramaselvathangamm.automatedtellermachine.dto.Card;

public class ChangePIN {
	private ChangePINViewModel changePINViewModel;

	public ChangePIN() {
		changePINViewModel = new ChangePINViewModel(this);
	}

	public void changePIN(Card card) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your Mobile Number : ");
		long mobileNumber = scan.nextLong();
		scan.nextLine();
		changePINViewModel.changePIN(card, mobileNumber);
	}

	public void getInputPIN(Card card) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the PIN : ");
		short pin = scan.nextShort();
		System.out.print("Confirm Your PIN : ");
		short confirmPIN = scan.nextShort();
		scan.nextLine();
		changePINViewModel.confirmChangePIN(card, pin, confirmPIN);
	}
}
