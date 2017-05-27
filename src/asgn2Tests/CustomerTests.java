package asgn2Tests;

import static org.junit.Assert.*;


import junit.*;
import org.junit.Before;
import org.junit.Test;
import asgn2Exceptions.CustomerException;
import asgn2Customers.Customer;

import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Person A
 * 
 *
 */
public class CustomerTests {
	// TO DO
	private static final double DELTA = 1e-15;//delta - the maximum delta between expected and actual for which both numbers are still considered equal.
	PickUpCustomer richard;
	DriverDeliveryCustomer mattw;
	DroneDeliveryCustomer cassie;
	Customer amy;
	
	@Before @Test
	public void setUp() throws CustomerException{
		richard = new PickUpCustomer("richard", "0123456789", 0, 0);
		mattw = new DriverDeliveryCustomer("mattw", "0451003138", -6, 8);
		cassie = new DroneDeliveryCustomer("cassie", "0520520520", 3, 4);
		
	}
	
	//test the DriverDeliveryCustomer as an instance for testing the functionality in the abstract Customer class
	
	@Test
	public void testTheInformationOfDriverDeliveryCustomerCanBeRead() throws CustomerException{
		assertEquals("mattw", mattw.getName());
		assertEquals("0451003138", mattw.getMobileNumber());
		assertEquals(-6, mattw.getLocationX());
		assertEquals(8, mattw.getLocationY());
		assertEquals("Driver Delivery", mattw.getCustomerType());
	}
	
	@Test
	public void testGetType() throws CustomerException{
		assertEquals("Driver Delivery", mattw.getCustomerType());
	}
	@Test
	public void testGetName() throws CustomerException{
		assertEquals("mattw", mattw.getName());
	}
	
	
	@Test
	public void testGetNameWithWhiteSpace() throws CustomerException{
		cassie = new DroneDeliveryCustomer("richard guo", "0520520520", 3, 4);
		assertEquals("richard guo", cassie.getName());
	}
	@Test(expected = CustomerException.class)
	public void testTheLengthOfNameWhichIsSmallerThanOne() throws CustomerException{
		mattw = new DriverDeliveryCustomer("", "0451003138", 6, 8);
	}
	
	@Test(expected = CustomerException.class)
	public void testTheLengthOfNameWhichIsBiggerThanTwenty() throws CustomerException{
		mattw = new DriverDeliveryCustomer("abcdefghijklmnopqrstuvw", "0451003138", 6, 8);
	}
	
	@Test(expected = CustomerException.class)
	public void testTheContentOfNameWhichIsOnlyWhiteSpace() throws CustomerException{
		mattw = new DriverDeliveryCustomer("", "0451003138", 6, 8);
	}
	
	@Test
	public void testGetMobileNumber() throws CustomerException{
		assertEquals("0451003138", mattw.getMobileNumber());
	}
	
	@Test(expected = CustomerException.class)
	public void testTheLengthOfMobileNumberIsNotEqualToTen() throws CustomerException{
		mattw = new DriverDeliveryCustomer("mattw", "04510031388", 6, 8);
	}
	
	@Test(expected = CustomerException.class)
	public void testTheMobileNumberDoesNotStartWith0() throws CustomerException{
		mattw = new DriverDeliveryCustomer("mattw", "1451003138", 6, 8);
	}
	
	@Test
	public void testGetLocationX() throws CustomerException {	
		assertEquals(-6,mattw.getLocationX() );
	}
	
	@Test
	public void testGetLocationY() throws CustomerException {	
		assertEquals(8,mattw.getLocationY() );
	}
	
	@Test(expected = CustomerException.class)
	public void testTheLimitationOfXLocationCoordinateInDriverDeliveryCustomer() throws CustomerException{
		mattw = new DriverDeliveryCustomer("mattw", "0451003138",11, 8);
	}
	
	@Test(expected = CustomerException.class)
	public void testTheLimitationOfYLocationCoordinateInDriverDeliveryCustomer() throws CustomerException{
		mattw = new DriverDeliveryCustomer("mattw", "0451003138",8, 11);
	}
	
	
	@Test
	public void testGetDeliveryDistanceForDriverDelivery() throws CustomerException{
		assertEquals(14, mattw.getDeliveryDistance(),DELTA);
	}
	
	@Test
	public void testGetDeliveryDistanceForDroneDelivery() throws CustomerException{
		assertEquals(5, cassie.getDeliveryDistance(),DELTA);
	}
	
	@Test
	public void testGetDeliveryDistanceForPickUp() throws CustomerException{
		assertEquals(0, richard.getDeliveryDistance(),DELTA);
	}
	
	
	
	
	
	
	
	
}
