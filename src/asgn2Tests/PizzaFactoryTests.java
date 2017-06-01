package asgn2Tests;
import asgn2Pizzas.PizzaFactory;
import org.junit.Test;
import java.time.LocalTime;

import asgn2Exceptions.PizzaException;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Person B 
 * 
 */
public class PizzaFactoryTests {
	// TO DO
	private final String IVD_TYPE = "IVD";
	private LocalTime orderTime = LocalTime.of(19, 00);
	private LocalTime deliveryTime = LocalTime.of(19, 20);
	
	@Test(expected = PizzaException.class)
	public void testPizzaFactoryHasInvalidPizzaType() throws PizzaException {
		PizzaFactory.getPizza(IVD_TYPE, 8, orderTime, deliveryTime);
	}
	
	// PizzaMeatLover
	@Test
	public void testPizzaFactoryOrderMeatLoversPizza() throws PizzaException{
		PizzaFactory.getPizza("PZL", 8, orderTime, deliveryTime);
	}
		
	@Test(expected = PizzaException.class)
	public void testPizzaFactoryOrderMeatLoversPizzaWithInvalidQuantityThatGreaterThan10() throws PizzaException{
		PizzaFactory.getPizza("PZL", 11, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testPizzaFactoryOrderMeatLoversPizzaWithNoQuantity() throws PizzaException{
		PizzaFactory.getPizza("PZL", -1, orderTime, deliveryTime);
	}
	
	@Test
	public void testPizzaFactoryOrderMeatLoversPizzaWithValidOrderTime() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 01);
		LocalTime deliveryTime = LocalTime.of(19, 20);
		PizzaFactory.getPizza("PZL", 8, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testPizzaFactoryOrderMeatLoversPizzaWithInvalidOrderTimeThatIsEarlierThan19() throws PizzaException{
		LocalTime orderTime = LocalTime.of(18, 00);
		PizzaFactory.getPizza("PZL", 8, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testPizzaFactoryOrderMeatLoversPizzaWithInvalidOrderTimeThatIslaterThan23() throws PizzaException{
		LocalTime orderTime = LocalTime.of(23, 01);
		LocalTime deliveryTime = LocalTime.of(23, 20);
		PizzaFactory.getPizza("PZL", 8, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testPizzaFactoryOrderMeatLoversPizzaWithDeliveryTimeIsEarlierThanOrderTime() throws PizzaException{
		LocalTime orderTime = LocalTime.of(21, 00);
		LocalTime deliveryTime = LocalTime.of(20, 10);
		PizzaFactory.getPizza("PZL", 8, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testPizzaFactoryOrderMeatLoversPizzaThatTheDifferenceBetweenOrderTimeAndDeliveryTimeIsLessThan10Minutes() throws PizzaException{
		LocalTime orderTime = LocalTime.of(20, 00);
		LocalTime deliveryTime = LocalTime.of(20, 9);
		PizzaFactory.getPizza("PZL", 8, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testPizzaFactoryOrderMeatLoversPizzaThatTheDifferenceBetweenOrderTimeAndDeliveryTimeIsLessThan10MinutesInDifferentHour() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 58);
		LocalTime deliveryTime = LocalTime.of(20, 7);
		PizzaFactory.getPizza("PZL", 8, orderTime, deliveryTime);
	}
	
	@Test(expected = PizzaException.class)
	public void testPizzaFactoryOrderMeatLoversPizzaHasBeenThrownOut() throws PizzaException{
		LocalTime orderTime = LocalTime.of(19, 58);
		LocalTime deliveryTime = LocalTime.of(20, 59);
		PizzaFactory.getPizza("PZL", 8, orderTime, deliveryTime);
	}
	//MargheritaPizza
	public void testPizzaFactoryOrderMargheritaPizza() throws PizzaException{
		PizzaFactory.getPizza("PZM", 8, orderTime, deliveryTime);
	}
	
	//VegetarianPizza
	public void testPizzaFactoryOrderVegetarianPizza() throws PizzaException{
		PizzaFactory.getPizza("PZV", 8, orderTime, deliveryTime);
	}
	
	
	
}
