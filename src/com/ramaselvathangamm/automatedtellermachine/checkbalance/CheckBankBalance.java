package com.ramaselvathangamm.automatedtellermachine.checkbalance;

import com.ramaselvathangamm.automatedtellermachine.dto.Card;

public class CheckBankBalance {
	private CheckBankBalanceViewModel checkBankBalanceViewModel;

	public CheckBankBalance() {
		checkBankBalanceViewModel = new CheckBankBalanceViewModel(this);
	}

	public void checkBalance(Card card) {
		checkBankBalanceViewModel.showBalance(card);
	}
}
