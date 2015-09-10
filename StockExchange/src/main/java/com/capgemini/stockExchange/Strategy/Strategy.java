package com.capgemini.stockExchange.Strategy;

import java.util.Map;

import com.capgemini.stockExchange.Client.MoneyWallet;
import com.capgemini.stockExchange.Client.StocksWallet;
import com.capgemini.stockExchange.model.Stocks;

public interface Strategy {

	public Map<String,Integer> tryBuy(MoneyWallet mw);
	public Map<String,Integer>  trySell(StocksWallet sw ); 
	
	
}




