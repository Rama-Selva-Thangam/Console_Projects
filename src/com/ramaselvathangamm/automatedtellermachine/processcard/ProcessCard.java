package com.ramaselvathangamm.automatedtellermachine.processcard;

import java.util.Scanner;

import com.ramaselvathangamm.automatedtellermachine.changepin.ChangePIN;
import com.ramaselvathangamm.automatedtellermachine.checkbalance.CheckBankBalance;
import com.ramaselvathangamm.automatedtellermachine.deposite.DepositeMoney;
import com.ramaselvathangamm.automatedtellermachine.dto.Card;
import com.ramaselvathangamm.automatedtellermachine.withdraw.WithdrawMoney;

public class ProcessCard {
	private ProcessCardViewModel processCardViewModel;

	public ProcessCard() {
		processCardViewModel = new ProcessCardViewModel(this);
	}

	public void processCard(long number, short pin) {
		Card card = processCardViewModel.getCard(number, pin);
		if (card != null) {
			onSucess(card);
		} else {
			processCardViewModel.getErrorMessage();
		}

	}

	private void onSucess(Card card) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome " + card.getBankCustomer().getCustomerName());
		System.out.println(
				"Enter your option : \n1.Check Balance\n2.Withdraw Money\n3.Deposite Money\n4.Change PIN\n0.Exit");
		int option = scan.nextInt();
		switch (option) {
		case 1:
			CheckBankBalance checkBankBalance = new CheckBankBalance();
			checkBankBalance.checkBalance(card);
			break;
		case 2:
			WithdrawMoney withdrawMoney = new WithdrawMoney();
			withdrawMoney.withdrawMoney(card);
			break;
		case 3:
			DepositeMoney depositeMoney = new DepositeMoney();
			depositeMoney.depositeMoney(card);
			break;
		case 4:
			ChangePIN changePIN = new ChangePIN();
			changePIN.changePIN(card);
			break;
		case 0:
			return;
		default:
			System.out.println("Enter Valid Option");
		}
	}
}
