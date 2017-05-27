package asgn2Tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import junit.*;
import asgn2Exceptions.CustomerException;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Person A
 *
 */
public class CustomerFactoryTests {
	// TO DO
	
	private final String PICKUP = "PUC";
	private final String DELIVERY = "DVC";
	private final String DRONE = "DNC";
	private final String IVD_TYPE = "IVD";

	
	@Test(expected = CustomerException.class)
	public void CustomerFactoryHasInvalidCustomerType() throws CustomerException {
		CustomerFactory.getCustomer(IVD_TYPE, "NAME", "0123456789", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void CustomerFactoryHasNullCustomerType() throws CustomerException {
		CustomerFactory.getCustomer(null, "NAME", "0123456789", 0, 0);
	}
	
	
	//pick up
	@Test
	public void CustomerFactoryCreatePickUpCustomer() throws CustomerException {
		 CustomerFactory.getCustomer(PICKUP, "NAME", "0123456789", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreatePickUpCustomerWithInvalidXlocation() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "NAME", "0123456789", 1, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreatePickUpCustomerWithInvalidYlocation() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "NAME", "0123456789", 0, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreatePickUpCustomerWithInvalidXYlocation() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "NAME", "0123456789", 1, 1);
	}
	
	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreatePickUpCustomerWithNullName() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, null, "0123456789", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreatePickUpCustomerWithInvalidNameWhichLengthIsSmallerThan1() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "", "0123456789", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreatePickUpCustomerWithInvalidNameWhichLengthIsBiggerThan20() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "ABCDEFGHIJKLMNOPQRSTUV", "0123456789", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreatePickUpCustomerWithInvalidMobileNumberNull() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "Name", "", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreatePickUpCustomerWithInvalidMobileNumberWhichLengthIsNotEqualTo10() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "Name", "01234567890123", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreatePickUpCustomerWithInvalidMobileNumberWhichIsNotStartWith0() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "Name", "1234567890", 0, 0);
	}
	
	
	//driverdelivery
	
	
	//dronedelivery
	
	
	
	
	
	

  /*  Customer richard;
    Customer mattw;
    Customer cassie;
    
    @Test @Before
    public void setUp() throws CustomerException{
    	richard = CustomerFactory.getCustomer("PUC", "richard", "0123456789", 0, 0);
    	mattw = CustomerFactory.getCustomer("DVC", "mattw", "0451003138", 6, 8);		
		cassie = CustomerFactory.getCustomer("DNC", "cassie","0520520520", 3, 4);
    }
    
    @Test
    public void testPickUpCustomer() throws CustomerException{
    	richard = CustomerFactory.getCustomer("PUC", "richard", "0123456789", 0, 0);
    }
     
    @Test(expected = CustomerException.class)
    public void testInvalidCustomerCode() throws CustomerException {
        Customer hernny = CustomerFactory.getCustomer("HHH", "hernny", "0451003138", 0, 0);
    }*/
    

  /*  @Test
    public void testPickUpCustomer() throws CustomerException {
        Customer customer = CustomerFactory.getCustomer("PUC", testName, testMobile, 0, 0);
        assertEquals("Pick Up", customer.getCustomerType());
    }
    @Test
    public void testDriverCustomer() throws CustomerException {
        Customer customer = CustomerFactory.getCustomer("DNC", testName, testMobile, testLocX, testLocY);
        assertEquals(TYPE_DRIVER, customer.getCustomerType());
    }
    @Test
    public void testDroneCustomer() throws CustomerException {
        Customer customer = CustomerFactory.getCustomer(DRONE, testName, testMobile, testLocX, testLocY);
        assertEquals(TYPE_DRIVER, customer.getCustomerType());
    }

    @Test(expected = CustomerException.class)
    public void testInvalidCustomerCode() throws CustomerException {
        Customer customer = CustomerFactory.getCustomer("XXX", testName, testMobile, testLocX, testLocY);
    }*/
	
}
