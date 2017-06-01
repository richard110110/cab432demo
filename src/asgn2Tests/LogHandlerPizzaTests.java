package asgn2Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import junit.*;
import asgn2Exceptions.CustomerException;
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
	String noType;
	String wrongType;
	String lowQuauntity;
	String highQuantity;
	String tooFastOrderTime;
	String tooFastdeliveryTime;
	String shortCookingTime;
	ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	
	@Before
	public void populateList() throws PizzaException, LogHandlerException{
		pizzas = LogHandler.populatePizzaDataset(".//logs/20170101.txt");
		noType = new String("19:00:00" + "20:00:00" + "Test Name" + "0123456789" + "DVC" + "5" + "5" + "" + "1");
		wrongType = new String("19:00:00" + "20:00:00" + "Test Name" + "0123456789" + "DVC" + "5" + "5" + "ABC" + "1");
		lowQuauntity = new String("19:00:00" + "20:00:00" + "Test Name" + "0123456789" + "DVC" + "5" + "5" + "PZV" + "0");
		highQuantity = new String("19:00:00" + "20:00:00" + "Test Name" + "0123456789" + "DVC" + "5" + "5" + "PZV" + "11");
		tooFastOrderTime = new String("15:00:00" + "20:00:00" + "Test Name" + "0123456789" + "DVC" + "5" + "5" + "PZV" + "1");
		tooFastdeliveryTime = new String("19:00:00" + "15:00:00" + "Test Name" + "0123456789" + "DVC" + "5" + "5" + "PZV" + "1");
		shortCookingTime = new String("19:00:00" + "19:05:00" + "Test Name" + "0123456789" + "DVC" + "5" + "5" + "PZV" + "1");
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
	
	@Test(expected = LogHandlerException.class)
	public void testNoType() throws PizzaException, LogHandlerException{
		LogHandler.createPizza(noType);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testWrongType() throws PizzaException, LogHandlerException{
		LogHandler.createPizza(wrongType);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testLowQuauntity() throws PizzaException, LogHandlerException{
		LogHandler.createPizza(lowQuauntity);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testHighQuantity() throws PizzaException, LogHandlerException{
		LogHandler.createPizza(highQuantity);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testTooFastOrderTime() throws PizzaException, LogHandlerException{
		LogHandler.createPizza(tooFastOrderTime);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testTooFastdeliveryTime() throws PizzaException, LogHandlerException{
		LogHandler.createPizza(tooFastdeliveryTime);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testShortCookingTime() throws PizzaException, LogHandlerException{
		LogHandler.createPizza(shortCookingTime);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testCreatePizzaNoData() throws PizzaException, LogHandlerException{
		LogHandler.createPizza("no data");
	}
	
	@Test(expected = LogHandlerException.class)
	public void testPopulatePizzaDatasetNoFile() throws PizzaException, LogHandlerException{
		LogHandler.populatePizzaDataset("no file");
	}
}
