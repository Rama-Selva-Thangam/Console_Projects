package com.ramaselvathangamm.automatedtellermachine.withdraw;

import com.ramaselvathangamm.automatedtellermachine.dto.Card;
import com.ramaselvathangamm.automatedtellermachine.repository.Repository;

class WithdrawMoneyViewModel {
	private WithdrawMoney withdrawMoney;

	WithdrawMoneyViewModel(WithdrawMoney withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
	}

	void getTransaction(Card card, double amount) {
		if (amount % 100 != 0) {
			System.out.println("Enter the amount in Multiples of 100,500");
			return;
		}
		if (card.getBalance() < amount) {
			System.out.println("Insufficicent Balance");
			return;
		}
		double remainingBalance = card.getBalance() - amount;
		card.setBalance(remainingBalance);
		System.out.println("Collect Your Money : " + amount);
		System.out.println("Your Balance : " + remainingBalance);

	}
}
