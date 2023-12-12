package com.ramaselvathangamm.automatedtellermachine.checkbalance;

import com.ramaselvathangamm.automatedtellermachine.dto.Card;
import com.ramaselvathangamm.automatedtellermachine.repository.Repository;

class CheckBankBalanceViewModel {
	private CheckBankBalance checkBankBalance;

	CheckBankBalanceViewModel(CheckBankBalance checkBankBalance) {
		this.checkBankBalance = checkBankBalance;
	}

	public void showBalance(Card card) {
		System.out.println("Your Balance is : " + card.getBalance());
	}

}
