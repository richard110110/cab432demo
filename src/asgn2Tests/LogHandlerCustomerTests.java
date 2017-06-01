package asgn2Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.lang.model.type.NoType;

import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

import org.junit.Before;
import org.junit.Test;
import junit.*;
import asgn2Exceptions.CustomerException;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Person A
 */
public class LogHandlerCustomerTests {
	// TO DO
	ArrayList<Customer> customers = new ArrayList<Customer>();
	@Before
	public void setUp() throws CustomerException, LogHandlerException{
		customers = LogHandler.populateCustomerDataset(".//logs/20170101.txt");
	}
	
	@Test
	public void testGetName(){		
		assertEquals(customers.get(0).getName(), "Casey Jones");
	}
	
	@Test
	public void testGetCustomerType(){		
		assertEquals(customers.get(0).getCustomerType(), "Driver Delivery");
	}
	
	@Test
	public void testLocationX(){		
		assertEquals(customers.get(0).getLocationX(), 5);
	}
	
	@Test
	public void testLocationY(){		
		assertEquals(customers.get(0).getLocationX(), 5);
	}
	
	@Test
	public void testGetMobileNumber(){		
		assertEquals(customers.get(0).getMobileNumber(), "0123456789");
	}

	@Test
	public void testOtherLineCustomer(){		
		assertEquals(customers.get(1).getName(), "April O'Neal");
		assertEquals(customers.get(1).getCustomerType(), "Drone Delivery");
		assertEquals(customers.get(1).getLocationX(), 3);
		assertEquals(customers.get(1).getLocationY(), 4);
		assertEquals(customers.get(1).getMobileNumber(), "0987654321");
	}

	@Test(expected = LogHandlerException.class)
	public void testCreateCustomer() throws CustomerException, LogHandlerException{
		LogHandler.createCustomer(null);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testPopulateCustomerDataset() throws CustomerException, LogHandlerException{
		LogHandler.populateCustomerDataset("no file");
	}
}
