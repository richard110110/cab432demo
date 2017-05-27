package asgn2Tests;
import static org.junit.Assert.*;
import junit.*;
import java.time.LocalTime;
import org.junit.Before;
import org.junit.Test;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;

//import asgn2Pizzas.PizzaFactory;
import asgn2Pizzas.PizzaTopping;
import asgn2Pizzas.VegetarianPizza;
import asgn2Pizzas.PizzaTopping;
import java.time.temporal.ChronoUnit;
import java.time.Period;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */
public class PizzaTests {
	// TO DO
	private static final double DELTA = 1e-15;
	MeatLoversPizza Domino;
	MargheritaPizza Julius;
	VegetarianPizza Capers;
	private  LocalTime start = LocalTime.of(19, 00);
	private  LocalTime end = LocalTime.of(23, 00);
	
	@Before @Test
	public void setUp() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
		Julius = new MargheritaPizza(7, orderTime, deliveryTime);
		Capers = new VegetarianPizza(9, orderTime, deliveryTime);
	}
	
	@Test
	public void testTheInformationOfMeatLoversPizzaCanBeRead() throws PizzaException{
		assertEquals(5, Domino.getQuantity());
		assertEquals("Meat Lovers", Domino.getPizzaType());
		assertEquals(5, Domino.getCostPerPizza(),DELTA);
		assertEquals(12.00, Domino.getPricePerPizza(),DELTA);
		assertEquals(25, Domino.getOrderCost(),DELTA);
		assertEquals(60, Domino.getOrderPrice(),DELTA);
		assertEquals(35, Domino.getOrderProfit(),DELTA);
		assertEquals(true, Domino.containsTopping(PizzaTopping.CHEESE));
		assertEquals(true, Domino.containsTopping(PizzaTopping.TOMATO));		
		assertEquals(true, Domino.containsTopping(PizzaTopping.BACON));
		assertEquals(true, Domino.containsTopping(PizzaTopping.SALAMI));	
		assertEquals(true, Domino.containsTopping(PizzaTopping.PEPPERONI));
							
	}
	
	@Test(expected = PizzaException.class)
	public void testInvalidOrderTimeWhichIsEarlierThan19() throws PizzaException{
		LocalTime orderTime = LocalTime.of(18, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
	}
	
	
	@Test(expected = PizzaException.class)
	public void testInvalidOrderTimeWhichIsLaterThan23() throws PizzaException{
		LocalTime orderTime = LocalTime.of(00, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testInvalidDeliveryTimeWhichIsEarlierThan19() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(18, 00);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testInvalidDeliveryTimeWhichIsEarlierThanOrderTime() throws PizzaException{
		LocalTime orderTime = LocalTime.of(21, 00);
		LocalTime deliveryTime = LocalTime.of(20, 00);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testTheDifferenceBetweenDeliveryTimeAndOrderTimeIsNotBeyongThan10Minutes() throws PizzaException{
		LocalTime orderTime = LocalTime.of(21, 00);
		LocalTime deliveryTime = LocalTime.of(21, 9);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testTheDeliveryTimeAndOrderTimeAreInDifferentHourButTheTimeDifferenceIsNotBeyong10minutes() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 58);
		LocalTime deliveryTime = LocalTime.of(21, 6);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
	}
	
	@Test
	public void testEachToppingCostInPizza() throws PizzaException{
		assertEquals(0.5, PizzaTopping.TOMATO.getCost(),DELTA);	
		assertEquals(1, PizzaTopping.CHEESE.getCost(),DELTA);
		assertEquals(1.5, PizzaTopping.BACON.getCost(),DELTA);
		assertEquals(1, PizzaTopping.SALAMI.getCost(),DELTA);
		assertEquals(1,PizzaTopping.PEPPERONI.getCost(),DELTA);
	}
	
	@Test
	public void testCalculateCostPerPizza() throws PizzaException{
		assertEquals(5, Domino.getCostPerPizza(),DELTA);
	}
	
	@Test
	public void testGetCostPerPizza() throws PizzaException{
		assertEquals(5, Domino.getCostPerPizza(),DELTA);
	}
	
	@Test
	public void testGetOrderCost() throws PizzaException{
		assertEquals(25, Domino.getOrderCost(),DELTA);
	}
	
	@Test
	public void testGetOrderPrice() throws PizzaException{
		assertEquals(60, Domino.getOrderPrice(),DELTA);
	}
	
	@Test
	public void testGetOrderProfit() throws PizzaException{
		assertEquals(35, Domino.getOrderProfit(),DELTA);
	}
	
	@Test
	public void testContainsTopping() throws PizzaException{
		assertEquals(true, Domino.containsTopping(PizzaTopping.CHEESE));
		assertEquals(true, Domino.containsTopping(PizzaTopping.TOMATO));		
		assertEquals(true, Domino.containsTopping(PizzaTopping.BACON));
		assertEquals(true, Domino.containsTopping(PizzaTopping.SALAMI));	
		assertEquals(true, Domino.containsTopping(PizzaTopping.PEPPERONI));
	}
	
	@Test
	public void testNotContainsTopping() throws PizzaException{
		assertEquals(false, Domino.containsTopping(PizzaTopping.CAPSICUM));
		assertEquals(false, Domino.containsTopping(PizzaTopping.EGGPLANT));
		assertEquals(false, Domino.containsTopping(PizzaTopping.MUSHROOM));
	}
	
	@Test
	public void testGetQuantity() throws PizzaException{
		assertEquals(5, Domino.getQuantity());
	}
	
	@Test(expected = PizzaException.class)
	public void testQuantityIsBiggerThan10() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Domino = new MeatLoversPizza(11, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testQuantityIsSmallerThan1() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Domino = new MeatLoversPizza(0, orderTime, deliveryTime);
	}
	
	
	
	@Test
	public void testGetPizzaType() throws PizzaException{
		assertEquals("Meat Lovers", Domino.getPizzaType());
	}
	
	
	
	
	
	
	
	

}
