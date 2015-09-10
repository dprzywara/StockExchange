package com.capgemini.stockExchange.BrokerageHouse.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import com.capgemini.stockExchange.BrokerageHouse.BrokerageHouse;
import com.capgemini.stockExchange.model.StockExchange;
import com.capgemini.stockExchange.model.StockValue;
import com.capgemini.stockExchange.model.Stocks;

public class BrokerageHouseImpl implements BrokerageHouse, Observer {

	private static final double COMMISION = 0.005;
	private static final double buyProvision = (1 + COMMISION);
	private static final double sellProvision = (1 - COMMISION);
	private Stocks currentStocks;
	private StockExchange stockExchange;

	public BrokerageHouseImpl() {
	}

	public BrokerageHouseImpl(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	public BuySummary buyStocks(Map<String, Integer> listToBuy) {
		return new BuySummary(makeBuySummary(listToBuy), currentValueOfStocks(listToBuy) * buyProvision);
	}

	private Map<String, StockValue> makeBuySummary(Map<String, Integer> listToBuy) {

		Map<String, StockValue> newStocks = new HashMap<String, StockValue>();

		for (String name : listToBuy.keySet()) {
			newStocks.put(name, new StockValue(getCurrentStockPrice(name), listToBuy.get(name)));
		}
		return newStocks;
	}

	public Integer buyStocks(String name, Double cash) {
		double currentPrice = getCurrentStockPrice(name);
		return calculateStockNumber(currentPrice, cash);
	}

	public Double sellStocks(Map<String, Integer> stocksToSell) {
		return currentValueOfStocks(stocksToSell) * sellProvision;

	}

	private double currentValueOfStocks(Map<String, Integer> stocksNumber) {
		double value = 0.0;
		for (String name : stocksNumber.keySet()) {
			value += stocksNumber.get(name) * getCurrentStockPrice(name);
		}
		return value;
	}

	private double getCurrentStockPrice(String name) {
		return currentStocks.get(name);
	}

	private int calculateStockNumber(Double price, Double cash) {
		return (int) (cash / price);
	}

	public Double getBuyTradeCost(Map<String, Integer> list) {
		return currentValueOfStocks(list) * buyProvision;
	}

	public Double getBuyTradeCost(String name, Double cash) {
		double currentPrice = getCurrentStockPrice(name);
		return calculateStockNumber(currentPrice, cash) * currentPrice * buyProvision;
	}

	public Double checkProfit(Map<String, Integer> list) {
		return currentValueOfStocks(list) * sellProvision;
	}

	public void update(Observable obs, Object arg) {
		if (obs == stockExchange) {
			this.currentStocks = stockExchange.getCurrentStocks();
		}

	}

}
