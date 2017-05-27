package asgn2Pizzas;


import java.time.LocalTime;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;
import java.time.Period;

import asgn2Exceptions.CustomerException;
//import asgn1SoccerCompetition.SoccerTeam;
import asgn2Exceptions.PizzaException;


/**
 * An abstract class that represents pizzas sold at the Pizza Palace restaurant. 
 * The Pizza class is used as a base class of VegetarianPizza, MargheritaPizza and MeatLoversPizza. 
 * Each of these subclasses have a different set of toppings. A description of the class's fields
 * and their constraints is provided in Section 5.1 of the Assignment Specification. 
 * 
 * @author Person A
 *
 */
public abstract class Pizza  {
	protected int quantity;
	protected LocalTime orderTime;
	protected LocalTime deliveryTime;
	protected String type;
	protected double price;
	
	protected double totalPrice;
	protected double meatLoversCost = 12.00;
	protected double vegetarianCost = 10.00;
	protected double margheritaCost = 8.00;
	
	
	
	private double costPerPizza;
	private double sumPrice;
	//private double perCost;
	private double sumCost;
	
	
	
	
	protected ArrayList<PizzaTopping> toppings;
	private boolean haveTopping;
	
	
	
	/**
	 *  This class represents a pizza produced at the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.1. 
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification
	 *  are violated. 
     *
     *  PRE: TRUE
	 *  POST: All field values except cost per pizza are set
	 * 
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @param type -  A human understandable description of this Pizza type
	 * @param price - The price that the pizza is sold to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 * 
	 */
	public Pizza(int quantity, LocalTime orderTime, LocalTime deliveryTime, String type, double price) throws PizzaException{
		// TO DO

		
		long minutesDifference = ChronoUnit.MINUTES.between(orderTime, deliveryTime);
		if (quantity < 1 ){
			throw new PizzaException("the minimum number of ordered pizza is 1");
		}
		
		if (quantity > 10) {
			throw new PizzaException("the maximum number of ordered pizza is 10");
		}
	
		int hourOrder = orderTime.getHour();
		int minuteOrder = orderTime.getMinute();
		int secondOrder = orderTime.getSecond();
		
		int hourDelivery = deliveryTime.getHour();
		int minuteDelivery = deliveryTime.getMinute();
		int secondDelivery = deliveryTime.getSecond();
		
		if (quantity < 1 ){
			throw new PizzaException("the minimum number of ordered pizza is 1");
		}
		
		if (quantity > 10) {
			throw new PizzaException("the maximum number of ordered pizza is 10");
		}
		
		if (hourOrder < 19 || hourOrder > 23){
			throw new PizzaException("Invalid order time");
		}
		
		if (hourDelivery < 19) {		
			throw new PizzaException("Invalid delivery time");
		}
		if( minutesDifference < 10){
		
			throw new PizzaException("we need to cook pizza at least for 10 minutes");
		
		}
		

		
		if(!(type.equals("Margherita") || type.equals("Vegetarian") || type.equals("Meat Lovers"))){
			throw new PizzaException("Invalid pizza type");
		}
		
		
		this.quantity = quantity;
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
		this.type = type;
		this.price = price;
		this.totalPrice = this.price * this.quantity;
		
		
		
	}

	/**
	 * Calculates how much a pizza would cost to make calculated from its toppings.
	 *  
     * <P> PRE: TRUE
	 * <P> POST: The cost field is set to sum of the Pizzas's toppings
	 */
	public final void calculateCostPerPizza(){
		// TO DO
		//calculate the cost of pizza according to the type of pizza
	
			
		this.costPerPizza = 0;

		for (int i = 0; i < toppings.size(); i++){
			this.costPerPizza += toppings.get(i).getCost();

		}

	}
	
	/**
	 * Returns the amount that an individual pizza costs to make.
	 * @return The amount that an individual pizza costs to make.
	 */
	public final double getCostPerPizza(){
		// TO DO
		
		//calculateCostPerPizza();
		
		
		
		return this.costPerPizza;
		
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza(){ //tested
		// TO DO

		return this.price;
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderCost(){
		// TO DO
		
		/*for (int i = 0; i < this.quantity; i++) {
			this.costPerPizza += this.sumCost;
		}

		return this.sumCost;
	   // this.calculateCostPerPizza();*/
		this.sumCost = this.costPerPizza * this.quantity;
		return this.sumCost;
	}
	
	/**
	 * Returns the amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderPrice(){//tested
		// TO DO
		/*for (int i = 0; i < this.quantity; i++) {
			this.price += this.sumPrice;
		}
		return this.sumPrice;*/
		this.sumPrice = this.price*this.quantity;
		return this.sumPrice;
		//return this.totalPrice;
	}
	
	
	/**
	 * Returns the profit made by the restaurant on the order which is the order price minus the order cost. 
	 * @return  Returns the profit made by the restaurant on the order which is the order price minus the order cost.
	 */
	public final double getOrderProfit(){
		// TO DO
		//this.profit = 0;
		return this.getOrderPrice() - this.getOrderCost();
		
//		return this.sumPrice - this.sumCost;

		//return this.profit;
		//return this.totalPrice - this.getOrderCost();
	}
	
	

	/**
	 * Indicates if the pizza contains the specified pizza topping or not. 
	 * @param topping -  A topping as specified in the enumeration PizzaTopping
	 * @return Returns  true if the instance of Pizza contains the specified topping and false otherwise.
	 */
	public final boolean containsTopping(PizzaTopping topping){
		// TO DO
		if (toppings.contains(topping) == true) {
			haveTopping = true;
		} else {
			haveTopping = false;
		}
		return haveTopping;

	}
	
	/**
	 * Returns the quantity of pizzas ordered. 
	 * @return the quantity of pizzas ordered. 
	 */
	public final int getQuantity(){
		// TO DO
		return this.quantity;
		
	}

	/**
	 * Returns a human understandable description of the Pizza's type. 
	 * The valid alternatives are listed in Section 5.1 of the Assignment Specification. 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType(){
		// TO DO
		return this.type;
	}


	/**
	 * Compares *this* Pizza object with an instance of an *other* Pizza object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 * You do not need to test this method.
	 *  
	 * @return true if *this* Pizza object and the *other* Pizza object have the same values returned for 	
	 * getCostPerPizza(), getOrderCost(), getOrderPrice(), getOrderProfit(), getPizzaType(), getPricePerPizza() 
	 * and getQuantity().
	 *   
	 */
	@Override
	public boolean equals(Object other){
		Pizza otherPizza = (Pizza) other;
		return ((this.getCostPerPizza()) == (otherPizza.getCostPerPizza()) &&
			(this.getOrderCost()) == (otherPizza.getOrderCost())) &&				
			(this.getOrderPrice()) == (otherPizza.getOrderPrice()) &&
			(this.getOrderProfit()) == (otherPizza.getOrderProfit()) &&
			(this.getPizzaType() == (otherPizza.getPizzaType()) &&
			(this.getPricePerPizza()) == (otherPizza.getPricePerPizza()) &&
			(this.getQuantity()) == (otherPizza.getQuantity()));
	}

	
}
