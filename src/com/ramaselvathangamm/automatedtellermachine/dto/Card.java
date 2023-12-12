package com.ramaselvathangamm.automatedtellermachine.dto;

public class Card extends Bank {
	private long cardNumber;
	private short pin;
	private Bank_Customer bankCustomer;
	private double balance;

	public Card(String bankName, String branchName, long accountNumber, long cardNumber, short pin, double balance) {
		super.setBankName(bankName);
		super.setBranchName(branchName);
		super.setAccountNumber(accountNumber);
		this.cardNumber = cardNumber;
		this.pin = pin;
		this.balance = balance;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public short getPin() {
		return pin;
	}

	public void setPin(short pin) {
		this.pin = pin;
	}

	public Bank_Customer getBankCustomer() {
		return bankCustomer;
	}

	public void setBankCustomer(Bank_Customer bankCustomer) {
		this.bankCustomer = bankCustomer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
