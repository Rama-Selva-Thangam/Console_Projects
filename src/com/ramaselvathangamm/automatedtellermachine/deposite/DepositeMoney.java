package com.ramaselvathangamm.automatedtellermachine.deposite;

import java.util.Scanner;

import com.ramaselvathangamm.automatedtellermachine.dto.Card;

public class DepositeMoney {
	private DepositeMoneyViewModel depositeMoneyViewModel;

	public DepositeMoney() {
		depositeMoneyViewModel = new DepositeMoneyViewModel(this);
	}

	public void depositeMoney(Card card) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Amount in Multiples of 100,500 : ");
		double amount = scan.nextDouble();
		scan.nextLine();
		depositeMoneyViewModel.depositeMoney(card, amount);
	}
}
