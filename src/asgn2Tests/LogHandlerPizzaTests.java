package asgn2Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import junit.*;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.LogHandler;
import asgn2Pizzas.*;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/
public class LogHandlerPizzaTests {
	// TO DO
	ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	ArrayList<Pizza> excepTest = new ArrayList<Pizza>();
	
	@Before
	public void populateList() throws PizzaException, LogHandlerException{
		pizzas = LogHandler.populatePizzaDataset(".//logs/20170101.txt");
	}
	
	@Test
	public void testPizzaType(){
		assertEquals(pizzas.get(0).getPizzaType(), "Vegetarian");
	}
	
	@Test
	public void testCalculateCost(){
		assertEquals(11.0,pizzas.get(0).getOrderCost(), 0.001);
	}
	@Test
	public void testGetOrderPrice(){
		assertEquals(20, pizzas.get(0).getOrderPrice(),0.001);
	}
	@Test
	public void testGetPricePer(){
		assertEquals(10.0, pizzas.get(0).getPricePerPizza(),0.001);
	}
	@Test
	public void testGetOrderProfit(){
		assertEquals(9.0, pizzas.get(0).getOrderProfit(),0.001);
	}
	@Test
	public void testGetQuantity(){
		assertEquals(2, pizzas.get(0).getQuantity());
	}
}
