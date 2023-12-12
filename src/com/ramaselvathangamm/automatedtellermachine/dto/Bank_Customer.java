package com.ramaselvathangamm.automatedtellermachine.dto;

public class Bank_Customer {
	private String customerName;
	private long mobileNumber;
	private String address;
	private Card card;

	public Bank_Customer(String customerName, long mobileNumber, String address) {
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}
