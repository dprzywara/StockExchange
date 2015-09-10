package com.capgemini.stockExchange.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.capgemini.stockExchange.Exceptions.MyException;
import com.capgemini.stockExchange.model.AllStocks;
import com.capgemini.stockExchange.model.Stocks;

public class ReadCSV {

	public AllStocks read() throws ClassNotFoundException {

		AllStocks stocks = new AllStocks();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("dane.csv").getFile());
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		try {
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				String[] stock = line.split(cvsSplitBy);
				if(stock.length!=3){
					throw new MyException("Wrong separator");
				}
				Date nextDate = dateFormat.parse(stock[1]);
				addToAllStocks(stocks, stock, nextDate);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}catch (MyException e) {
			e.printStackTrace();
		
	}
		finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return stocks;
	}

	private static void addToAllStocks(AllStocks stocks, String[] stock, Date nextDate) {
		if (stocks.getStocks().containsKey(nextDate)) {
			stocks.getStocks().get(nextDate).put(stock[0], Double.parseDouble(stock[2]));
		}
		if (!stocks.getStocks().containsKey(nextDate)) {
			stocks.put(nextDate, new Stocks(stock[0], Double.parseDouble(stock[2])));
		}
	}

}