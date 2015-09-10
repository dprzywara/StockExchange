package com.capgemini.stockExchange.Strategy.impl;

import java.util.Map;

import com.capgemini.stockExchange.Client.MoneyWallet;
import com.capgemini.stockExchange.Client.StocksWallet;
import com.capgemini.stockExchange.Strategy.Strategy;
import com.capgemini.stockExchange.model.Stocks;

public class RandomStrategy implements Strategy{

	public Map<String, Integer> buy(Stocks currentStocks) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Integer> sell(Map<String, Integer> clientStocks, Stocks currentStocks) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Integer> tryBuy(MoneyWallet mw) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Integer> trySell(StocksWallet sw) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
