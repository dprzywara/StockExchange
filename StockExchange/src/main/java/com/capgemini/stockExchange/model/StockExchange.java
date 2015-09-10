package com.capgemini.stockExchange.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Observable;

import com.capgemini.stockExchange.DataProvider.SimulationTime;

public class StockExchange extends Observable {

	private static StockExchange instance;
	private Calendar calendar = Calendar.getInstance();

	private AllStocks allStocks;
	private Stocks currentStocks;

	private Stocks lastDayStocks;
	private Stocks weekAgoStocks;

	public double getDailyPercentageChange(String name) {
		return (currentStocks.get(name) - lastDayStocks.get(name)) / lastDayStocks.get(name);
	}

	public double getWeeklyPercentageChange(String name) {
		return (currentStocks.get(name) - weekAgoStocks.get(name)) / weekAgoStocks.get(name);
	}

	public double getPercentageChange(String name, Double price) {
		return (currentStocks.get(name) - price) / price;
	}

	public Stocks getCurrentStocks() {
		return currentStocks;
	}

	public void setCurrentStocks(Stocks currentStocks) {
		this.currentStocks = currentStocks;
	}

	private StockExchange() {
	}

	public void initExchange(AllStocks all) {

		this.allStocks = all;
		this.currentStocks = allStocks.get(SimulationTime.getCurrentDay());
		setChanged();
		notifyObservers();
	}

	public static StockExchange getInstance() {
		if (instance == null) {
			instance = new StockExchange();

		}
		return instance;
	}

	public AllStocks getAllStocks() {
		return allStocks;
	}

	public void nextDay(Date d) {
		Date yesterday = getYesterday(d);
		Date weekAgo = getWeekBack(d);

		if (allStocks.getStocks().containsKey(yesterday)) {
			this.lastDayStocks = allStocks.get(yesterday);
		}
		if (allStocks.getStocks().containsKey(weekAgo)) {
			this.weekAgoStocks = allStocks.get(weekAgo);
		}

		this.currentStocks = allStocks.get(d);
		setChanged();
		notifyObservers();

	}

	private Date getWeekBack(Date d) {
		calendar.setTime(d);
		calendar.add(Calendar.DAY_OF_MONTH, -7);
		Date weekAgo = calendar.getTime();
		return weekAgo;
	}

	private Date getYesterday(Date d) {
		calendar.setTime(d);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date yesterday = calendar.getTime();
		return yesterday;
	}

}
