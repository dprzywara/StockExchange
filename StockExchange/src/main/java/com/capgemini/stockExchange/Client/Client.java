package com.capgemini.stockExchange.Client;

import java.util.Map;

import com.capgemini.stockExchange.BrokerageHouse.impl.BrokerageHouseImpl;
import com.capgemini.stockExchange.BrokerageHouse.impl.BuySummary;
import com.capgemini.stockExchange.Strategy.Strategy;
import com.capgemini.stockExchange.Strategy.impl.RandomStrategy;
import com.capgemini.stockExchange.Strategy.impl.SimpleStrategy;
import com.capgemini.stockExchange.model.StockExchange;

public class Client {

	private BrokerageHouseImpl brokerageHouse;
	private StocksWallet stocksWallet;
	private MoneyWallet moneyWallet;
	private Strategy strategy;

	public Client(int choose, StockExchange sEx, BrokerageHouseImpl bh) {
		switch (choose) {
		case 1:
			strategy = new RandomStrategy();
			break;
		case 2:
			strategy = new SimpleStrategy(sEx);
			break;
		default:
			strategy = new RandomStrategy();
		}
		this.stocksWallet = new StocksWallet();
		this.moneyWallet = new MoneyWallet(10000d);
		this.brokerageHouse = bh;
	}

	public void makeTrade() {
		Map<String, Integer> suggestStocksToBuy = strategy.tryBuy(moneyWallet);
		Map<String, Integer> suggestStocksToSell = strategy.trySell(stocksWallet);

		if (brokerageHouse.getBuyTradeCost(suggestStocksToBuy) < 100) {
			buyStocks(suggestStocksToBuy);
		}
		if (brokerageHouse.checkProfit(suggestStocksToSell) > 0) {
			sellStocks(suggestStocksToSell);
		}

	}

	public void buyStocks(Map<String, Integer> listToBuy) {
		BuySummary summary = brokerageHouse.buyStocks(listToBuy);
		stocksWallet.updateAfterBuy(summary.getStocks());
		moneyWallet.pay(summary.getCost());
	}

	public void sellStocks(Map<String, Integer> stocksToSell) {
		double profit = brokerageHouse.sellStocks(stocksToSell);
		stocksWallet.updateAfterSell(stocksToSell);
		moneyWallet.add(profit);
	}

	public double getIncome() {
		return moneyWallet.getMoney() + stocksWallet.getValueOfStocks();
	}

}
