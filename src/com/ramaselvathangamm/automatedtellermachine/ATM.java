package com.ramaselvathangamm.automatedtellermachine;

import java.util.Scanner;

import com.ramaselvathangamm.automatedtellermachine.loaddefaultcustomer.LoadDefaultCustomers;
import com.ramaselvathangamm.automatedtellermachine.processcard.ProcessCard;
import com.ramaselvathangamm.automatedtellermachine.withdraw.WithdrawMoney;

public class ATM {
	public static void main(String[] args) {
		ATM atm = new ATM();
		atm.loadDefaultMembers();
		atm.init();
	}

	private void init() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---------- ATM ----------");
		System.out.print("Enter yor Card Number : ");
		long cardNumber = scan.nextLong();
		System.out.print("Enter the PIN Number : ");
		short pin = scan.nextShort();
		scan.nextLine();
		ProcessCard processCard = new ProcessCard();
		processCard.processCard(cardNumber, pin);

	}

	void loadDefaultMembers() {
		LoadDefaultCustomers loadcustomer = new LoadDefaultCustomers();
		loadcustomer.loadCustomers();
	}
}
