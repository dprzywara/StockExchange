package com.capgemini.stockExchange.Client;

public class MoneyWallet {
	
	private Double money;
	
	
	public MoneyWallet(Double cash){
		this.money=cash;
		
	}
	
	public void pay(Double cash){
		this.money-=cash;
	}
	public void add(Double cash){
		this.money+=+cash;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
	
	

}
