package com.ramaselvathangamm.automatedtellermachine.loaddefaultcustomer;

import java.util.HashMap;

import com.ramaselvathangamm.automatedtellermachine.dto.Bank_Customer;
import com.ramaselvathangamm.automatedtellermachine.dto.Card;
import com.ramaselvathangamm.automatedtellermachine.repository.Repository;

public class LoadDefaultCustomers {

	public void loadCustomers() {
		HashMap<Long, Bank_Customer> usersList = Repository.getInstance().getUsersList();
		HashMap<Long, Card> cardList = Repository.getInstance().getCardList();
		Card card1 = new Card("Indian Bank", "Alangulam", 12345678901L, 98765432109876L, (short) 1234, 1000.0);
		Bank_Customer customer1 = new Bank_Customer("Thangam", 8870627424L, "2/144 Main St, Alangulam");
		card1.setBankCustomer(customer1);
		customer1.setCard(card1);
		Card card2 = new Card("Canara Bank", "Alangulam", 12345678902L, 98765432109875L, (short) 4321, 1000.0);
		Bank_Customer customer2 = new Bank_Customer("Selva", 7548829151L, "2/156 South St, Nallur");
		card2.setBankCustomer(customer2);
		customer2.setCard(card2);
		Card card3 = new Card("State Bank of India", "Alangulam", 12345678903L, 98765432109874L, (short) 9876, 1000.0);
		Bank_Customer customer3 = new Bank_Customer("Rajesh", 8995677656L, "1/144 West St, Kidarakulam");
		card3.setBankCustomer(customer3);
		customer3.setCard(card3);
		Card card4 = new Card("Indian Bank", "Alangulam", 12345678904L, 98765432109873L, (short) 9098, 1000.0);
		Bank_Customer customer4 = new Bank_Customer("Siva", 9876543210L, "2/345 North St, Alangulam");
		card4.setBankCustomer(customer4);
		customer4.setCard(card4);
		usersList.put(customer1.getCard().getAccountNumber(), customer1);
		cardList.put(card1.getCardNumber(), card1);
		usersList.put(customer2.getCard().getAccountNumber(), customer2);
		cardList.put(card2.getCardNumber(), card2);
		usersList.put(customer3.getCard().getAccountNumber(), customer3);
		cardList.put(card3.getCardNumber(), card3);
		usersList.put(customer4.getCard().getAccountNumber(), customer4);
		cardList.put(card1.getCardNumber(), card4);
	}
}
