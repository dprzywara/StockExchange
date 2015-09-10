package com.capgemini.stockExchange.BrokerageHouse.impl;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.stockExchange.model.StockValue;

public class BuySummary {

	private Map<String, StockValue> stocks = new HashMap<String, StockValue>();
	private Double cost;

	public BuySummary() {
	}

	public BuySummary(Map<String, StockValue> stock, Double cost) {
		super();
		this.stocks = stock;
		this.cost = cost;
	}

	public Map<String, StockValue> getStocks() {
		return stocks;
	}

	public void setStocks(Map<String, StockValue> stock) {
		this.stocks = stock;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

}
