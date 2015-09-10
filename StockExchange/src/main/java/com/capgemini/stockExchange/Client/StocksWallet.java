package com.capgemini.stockExchange.Client;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.stockExchange.model.StockValue;

public class StocksWallet{
	
	
	private Map<String,StockValue> walletOfStocks = new HashMap<String, StockValue>();

	
	public Double getValueOfStocks(){
		Double value = new Double(0);
		for (String name : walletOfStocks.keySet()) {
			value+=walletOfStocks.get(name).getValue();
			
		}
		return value;
	}

	public void updateAfterSell(Map<String,Integer> newStocksNumber){
		int oldAmount=0,newAmount=0;
		for (String name : newStocksNumber.keySet()) {
			if(walletOfStocks.containsKey(name)){
				oldAmount=walletOfStocks.get(name).getAmount();
				newAmount=oldAmount-newStocksNumber.get(name);
				if(newAmount<=0){
					walletOfStocks.remove(name);
					continue;
				}
				walletOfStocks.get(name).setAmount(newAmount);			
			}		
		}
	}
	public void add(String name,StockValue sv){
		walletOfStocks.put(name,sv);
	}

	public Map<String, StockValue> getWallet() {
		return walletOfStocks;
	}

	public void setWallet(Map<String, StockValue> walletOfStocks) {
		this.walletOfStocks = walletOfStocks;
	}

	public void updateAfterBuy(Map<String, StockValue> newStocks) {
		int oldAmount=0,newAmount=0;
		for (String name : newStocks.keySet()) {
			if(walletOfStocks.containsKey(name)){
				oldAmount=walletOfStocks.get(name).getAmount();
				newAmount=oldAmount+newStocks.get(name).getAmount();
				walletOfStocks.get(name).setAmount(newAmount);			
			}
			if(!walletOfStocks.containsKey(name)){
				walletOfStocks.put(name, newStocks.get(name));
			}
		}
		
	}
	
	
	
}
