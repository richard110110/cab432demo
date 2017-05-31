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
	public void populateDataset() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(".//logs/20170101.txt");
	}
	
	@Test
	public void testLog() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant testProcessLog = new PizzaRestaurant();
		assert(testProcessLog.processLog(".//logs/20170101.txt"));
	}
	
	@Test
	public void testManyLogs() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant testMultipleLogs = new PizzaRestaurant();
		assert(testMultipleLogs.processLog(".//logs/20170101.txt"));
		assert(testMultipleLogs.processLog(".//logs/20170102.txt"));
		assert(testMultipleLogs.processLog(".//logs/20170103.txt"));
	}
	
	@Test (expected = LogHandlerException.class)
	public void testNoLog() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant testNoLog = new PizzaRestaurant();
		testNoLog.processLog("There is no log file");
	}
	
	@Test 
	public void testSetsToEmpty(){
		PizzaRestaurant testNoLog = new PizzaRestaurant();
		try {
			testNoLog.processLog("There is no log file");
		} catch (CustomerException | PizzaException | LogHandlerException e) {
			assert(testNoLog.getNumPizzaOrders() == 0);
		}
	}
	
	@Test
	public void testGetPizzaIndex() throws PizzaException{
		assertEquals("Vegetarian", restaurant.getPizzaByIndex(0).getPizzaType());
		assertEquals("Margherita", restaurant.getPizzaByIndex(1).getPizzaType());
	}
	
	@Test(expected=PizzaException.class)
	public void testGetPizzaIndexException() throws PizzaException{
		restaurant.getPizzaByIndex(32);
	}
	
	@Test
	public void testGetNumPizzaOrders(){
		assertEquals(3, restaurant.getNumPizzaOrders());
	}
	
	@Test
	public void testTotalProfit(){
		assertEquals(36.5, restaurant.getTotalProfit(),0.001);
	}
	
	@Test
	public void testResetDetails(){
		restaurant.resetDetails();
		assert(restaurant.getNumPizzaOrders() == 0);
	}
}
