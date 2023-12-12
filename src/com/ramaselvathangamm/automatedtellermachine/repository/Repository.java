package com.ramaselvathangamm.automatedtellermachine.repository;

import java.util.HashMap;

import com.ramaselvathangamm.automatedtellermachine.dto.Bank_Customer;
import com.ramaselvathangamm.automatedtellermachine.dto.Card;

public class Repository {
	private static Repository repository;

	private HashMap<Long, Bank_Customer> usersList = new HashMap<Long, Bank_Customer>();
	private HashMap<Long, Card> cardList = new HashMap<Long, Card>();

	private Repository() {
	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	public HashMap<Long, Bank_Customer> getUsersList() {
		return usersList;
	}

	public void setUsersList(HashMap<Long, Bank_Customer> usersList) {
		this.usersList = usersList;
	}

	public HashMap<Long, Card> getCardList() {
		return cardList;
	}

	public void setCardList(HashMap<Long, Card> cardList) {
		this.cardList = cardList;
	}
}
