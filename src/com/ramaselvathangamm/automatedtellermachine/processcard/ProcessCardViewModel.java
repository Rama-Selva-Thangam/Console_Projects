package com.ramaselvathangamm.automatedtellermachine.processcard;

import com.ramaselvathangamm.automatedtellermachine.dto.Card;
import com.ramaselvathangamm.automatedtellermachine.repository.Repository;

class ProcessCardViewModel {
	private ProcessCard processCardViewModel;

	ProcessCardViewModel(ProcessCard processCardViewModel) {
		this.processCardViewModel = processCardViewModel;
	}

	Card getCard(long number, short pin) {
		Card card = Repository.getInstance().getCardList().get(number);
		if (card != null) {
			short pinNumber = card.getPin();
			if (pin != pinNumber) {
				System.out.println("Invalid PIN number");
				return null;
			}

		}
		return card;
	}
	void getErrorMessage() {
		System.out.println("Sorry could not process your card");

	}

}
