package com.capgemini.stockExchange.DataProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SimulationTime {

	private static List<Date> listOfDays;
	private Iterator<Date> date;
	private static Date currentDay;
	private static SimulationTime instance;

	private SimulationTime() {
	}

	public static SimulationTime getInstance() {
		if (instance == null) {
			instance = new SimulationTime();

		}
		return instance;
	}

	public void initListOfDays(Set<Date> days) {
		listOfDays = new ArrayList<Date>(days);
		Collections.sort(listOfDays);
		date = listOfDays.iterator();
		currentDay = date.next();
	}

	public Date getNextDay() {
		if (date.hasNext()) {
			currentDay = date.next();
			return currentDay;
		}
		return null;

	}

	public static Date getCurrentDay() {
		return currentDay;
	}

}
