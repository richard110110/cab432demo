package asgn2Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

import org.junit.Before;
import org.junit.Test;
import asgn2Exceptions.CustomerException;
import asgn2Customers.Customer;
/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Person A
 */
public class LogHandlerCustomerTests {
	// TO DO
	private String noName;
	private String longName;
	private String noType;
	private String wrongType;
	private String noMobileNumber;
	private String noLocationX;
	private String noLocationY;
	ArrayList<Customer> customers = new ArrayList<Customer>();
	@Before
	public void setUp() throws CustomerException, LogHandlerException{
		customers = LogHandler.populateCustomerDataset(".//logs/20170101.txt");
		noName = new String("19:00:00" + "20:00:00" + "" + "0123456789" + "DVC" + "5" + "5" + "PZV" + "1");
		longName = new String("19:00:00" + "20:00:00" + "Long Test Name" + "0123456789" + "DVC" + "5" + "5" + "PZV" + "1");
		noType = new String("19:00:00" + "20:00:00" + "Test Name" + "0123456789" + "" + "5" + "5" + "PZV" + "1");
		wrongType = new String("19:00:00" + "20:00:00" + "Test Name" + "0123456789" + "ABC" + "5" + "5" + "PZV" + "1");
		noMobileNumber = new String("19:00:00" + "20:00:00" + "Test Name" + "" + "DVC" + "5" + "5" + "PZV" + "1");
		noLocationX = new String("19:00:00" + "20:00:00" + "Test Name" + "0123456789" + "DVC" + "" + "5" + "PZV" + "1");
		noLocationY = new String("19:00:00" + "20:00:00" + "Test Name" + "0123456789" + "DVC" + "5" + "" + "PZV" + "1");
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
	public void testNoName() throws CustomerException, LogHandlerException{
		LogHandler.createCustomer(noName);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testLongName() throws CustomerException, LogHandlerException{
		LogHandler.createCustomer(longName);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testNoType() throws CustomerException, LogHandlerException{
		LogHandler.createCustomer(noType);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testWrongType() throws CustomerException, LogHandlerException{
		LogHandler.createCustomer(wrongType);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testNoMobileNumber() throws CustomerException, LogHandlerException{
		LogHandler.createCustomer(noMobileNumber);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testNoLocationX() throws CustomerException, LogHandlerException{
		LogHandler.createCustomer(noLocationX);
	}
	
	@Test(expected = LogHandlerException.class)
	public void testNoLocationY() throws CustomerException, LogHandlerException{
		LogHandler.createCustomer(noLocationY);
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
