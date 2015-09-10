package com.capgemini.stockExchange.Strategy.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import com.capgemini.stockExchange.Client.MoneyWallet;
import com.capgemini.stockExchange.Client.StocksWallet;
import com.capgemini.stockExchange.Strategy.Strategy;
import com.capgemini.stockExchange.model.StockExchange;
import com.capgemini.stockExchange.model.Stocks;

public class SimpleStrategy implements Strategy, Observer {

	StockExchange stockExchange;
	private Stocks currentStocks;

	public SimpleStrategy(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
		 stockExchange.addObserver(this);
	}

	public Map<String, Integer> tryBuy(MoneyWallet mw) {
		double money = mw.getMoney();
		int numberToBuy = 8;
		double estimateCost = 0;
		Map<String, Integer> toBuy = new HashMap<String, Integer>();
		for (String name : currentStocks.getStocks().keySet()) {
			if (stockExchange.getDailyPercentageChange(name) >= 0.0) {
				estimateCost += currentStocks.get(name) * numberToBuy;

				if (estimateCost < money) {
					toBuy.put(name, numberToBuy);
				}
				if (estimateCost >= money) {
					return toBuy;
				}
			}
		}

		return toBuy;
	}

	public Map<String, Integer> trySell(StocksWallet sw) {
		Map<String, Integer> tosell = new HashMap<String, Integer>();
		for (String name : sw.getWallet().keySet()) {
			if (stockExchange.getPercentageChange(name, sw.getWallet().get(name).getPrice()) < 0.0) {
				tosell.put(name, sw.getWallet().get(name).getAmount());
			}
		}

		return tosell;
	}

	public void update(Observable o, Object arg) {
		if (o == stockExchange) {
			this.currentStocks = stockExchange.getCurrentStocks();
		}

	}

}
