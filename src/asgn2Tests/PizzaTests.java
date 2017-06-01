package asgn2Tests;

import static org.junit.Assert.*;
import java.time.LocalTime;
import org.junit.Before;
import org.junit.Test;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.PizzaTopping;
import asgn2Pizzas.VegetarianPizza;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza,
 * asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. Note that
 * an instance of asgn2Pizzas.MeatLoversPizza should be used to test the
 * functionality of the asgn2Pizzas.Pizza abstract class.
 * 
 * @author Person B
 *
 */
public class PizzaTests {
	
	private static final double DELTA = 1e-15;
	MeatLoversPizza Domino;
	MargheritaPizza Julius;
	VegetarianPizza Capers;

	@Before
	@Test
	public void setUp() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
		Julius = new MargheritaPizza(7, orderTime, deliveryTime);
		Capers = new VegetarianPizza(9, orderTime, deliveryTime);
	}

	//Meatlover
	@Test
	public void testTheInformationOfMeatLoversPizzaCanBeRead() throws PizzaException {
		assertEquals(5, Domino.getQuantity());
		assertEquals("Meat Lovers", Domino.getPizzaType());
		assertEquals(5, Domino.getCostPerPizza(), DELTA);
		assertEquals(12.00, Domino.getPricePerPizza(), DELTA);
		assertEquals(25, Domino.getOrderCost(), DELTA);
		assertEquals(60, Domino.getOrderPrice(), DELTA);
		assertEquals(35, Domino.getOrderProfit(), DELTA);
		assertEquals(true, Domino.containsTopping(PizzaTopping.CHEESE));
		assertEquals(true, Domino.containsTopping(PizzaTopping.TOMATO));
		assertEquals(true, Domino.containsTopping(PizzaTopping.BACON));
		assertEquals(true, Domino.containsTopping(PizzaTopping.SALAMI));
		assertEquals(true, Domino.containsTopping(PizzaTopping.PEPPERONI));

	}

	@Test(expected = PizzaException.class)
	public void testInvalidOrderTimeWhichIsEarlierThan19() throws PizzaException {
		LocalTime orderTime = LocalTime.of(18, 59);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
	}

	@Test(expected = PizzaException.class)
	public void testInvalidOrderTimeWhichIsLaterThan23() throws PizzaException {
		LocalTime orderTime = LocalTime.of(23, 01);
		LocalTime deliveryTime = LocalTime.of(23, 15);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
	}

	@Test(expected = PizzaException.class)
	public void testInvalidDeliveryTimeWhichIsEarlierThan19() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(18, 00);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
	}

	@Test(expected = PizzaException.class)
	public void testInvalidDeliveryTimeWhichIsEarlierThanOrderTime() throws PizzaException {
		LocalTime orderTime = LocalTime.of(21, 00);
		LocalTime deliveryTime = LocalTime.of(20, 00);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
	}

	@Test(expected = PizzaException.class)
	public void testTheDifferenceBetweenDeliveryTimeAndOrderTimeIsNotBeyongThan10Minutes() throws PizzaException {
		LocalTime orderTime = LocalTime.of(21, 00);
		LocalTime deliveryTime = LocalTime.of(21, 9);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
	}

	@Test(expected = PizzaException.class)
	public void testTheDeliveryTimeAndOrderTimeAreInDifferentHourButTheTimeDifferenceIsNotBeyong10minutes() throws PizzaException {
		LocalTime orderTime = LocalTime.of(20, 58);
		LocalTime deliveryTime = LocalTime.of(21, 6);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testThePizzahasbeenThrownout() throws PizzaException {
		LocalTime orderTime = LocalTime.of(20, 58);
		LocalTime deliveryTime = LocalTime.of(21, 59);
		Domino = new MeatLoversPizza(5, orderTime, deliveryTime);
	}
	

	@Test
	public void testEachToppingCostInPizza() throws PizzaException {
		assertEquals(0.5, PizzaTopping.TOMATO.getCost(), DELTA);
		assertEquals(1, PizzaTopping.CHEESE.getCost(), DELTA);
		assertEquals(1.5, PizzaTopping.BACON.getCost(), DELTA);
		assertEquals(1, PizzaTopping.SALAMI.getCost(), DELTA);
		assertEquals(1, PizzaTopping.PEPPERONI.getCost(), DELTA);
	}

	@Test
	public void testCalculateCostPerPizza() throws PizzaException {
		assertEquals(5, Domino.getCostPerPizza(), DELTA);
	}

	@Test
	public void testGetCostPerPizza() throws PizzaException {
		assertEquals(5, Domino.getCostPerPizza(), DELTA);
	}

	@Test
	public void testGetOrderCost() throws PizzaException {
		assertEquals(25, Domino.getOrderCost(), DELTA);
	}

	@Test
	public void testGetOrderPrice() throws PizzaException {
		assertEquals(60, Domino.getOrderPrice(), DELTA);
	}

	@Test
	public void testGetOrderProfit() throws PizzaException {
		assertEquals(35, Domino.getOrderProfit(), DELTA);
	}

	@Test
	public void testContainsTopping() throws PizzaException {
		assertEquals(true, Domino.containsTopping(PizzaTopping.CHEESE));
		assertEquals(true, Domino.containsTopping(PizzaTopping.TOMATO));
		assertEquals(true, Domino.containsTopping(PizzaTopping.BACON));
		assertEquals(true, Domino.containsTopping(PizzaTopping.SALAMI));
		assertEquals(true, Domino.containsTopping(PizzaTopping.PEPPERONI));
	}

	@Test
	public void testNotContainsTopping() throws PizzaException {
		assertEquals(false, Domino.containsTopping(PizzaTopping.CAPSICUM));
		assertEquals(false, Domino.containsTopping(PizzaTopping.EGGPLANT));
		assertEquals(false, Domino.containsTopping(PizzaTopping.MUSHROOM));
	}

	@Test
	public void testGetQuantity() throws PizzaException {
		assertEquals(5, Domino.getQuantity());
	}

	@Test(expected = PizzaException.class)
	public void testQuantityIsBiggerThan10() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Domino = new MeatLoversPizza(11, orderTime, deliveryTime);
	}

	@Test(expected = PizzaException.class)
	public void testQuantityIsSmallerThan1() throws PizzaException {
		LocalTime orderTime = LocalTime.of(19, 00);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		Domino = new MeatLoversPizza(0, orderTime, deliveryTime);
	}

	@Test
	public void testGetPizzaType() throws PizzaException {
		assertEquals("Meat Lovers", Domino.getPizzaType());
	}
	
	//MargheritaPizza
	@Test
	public void testEachToppingCostInMargheritaPizza() throws PizzaException {
		assertEquals(0.5, PizzaTopping.TOMATO.getCost(), DELTA);
		assertEquals(1, PizzaTopping.CHEESE.getCost(), DELTA);
	}
	@Test
	public void testContainsToppingInMargheritaPizza() throws PizzaException {
		assertEquals(true, Julius.containsTopping(PizzaTopping.CHEESE));
		assertEquals(true, Julius.containsTopping(PizzaTopping.TOMATO));
	}
	
	@Test
	public void testGetOrderCostInMarheritaPizza() throws PizzaException {
		assertEquals(10.5, Julius.getOrderCost(), DELTA);
	}
	
	
	//VegetarianPizza
	@Test
	public void testEachToppingCostInVegetarianPizza() throws PizzaException {
		assertEquals(0.5, PizzaTopping.TOMATO.getCost(), DELTA);
		assertEquals(1, PizzaTopping.CHEESE.getCost(), DELTA);
		assertEquals(0.8, PizzaTopping.EGGPLANT.getCost(), DELTA);
		assertEquals(2.0, PizzaTopping.MUSHROOM.getCost(), DELTA);
		assertEquals(1.2, PizzaTopping.CAPSICUM.getCost(), DELTA);
	}
	@Test
	public void testContainsToppingInVegetarianPizza() throws PizzaException {
		assertEquals(true, Capers.containsTopping(PizzaTopping.CHEESE));
		assertEquals(true, Capers.containsTopping(PizzaTopping.TOMATO));
		assertEquals(true, Capers.containsTopping(PizzaTopping.EGGPLANT));
		assertEquals(true, Capers.containsTopping(PizzaTopping.MUSHROOM));
		assertEquals(true, Capers.containsTopping(PizzaTopping.CAPSICUM));
	}
	
	@Test
	public void testGetOrderCostInVegetarianPizza() throws PizzaException {
		assertEquals(49.5, Capers.getOrderCost(), DELTA);
	}
	

}
