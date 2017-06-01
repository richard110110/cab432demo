package asgn2Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import junit.*;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;


/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Person B
 *
 */
public class RestaurantPizzaTests {
	// TO DO
	PizzaRestaurant restaurant = new PizzaRestaurant();
	
	@Before
	public void setUp() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(".//logs/20170101.txt");
	}
	
	@Test
	public void testGetPizzaByIndex() throws CustomerException, PizzaException, LogHandlerException{
		assertEquals("Vegetarian", restaurant.getPizzaByIndex(0).getPizzaType());
		assertEquals("Margherita", restaurant.getPizzaByIndex(1).getPizzaType());
	}
	
	@Test
	public void testGetNumPizzaOrders(){
		assertEquals(3, restaurant.getNumPizzaOrders());
	}
	
	@Test
	public void testGetTotalProfit(){
		assertEquals(36.5, restaurant.getTotalProfit(),0.001);
	}
	
	@Test
	public void testResetDetails(){
		restaurant.resetDetails();
		assert(restaurant.getNumPizzaOrders() == 0);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testProcessLogNofile() throws CustomerException, PizzaException, LogHandlerException{
		assert(restaurant.processLog(null));
	}
	
	@Test(expected = LogHandlerException.class)
	public void testProcessLogWrongFile() throws CustomerException, PizzaException, LogHandlerException{
		assert(restaurant.processLog("wrong file"));
	}
	
	@Test(expected = PizzaException.class)
	public void testGetPizzaByIndexException() throws PizzaException{
		restaurant.getPizzaByIndex(4);
	}
}
