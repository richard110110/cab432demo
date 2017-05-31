package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import asgn2Customers.Customer;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.PizzaException;
import asgn2Exceptions.LogHandlerException;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;

/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a dummy class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	private static final long serialVersionUID = -8363697766626046823L;
	private PizzaRestaurant restaurant;
	
	private static PizzaGUI gui;
	private JTextField filePath;
	private JTextField totalProfit;
	private JTextField totalDistance;
	private JButton browseFileBtn;
	private JButton displayInfoBtn;
	private JButton resetBtn;
	private JButton calTotalProfitBtn;
	private JButton calTotalDistanceBtn;
	private JFileChooser fc;
	private String fileName;
	private DefaultTableModel customersModel;
	private DefaultTableModel pizzasModel;
	private DecimalFormat df;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		super(title);
		initComponents();
		gui = this;
		df = new DecimalFormat("0.00");
	}
	
	private void initComponents() {
		JPanel filePanel = new JPanel();
		JLabel selectFileLabel = new JLabel("File name: ");
		filePath = new JTextField(20);
		filePath.setEditable(false);
		browseFileBtn = new JButton("Browse...");
		browseFileBtn.addActionListener(this);
		displayInfoBtn = new JButton("Display information");
		displayInfoBtn.setEnabled(false);
		displayInfoBtn.addActionListener(this);
		resetBtn = new JButton("Reset");
		resetBtn.setEnabled(false);
		resetBtn.addActionListener(this);
		filePanel.add(selectFileLabel);
		filePanel.add(filePath);
		filePanel.add(browseFileBtn);
		filePanel.add(displayInfoBtn);
		filePanel.add(resetBtn);
		fc = new JFileChooser();
		fc.setCurrentDirectory(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "logs"));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel customersPanel = new JPanel();
		customersPanel.setLayout(new BorderLayout());
		customersPanel.setBorder(BorderFactory.createTitledBorder("Customers"));
		customersModel = new DefaultTableModel();
		customersModel.addColumn("Customer Name");
		customersModel.addColumn("Mobile Number");
		customersModel.addColumn("Customer Type");
		customersModel.addColumn("X and Y Location");
		customersModel.addColumn("Distance from Restaurant");
		JTable customersTable = new JTable(customersModel);
		JScrollPane customersScroller = new JScrollPane(customersTable);
		customersScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		customersScroller.setPreferredSize(new Dimension(600, 200));
		JPanel calTotalDistancePanel = new JPanel();
		JLabel totalDistanceLabel = new JLabel("Total distance travelled: ");
		totalDistance = new JTextField(20);
		totalDistance.setEditable(false);
		calTotalDistanceBtn = new JButton("Calculate");
		calTotalDistanceBtn.setEnabled(false);
		calTotalDistanceBtn.addActionListener(this);
		calTotalDistancePanel.add(totalDistanceLabel);
		calTotalDistancePanel.add(totalDistance);
		calTotalDistancePanel.add(calTotalDistanceBtn);
		customersPanel.add(customersScroller, BorderLayout.PAGE_START);
		customersPanel.add(calTotalDistancePanel, BorderLayout.PAGE_END);
		
		
		JPanel pizzasPanel = new JPanel();
		pizzasPanel.setLayout(new BorderLayout());
		pizzasPanel.setBorder(BorderFactory.createTitledBorder("Orders"));
		pizzasModel = new DefaultTableModel();
		pizzasModel.addColumn("Pizza Type");
		pizzasModel.addColumn("Quantity");
		pizzasModel.addColumn("Order Price");
		pizzasModel.addColumn("Order Cost");
		pizzasModel.addColumn("Order Profit");
		JTable pizzasTable = new JTable(pizzasModel);
		JScrollPane pizzasScroller = new JScrollPane(pizzasTable);
		pizzasScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pizzasScroller.setPreferredSize(new Dimension(600, 200));
		JPanel calTotalProfitPanel = new JPanel();
		JLabel totalProfitLabel = new JLabel("Total profit made: ");
		totalProfit = new JTextField(20);
		totalProfit.setEditable(false);
		calTotalProfitBtn = new JButton("Calculate");
		calTotalProfitBtn.setEnabled(false);
		calTotalProfitBtn.addActionListener(this);
		calTotalProfitPanel.add(totalProfitLabel);
		calTotalProfitPanel.add(totalProfit);
		calTotalProfitPanel.add(calTotalProfitBtn);
		pizzasPanel.add(pizzasScroller, BorderLayout.PAGE_START);
		pizzasPanel.add(calTotalProfitPanel, BorderLayout.PAGE_END);
		
		mainPanel.add(filePanel, BorderLayout.NORTH);
		mainPanel.add(customersPanel, BorderLayout.CENTER);
		mainPanel.add(pizzasPanel, BorderLayout.SOUTH);
		
		getContentPane().add(mainPanel);
	}

	
	@Override
	public void run() {
		// TO DO
		createAndShowGUI();
	}
	
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		gui.setResizable(false);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//gui.setPreferredSize(new Dimension(500, 700));
		gui.setLocation(new Point(700, 200));
		gui.pack();
		gui.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Component source = (Component) e.getSource();
		if (source == browseFileBtn) {
			int returnVal = fc.showOpenDialog(gui);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				fileName = file.getAbsolutePath();
				filePath.setText(fileName);
				restaurant = new PizzaRestaurant();
				boolean logProcessStatus = false;
				try {
					logProcessStatus = restaurant.processLog(fileName);
				} catch (CustomerException | PizzaException | LogHandlerException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(gui, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (logProcessStatus) {
					displayInfoBtn.setEnabled(true);
					resetBtn.setEnabled(true);
					calTotalDistanceBtn.setEnabled(true);
					calTotalProfitBtn.setEnabled(true);
					browseFileBtn.setEnabled(false);
					JOptionPane.showMessageDialog(gui, "File loaded.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			} 
		} else if (source == displayInfoBtn) {
			for (int i = 0; i < restaurant.getNumPizzaOrders(); i++) {
				Pizza currentPizza = null;
				Customer currentCustomer = null;
				try {
					currentPizza = restaurant.getPizzaByIndex(i);
					currentCustomer = restaurant.getCustomerByIndex(i);	
					customersModel.addRow(new Object[]{currentCustomer.getName(), currentCustomer.getMobileNumber(), currentCustomer.getCustomerType(),
							currentCustomer.getLocationX()+", "+currentCustomer.getLocationY(),String.valueOf(df.format(currentCustomer.getDeliveryDistance()))});
					pizzasModel.addRow(new Object[]{currentPizza.getPizzaType(), currentPizza.getQuantity(), String.valueOf(df.format(currentPizza.getOrderPrice())), 
							String.valueOf(df.format(currentPizza.getOrderCost())), String.valueOf(df.format(currentPizza.getOrderProfit()))});
					displayInfoBtn.setEnabled(false);
				} catch (PizzaException | CustomerException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(gui, e1.getMessage() + " (index " + i +").", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			JOptionPane.showMessageDialog(gui, "Information displayed.", "Information", JOptionPane.INFORMATION_MESSAGE);
			
		} else if (source == calTotalDistanceBtn) {
			totalDistance.setText(String.valueOf(df.format(restaurant.getTotalDeliveryDistance())));
			JOptionPane.showMessageDialog(gui, "Total distance calculated.", "Information", JOptionPane.INFORMATION_MESSAGE);
		} else if (source == calTotalProfitBtn) {
			totalProfit.setText(String.valueOf(df.format(restaurant.getTotalProfit())));
			JOptionPane.showMessageDialog(gui, "Total profit calculated.", "Information", JOptionPane.INFORMATION_MESSAGE);
		} else if (source == resetBtn) {
			restaurant.resetDetails();
			customersModel.setRowCount(0);
			pizzasModel.setRowCount(0);
			displayInfoBtn.setEnabled(false);
			resetBtn.setEnabled(false);
			calTotalDistanceBtn.setEnabled(false);
			calTotalProfitBtn.setEnabled(false);
			browseFileBtn.setEnabled(true);
			filePath.setText("");
			totalDistance.setText("");
			totalProfit.setText("");
			JOptionPane.showMessageDialog(gui, "All data reset.", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	

}