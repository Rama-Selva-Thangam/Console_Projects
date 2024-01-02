package com.ramaselvathangamm.automatedtellermachine.deposite;

import com.ramaselvathangamm.automatedtellermachine.dto.Card;

class DepositeMoneyViewModel {
	private DepositeMoney depositeMoney;

	DepositeMoneyViewModel(DepositeMoney depositeMoney) {
		this.depositeMoney = depositeMoney;
	}

	public void depositeMoney(Card card, double amount) {
		if (amount % 100 != 0) {
			System.out.println("Enter the amount in Multiples of 100,500");
			return;
		}
		if (amount < 0) {
			System.out.println("Enter the amount in Positive ");
			return;
		}
		double depositedBalance = card.getBalance() + amount;
		card.setBalance(depositedBalance);
		System.out.println("Your Balance : " + depositedBalance);

	}

}
