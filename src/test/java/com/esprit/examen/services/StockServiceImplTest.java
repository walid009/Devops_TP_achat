package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StockServiceImplTest {
   
	@Autowired
    StockServiceImpl ss  = new StockServiceImpl();
    

   
	
	@Test
	public void testretrieveAllStocks()
	{
		List<Stock> allStocks = ss.retrieveAllStocks();
		int expected = allStocks.size();
		Stock st = new Stock("test test",10,100);
		Stock stdb = ss.addStock(st);
		assertEquals(expected, allStocks.size());
		ss.deleteStock(stdb.getIdStock());
	}
	
	@Test
	public void testaddStock()
	{
		Stock st = new Stock("testtest",10,100);
		Stock stdb = ss.addStock(st);
		assertEquals(st.getLibelleStock(),stdb.getLibelleStock());
		ss.deleteStock(stdb.getIdStock());
	}
	
	@Test
	public void testretrieveStock()
	{   Stock st = new Stock("testtest",10,100);
	    Stock stdb = ss.addStock(st);
		Stock stdb1 = ss.retrieveStock(stdb.getIdStock());
		assertNotNull(stdb1);
		ss.deleteStock(stdb.getIdStock());
		
	}
	
	@Test
	public void testUpdateStock() throws ParseException
	{
		Stock st = new Stock("testtest",10,100);
		Stock stdb = ss.addStock(st);
		Stock st1 = new Stock("heys",50,100);
		Stock stdb1 = ss.updateStock(st1);
		assertEquals(stdb.getIdStock(),stdb1.getIdStock());
		assertNotEquals(stdb1.getLibelleStock(), stdb.getLibelleStock());
		ss.deleteStock(stdb.getIdStock());
	}
	
	@Test
	public void testdeleteStock()
	{  Stock st = new Stock("testtest",10,100);
	   Stock stdb = ss.addStock(st);
		ss.deleteStock(stdb.getIdStock());  
		assertNull(ss.retrieveStock(stdb.getIdStock()));
	
	}
	
	
	
}