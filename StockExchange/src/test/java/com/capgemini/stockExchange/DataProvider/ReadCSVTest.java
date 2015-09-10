package com.capgemini.stockExchange.DataProvider;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.capgemini.stockExchange.model.AllStocks;

public class ReadCSVTest {
	AllStocks allStocks;
	Date date;
	SimpleDateFormat dateFormat;
	ReadCSV readCSV;
	@Before
	public void before() throws ParseException{
		dateFormat = new SimpleDateFormat("yyyyMMdd");
		readCSV=new ReadCSV();
	}


	@Ignore
	@Test
	public void shouldRead5Stocks() throws ParseException, ClassNotFoundException {
		allStocks = readCSV.read();
		date = dateFormat.parse("20130104");
		assertEquals(5, allStocks.getStocks().get(date).getStocks().values().size());

	}

}
