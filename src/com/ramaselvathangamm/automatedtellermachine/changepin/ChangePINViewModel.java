package com.ramaselvathangamm.automatedtellermachine.changepin;

import com.ramaselvathangamm.automatedtellermachine.dto.Card;

class ChangePINViewModel {
	private ChangePIN changePIN;

	ChangePINViewModel(ChangePIN changePIN) {
		this.changePIN = changePIN;
	}

	public void changePIN(Card card, long mobileNumber) {
		long userMobile = card.getBankCustomer().getMobileNumber();
		if (userMobile != mobileNumber) {
			System.out.println("Entered Wrong Mobile Number");
			return;
		}
		changePIN.getInputPIN(card);
	}

	public void confirmChangePIN(Card card, short pin, short confirmPIN) {
		if (pin != confirmPIN) {
			System.out.println("PIN Mismatched");
			return;
		}
		card.setPin(confirmPIN);
		System.out.println("Your PIN Successfully Changed");
	}

}
