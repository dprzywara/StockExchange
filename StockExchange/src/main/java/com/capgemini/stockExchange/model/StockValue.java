package com.capgemini.stockExchange.model;

public class StockValue {

	private double price;
	private int amount;

	public StockValue() {
	}

	public StockValue(double price, int amount) {
		super();
		this.price = price;
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Double getValue() {
		return price * amount;
	}

}
