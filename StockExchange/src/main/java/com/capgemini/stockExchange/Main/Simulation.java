package com.capgemini.stockExchange.Main;

import java.text.ParseException;
import java.util.Date;

import com.capgemini.stockExchange.BrokerageHouse.impl.BrokerageHouseImpl;
import com.capgemini.stockExchange.Client.Client;
import com.capgemini.stockExchange.DataProvider.ReadCSV;
import com.capgemini.stockExchange.DataProvider.SimulationTime;
import com.capgemini.stockExchange.model.AllStocks;
import com.capgemini.stockExchange.model.StockExchange;

public class Simulation {

	public static void main(String[] args) throws ParseException, ClassNotFoundException {
	
	StockExchange stockExchange = StockExchange.getInstance();
	SimulationTime time =SimulationTime.getInstance();
	ReadCSV readCSV = new ReadCSV();
	AllStocks initData =readCSV.read();
	time.initListOfDays(initData.getStocks().keySet());
	stockExchange.initExchange(initData);
	BrokerageHouseImpl brokeragehouse = new BrokerageHouseImpl(stockExchange);
	stockExchange.addObserver(brokeragehouse);
	
	Date currentDay;
	Client client = new Client(2,stockExchange,brokeragehouse);
	System.out.println("Clinet start money: "+client.getIncome());
		while ((currentDay=time.getNextDay())!=null) {
			try {
				stockExchange.nextDay(currentDay);
				client.makeTrade();
			}catch(Exception e){
		}

	}
		System.out.println("Clinet end money: "+client.getIncome());
	}

}
