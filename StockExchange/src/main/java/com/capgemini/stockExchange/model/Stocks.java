package com.capgemini.stockExchange.model;

import java.util.HashMap;
import java.util.Map;

public class Stocks {

	private Map<String, Double> mapOfStocks;

	public Stocks() {
		mapOfStocks = new HashMap<String, Double>();

	}

	public Stocks(String key, Double value) {
		mapOfStocks = new HashMap<String, Double>();
		mapOfStocks.put(key, value);

	}

	public Double get(String name) {
		return mapOfStocks.get(name);
	}

	public Map<String, Double> getStocks() {
		return mapOfStocks;
	}

	public void setMapOfStocks(Map<String, Double> map) {
		this.mapOfStocks = map;
	}

	public void put(String key, Double value) {
		mapOfStocks.put(key, value);
	}

}
