package com.capgemini.stockExchange.BrokerageHouse;

import java.util.Map;

import com.capgemini.stockExchange.BrokerageHouse.impl.BuySummary;

public interface BrokerageHouse {
	
	public BuySummary buyStocks(Map<String,Integer> list);
	public Integer buyStocks(String name, Double money);
	public Double sellStocks(Map<String,Integer> list);
	public Double getBuyTradeCost(Map<String,Integer> list);
	public Double getBuyTradeCost(String name, Double money);
	public Double checkProfit(Map<String,Integer> list);
	
}
