package com.capgemini.stockExchange.model;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class AllStocks {
	
private Map<Date,Stocks> mapOfStocks;
	
	public AllStocks(){
		mapOfStocks=new TreeMap<Date,Stocks>();
		
	}
	public Stocks get(Date data) {
		return mapOfStocks.get(data);
	}
	
	public Map<Date,Stocks> getStocks() {
		return mapOfStocks ;
	}
	
	public void setMapOfAllStocks(Map<Date,Stocks> map) {
		this.mapOfStocks = map;
	}
	
	public void put(Date key,Stocks value) {
		mapOfStocks.put(key, value);
	}

}
