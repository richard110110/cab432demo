package asgn2Tests;

import org.junit.Test;
import asgn2Exceptions.CustomerException;
import asgn2Customers.CustomerFactory;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Person A N9292501
 *
 */
public class CustomerFactoryTests {

	private final String IVD_TYPE = "IVD";

	// test invalid customer code
	@Test(expected = CustomerException.class)
	public void testCustomerFactoryHasInvalidCustomerType() throws CustomerException {
		CustomerFactory.getCustomer(IVD_TYPE, "NAME", "0123456789", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testCustomerFactoryHasNullCustomerType() throws CustomerException {
		CustomerFactory.getCustomer(null, "NAME", "0123456789", 0, 0);
	}

	// pick up test
	@Test
	public void testCustomerFactoryCreatePickUpCustomer() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "NAME", "0123456789", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testCustomerFactoryCreatePickUpCustomerWithInvalidXlocation() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "NAME", "0123456789", 1, 0);
	}

	@Test(expected = CustomerException.class)
	public void testCustomerFactoryCreatePickUpCustomerWithInvalidYlocation() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "NAME", "0123456789", 0, 1);
	}

	@Test(expected = CustomerException.class)
	public void testCustomerFactoryCreatePickUpCustomerWithInvalidXYlocation() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "NAME", "0123456789", 1, 1);
	}

	@Test
	public void testCustomerFactoryCreatePickUpCustomerWithValidXYlocation() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "NAME", "0123456789", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testCustomerFactoryCreatePickUpCustomerWithNullName() throws CustomerException {
		CustomerFactory.getCustomer("PUC", null, "0123456789", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testCustomerFactoryCreatePickUpCustomerWithInvalidNameWhichLengthIsSmallerThan1()
			throws CustomerException {
		CustomerFactory.getCustomer("PUC", "", "0123456789", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testCustomerFactoryCreatePickUpCustomerWithInvalidNameWhichLengthIsBiggerThan20()
			throws CustomerException {
		CustomerFactory.getCustomer("PUC", "ABCDEFGHIJKLMNOPQRSTUV", "0123456789", 0, 0);
	}

	@Test
	public void testCustomerFactoryCreatePickUpCustomerWithValidName() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "NAME", "0123456789", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testCustomerFactoryCreatePickUpCustomerWithInvalidMobileNumberNull() throws CustomerException {
		CustomerFactory.getCustomer("PUC", "Name", "", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testCustomerFactoryCreatePickUpCustomerWithInvalidMobileNumberWhichLengthIsNotEqualTo10()
			throws CustomerException {
		CustomerFactory.getCustomer("PUC", "Name", "01234567890123", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testCustomerFactoryCreatePickUpCustomerWithInvalidMobileNumberWhichLengthIsGreaterthan10()
			throws CustomerException {
		CustomerFactory.getCustomer("PUC", "Name", "01234567890123123123", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testCustomerFactoryCreatePickUpCustomerWithInvalidMobileNumberWhichLengthIsSmallerthan10()
			throws CustomerException {
		CustomerFactory.getCustomer("PUC", "Name", "0123456", 0, 0);
	}

	@Test(expected = CustomerException.class)
	public void testCustomerFactoryCreatePickUpCustomerWithInvalidMobileNumberWhichIsNotStartWith0()
			throws CustomerException {
		CustomerFactory.getCustomer("PUC", "Name", "1234567890", 0, 0);
	}

	// driver delivery test
	@Test
	public void CustomerFactoryCreateDriverDeliveryCustomer() throws CustomerException {
		CustomerFactory.getCustomer("DVC", "richard", "0123456789", 2, 2);
	}

	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreateDriverDeliveryCustomerWithInvalidYlocationPositiveCoordinate()
			throws CustomerException {
		CustomerFactory.getCustomer("DVC", "richard", "0123456789", 8, 11);
	}

	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreateDriverDeliveryCustomerWithInvalidYlocationNegativeCoordinate()
			throws CustomerException {
		CustomerFactory.getCustomer("DVC", "richard", "0123456789", 8, -11);
	}

	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreateDriverDeliveryCustomerWithInvalidXlocationPositiveCoordinate()
			throws CustomerException {
		CustomerFactory.getCustomer("DVC", "richard", "0123456789", 11, 8);
	}

	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreateDriverDeliveryCustomerWithInvalidXlocationNegativeCoordinate()
			throws CustomerException {
		CustomerFactory.getCustomer("DVC", "richard", "0123456789", -11, 8);
	}

	@Test
	public void CustomerFactoryCreateDriverDeliveryCustomerWithValidlocation() throws CustomerException {
		CustomerFactory.getCustomer("DVC", "richard", "0123456789", 8, 8);
	}

	// drone delivery test

	@Test
	public void CustomerFactoryCreateDroneDeliveryCustomer() throws CustomerException {
		CustomerFactory.getCustomer("DNC", "mattw", "0123456789", 2, 2);
	}

	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreateDroneDeliveryCustomerWithInvalidYlocationPositiveCoordinate()
			throws CustomerException {
		CustomerFactory.getCustomer("DNC", "mattw", "0123456789", 8, 11);
	}

	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreateDroneDeliveryCustomerWithInvalidYlocationNegativeCoordinate()
			throws CustomerException {
		CustomerFactory.getCustomer("DNC", "mattw", "0123456789", 8, -11);
	}

	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreateDroneDeliveryCustomerWithInvalidXlocationPositiveCoordinate()
			throws CustomerException {
		CustomerFactory.getCustomer("DNC", "mattw", "0123456789", 11, 8);
	}

	@Test(expected = CustomerException.class)
	public void CustomerFactoryCreateDroneDeliveryCustomerWithInvalidXlocationNegativeCoordinate()
			throws CustomerException {
		CustomerFactory.getCustomer("DNC", "mattw", "0123456789", -11, 8);
	}

	@Test
	public void CustomerFactoryCreateDriverDroneCustomerWithValidlocation() throws CustomerException {
		CustomerFactory.getCustomer("DVC", "mattw", "0123456789", 2, 2);
	}

}
