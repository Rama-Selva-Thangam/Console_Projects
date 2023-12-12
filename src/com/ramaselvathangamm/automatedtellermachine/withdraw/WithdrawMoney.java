package com.ramaselvathangamm.automatedtellermachine.withdraw;

import java.util.Scanner;

import com.ramaselvathangamm.automatedtellermachine.dto.Card;

public class WithdrawMoney {
	private WithdrawMoneyViewModel withdrawMoneyViewModel;

	public WithdrawMoney() {
		withdrawMoneyViewModel = new WithdrawMoneyViewModel(this);
	}

	public void withdrawMoney(Card card) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Eneter the Amounts in 100,500 : ");
		double amount = scan.nextDouble();
		scan.nextLine();
		withdrawMoneyViewModel.getTransaction(card, amount);

	}
}
