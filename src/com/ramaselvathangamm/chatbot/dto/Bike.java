package com.ramaselvathangamm.chatbot.dto;

public class Bike {
	private String bikeName;
	private String modelName;
	private long bookingID;
	private boolean isGeared;
	private int petrolCapacity;
	private double price;

	public String getBikeName() {
		return bikeName;
	}

	private void setBikeName(String bikeName) {
		this.bikeName = bikeName;
	}

	public String getModelName() {
		return modelName;
	}

	private void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public long getBookingID() {
		return bookingID;
	}

	public void setBookingID(long bookingID) {
		this.bookingID = bookingID;
	}

	public boolean isGeared() {
		return isGeared;
	}

	private void setGeared(boolean isGeared) {
		this.isGeared = isGeared;
	}

	public int getPetrolCapacity() {
		return petrolCapacity;
	}

	private void setPetrolCapacity(int petrolCapacity) {
		this.petrolCapacity = petrolCapacity;
	}

	public double getPrice() {
		return price;
	}

	private void setPrice(double price) {
		this.price = price;
	}

}
