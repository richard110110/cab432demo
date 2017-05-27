package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** A class that represents a customer that has chosen to have their pizza delivered by a drone. 
 * This class extends the abstract Customer class and calculates the delivery distance as the Euclidean 
 * Distance between the customer and the restaurant.  A description of the class's
 * fields and their constraints is provided in Section 5.2 of the Assignment Specification.
 * 
 * @author PersonB
 *
 */
public class DroneDeliveryCustomer extends Customer {


	/**
	 *  This class represents a customer of the Pizza Palace restaurant that has chosen to have their pizza delivered by 
	 *  a drone.  A CustomerException is thrown if the any of the constraints listed in Section 5.2 of the Assignment
	 *  Specification are violated. 
     *
     * <P> PRE: TRUE
     * <P> POST: All field values are set
     *
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY  The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @throws CustomerException if supplied parameters are invalid
	 * 
	 */
	public DroneDeliveryCustomer(String name, String mobileNumber, int locationX, int locationY) throws CustomerException {
		// TO DO	
	/*	if (type != "Pick Up" || type != "Driver Delivery" || type != "Drone Delivery") {
			throw new CustomerException("invalid type of customer");
		}
		
		if (name.length() >= 20 || name.length() <= 1 || name.contains("")){
			throw new CustomerException("invalid name of customer");
		}
		
		if (mobileNumber.length() != 10 || mobileNumber.charAt(0)!= '0'){
			throw new CustomerException("invalid mobileNumber");
		}
		
		
		if ((type == "Pick up" && locationX != 0)||(type == "Pick up"&& locationY != 0)){
			throw new CustomerException("When the type is Pick Up, the x location and y location must to be 0");
		}
		
		if ((type == "Driver Delivery" && locationX > 10) || (type == "Driver Delivery" && locationX < -10) || 
				(type == "Driver Delivery" && locationY > 10) || (type == "Driver Delivery" && locationY < -10)){
			throw new CustomerException("When the type is a kind of delivery, the absolute value of x coordinate and y coordinate cannot over 10 blocks ");
		}
		
		if ((type == "Drone Delivery" && locationX > 10) || (type == "Drone Delivery" && locationX < -10) || 
				(type == "Drone Delivery" && locationY > 10) || (type == "Drone Delivery" && locationY < -10)){
			throw new CustomerException("When the type is a kind of delivery, the absolute value of x coordinate and y coordinate cannot over 10 blocks");
		}*/
		super(name, mobileNumber, locationX, locationY, "Drone Delivery");
		
	}

	/**
	 * Returns the Euclidean Distance between the instance of DroneDeliveryCustomer and the restaurant. Overrides  
	 * getDeliveryDistance() in Customer.
	 * 
     * @return The distance between the restaurant and the customer in Euclidean distance.
	 */
	@Override
	public double getDeliveryDistance() {
		// TO DO
		double x_distance = (double) Math.pow(0-super.getLocationX(), 2);
		double y_distance = (double) Math.pow(0-super.getLocationY(), 2);
		return Math.sqrt(x_distance + y_distance);
		
	}
	

}
