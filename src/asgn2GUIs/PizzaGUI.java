package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.text.DefaultCaret;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import asgn2Customers.Customer;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.PizzaException;
import asgn2Exceptions.LogHandlerException;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.SequentialGroup;

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
	private JPanel filePanel;
	private JLabel fileChoose;
	private JTextField filePath;
	private JTextField totalProfit;
	private JTextField totalDistance;
	
	private JButton browseFile;
	private JButton displayInfoBtn;
	private JButton resetBtn;
	private JButton calTotalProfitButton;
	private JButton calTotalDistanceButton;
	private JLabel totalDistanceLabel;
	private JLabel totalProfitLabel;
	private JFileChooser fileChooser;
	private String fileName;
	private DefaultTableModel customerTable;
	private DefaultTableModel pizzasModel;
	private DecimalFormat decimalFormat;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		super(title);
		initComponents();
		gui = this;
		decimalFormat = new DecimalFormat("0.00");
	}
	
	private void initComponentsinfilePanel(){
		filePanel = new javax.swing.JPanel();
		filePanel.setBackground(new java.awt.Color(102, 204, 0));
	    filePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "fileOperated", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(153, 255, 102))); // NOI18N
	    filePanel.setForeground(java.awt.Color.cyan);
	     
        fileChoose = new javax.swing.JLabel(); 
	    fileChoose.setBackground(java.awt.Color.green);
	    fileChoose.setFont(new java.awt.Font("Marlett", 0, 14)); // NOI18N
	    fileChoose.setForeground(new java.awt.Color(255, 153, 102));
	    fileChoose.setText("File Path && Name:");
	     
	    filePath = new javax.swing.JTextField();
		filePath = new JTextField(20);
		filePath.setEditable(false);
		filePath.setBackground(new java.awt.Color(0, 255, 255));
	    filePath.setForeground(new java.awt.Color(255, 51, 51));
	    
	    
	    browseFile = new javax.swing.JButton();
        browseFile.addActionListener(this);
        browseFile.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        browseFile.setForeground(new java.awt.Color(255, 102, 102));
        browseFile.setText("Browse");
        
        displayInfoBtn = new javax.swing.JButton();
		displayInfoBtn.setEnabled(false);
		displayInfoBtn.addActionListener(this);
		displayInfoBtn.setBackground(java.awt.Color.green);
        displayInfoBtn.setForeground(new java.awt.Color(255, 153, 153));
        displayInfoBtn.setText("displayInformation");
        
        
        resetBtn = new javax.swing.JButton();
		resetBtn.setEnabled(false);
		resetBtn.addActionListener(this);
		resetBtn.setBackground(new java.awt.Color(153, 255, 255));
	    resetBtn.setForeground(new java.awt.Color(255, 0, 0));
	    resetBtn.setText("restInfo");
	}
	

	
	private void initComponents() {
		
		initComponentsinfilePanel();
	    
	    javax.swing.GroupLayout filePanelLayout = new javax.swing.GroupLayout(filePanel);
        filePanel.setLayout(filePanelLayout);
        filePanelLayout.setHorizontalGroup(
            filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filePanelLayout.createSequentialGroup()
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(fileChoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filePath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browseFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(filePanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(displayInfoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(filePanelLayout.createSequentialGroup()                                
                                .addGap(18, 18, 18)
                                .addGap(76, 76, 76)
                                ))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(filePanelLayout.createSequentialGroup()
                                .addComponent(resetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                            .addGroup(filePanelLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGap(103, 103, 103)))))
                .addGap(71, 71, 71))
        );
        filePanelLayout.setVerticalGroup(
            filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileChoose)
                    .addComponent(filePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseFile))
                .addGap(18, 18, 18)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayInfoBtn)
                    .addComponent(resetBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addContainerGap())
        );
	    	
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "logs"));
		
		JPanel pizzaSystemPanel = new JPanel();
		pizzaSystemPanel.setLayout(new BorderLayout());
		pizzaSystemPanel.setBackground(new java.awt.Color(255, 102, 102));

		pizzaSystemPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "pizzaSystem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(0, 51, 153))); // NOI18N

		pizzaSystemPanel.setForeground(new java.awt.Color(255, 0, 51));
		
		JPanel customersPanel = new JPanel();
		customersPanel.setLayout(new BorderLayout());
		//customersPanel.setBorder(BorderFactory.createTitledBorder("Customers"));
		customersPanel.setBackground(new java.awt.Color(255, 102, 102));

		customersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "customerInfo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(0, 51, 153))); // NOI18N

		customersPanel.setForeground(new java.awt.Color(255, 0, 51));
		
		customerTable = new DefaultTableModel();
		customerTable.addColumn("Customer Name");
		customerTable.addColumn("Mobile Number");
		customerTable.addColumn("Customer Type");
		customerTable.addColumn("X and Y Location");
		customerTable.addColumn("Distance from Restaurant");
		JTable customersTable = new JTable(customerTable);
		

		customersTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 255), new java.awt.Color(255, 102, 102), new java.awt.Color(153, 153, 255), new java.awt.Color(153, 255, 153)));


		customersTable.setBackground(new java.awt.Color(255, 102, 102));
        customersTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 102, 102))); // NOI18N
        customersTable.setForeground(new java.awt.Color(255, 255, 153));
        customersTable.setGridColor(new java.awt.Color(0, 204, 204));
        
        JScrollPane customersScroller = new javax.swing.JScrollPane();	
        customersScroller.setViewportView(customersTable);
		customersScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		customersScroller.setPreferredSize(new Dimension(600, 200));
		
	
		
		JPanel calTotalDistancePanel = new javax.swing.JPanel();
		
		
		//JLabel totalDistanceLabel = new JLabel("Total distance travelled: ");
		 totalDistanceLabel = new javax.swing.JLabel(); 
		 totalDistanceLabel.setBackground(java.awt.Color.green);
		 totalDistanceLabel.setFont(new java.awt.Font("Marlett", 0, 14)); // NOI18N
		 totalDistanceLabel.setForeground(new java.awt.Color(255, 153, 102));
		 totalDistanceLabel.setText("total Distance:");
		
		 totalDistance = new javax.swing.JTextField();
		 totalDistance = new JTextField(20);		
		 totalDistance.setEditable(false);
		  
		 calTotalDistanceButton = new javax.swing.JButton();
		 calTotalDistanceButton.setText("Calculate");
		 //calTotalDistanceButton = new JButton("Calculate");
		 calTotalDistanceButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
		 calTotalDistanceButton.setEnabled(false);
		 calTotalDistanceButton.addActionListener(this);
		 calTotalDistanceButton.setForeground(new java.awt.Color(255, 102, 102));
		
	        //browseFile.addActionListener(this);
	        
	       
	        
		
		
		
		calTotalDistancePanel.add(totalDistanceLabel);
		calTotalDistancePanel.add(totalDistance);
		calTotalDistancePanel.add(calTotalDistanceButton);
		customersPanel.add(customersScroller, BorderLayout.PAGE_START);
		customersPanel.add(calTotalDistancePanel, BorderLayout.PAGE_END);
		
		
		JPanel pizzasPanel = new JPanel();
		
		pizzasPanel.setLayout(new BorderLayout());
		//pizzasPanel.setBorder(BorderFactory.createTitledBorder("Orders"));
		pizzasPanel.setBackground(new java.awt.Color(255, 102, 102));

		pizzasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "pizzaInfo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(0, 51, 153))); // NOI18N

		pizzasPanel.setForeground(new java.awt.Color(255, 0, 51));
		
		pizzasModel = new DefaultTableModel();
		pizzasModel.addColumn("Pizza Type");
		pizzasModel.addColumn("Quantity");
		pizzasModel.addColumn("Order Price");
		pizzasModel.addColumn("Order Cost");
		pizzasModel.addColumn("Order Profit");
		
		JTable pizzasTable = new JTable(pizzasModel);
		
		pizzasTable.setBackground(new java.awt.Color(255, 102, 102));
        pizzasTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 102, 102))); // NOI18N
        pizzasTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 255), new java.awt.Color(255, 102, 102), new java.awt.Color(153, 153, 255), new java.awt.Color(153, 255, 153)));
        pizzasTable.setForeground(new java.awt.Color(255, 255, 153));
		
		JScrollPane pizzasScroller = new JScrollPane(pizzasTable);
		pizzasScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pizzasScroller.setPreferredSize(new Dimension(600, 200));
		
		JPanel calTotalProfitPanel = new JPanel();
		
		
		 totalProfitLabel = new javax.swing.JLabel(); 
		 totalProfitLabel.setBackground(java.awt.Color.green);
		 totalProfitLabel.setFont(new java.awt.Font("Marlett", 0, 14)); // NOI18N
		 totalProfitLabel.setForeground(new java.awt.Color(255, 153, 102));
		 totalProfitLabel.setText("total Profit:");
		
		
		totalProfit = new JTextField(20);
		
		totalProfit.setEditable(false);
		
		calTotalProfitButton = new javax.swing.JButton();
		 calTotalProfitButton.setText("Calculate");
		 //calTotalDistanceButton = new JButton("Calculate");
		calTotalProfitButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
		 calTotalProfitButton.setEnabled(false);
		 calTotalProfitButton.addActionListener(this);
		 calTotalProfitButton.setForeground(new java.awt.Color(255, 102, 102));
		 
		
		
		
		calTotalProfitPanel.add(totalProfitLabel);
		calTotalProfitPanel.add(totalProfit);
		calTotalProfitPanel.add(calTotalProfitButton);
		pizzasPanel.add(pizzasScroller, BorderLayout.PAGE_START);
		pizzasPanel.add(calTotalProfitPanel, BorderLayout.PAGE_END);
		
		pizzaSystemPanel.add(filePanel, BorderLayout.NORTH);
		pizzaSystemPanel.add(customersPanel, BorderLayout.CENTER);
		pizzaSystemPanel.add(pizzasPanel, BorderLayout.SOUTH);
		
		getContentPane().add(pizzaSystemPanel);
	}

	
	@Override
	public void run() {
		// TO DO
		createAndShowGUI();
	}
	
	private static void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		gui.setResizable(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.pack();
		gui.setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Component source = (Component) e.getSource();
		if (source == browseFile) {
			int returnVal = fileChooser.showOpenDialog(gui);
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				fileName = file.getAbsolutePath();
				filePath.setText(fileName);
				restaurant = new PizzaRestaurant();
				boolean logProcessStatus = false;
				
				try {
					logProcessStatus = restaurant.processLog(fileName);
					
				} catch (CustomerException | PizzaException | LogHandlerException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(gui, e1.getMessage(),  fileName, JOptionPane.ERROR_MESSAGE);					
				}
				if (logProcessStatus == true) {
					displayInfoBtn.setEnabled(true);
					resetBtn.setEnabled(true);
					calTotalDistanceButton.setEnabled(true);
					calTotalProfitButton.setEnabled(true);
					browseFile.setEnabled(false);
					JOptionPane.showMessageDialog(gui, "File loaded successfully.", "Notice", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					displayInfoBtn.setEnabled(false);
					resetBtn.setEnabled(false);
					calTotalDistanceButton.setEnabled(false);
					calTotalProfitButton.setEnabled(false);
					browseFile.setEnabled(true);
				}
			} 
		} else if (source == displayInfoBtn) {
			for (int i = 0; i < restaurant.getNumPizzaOrders(); i++) {
				Pizza currentPizza = null;
				Customer currentCustomer = null;
				try {
					currentPizza = restaurant.getPizzaByIndex(i);
					currentCustomer = restaurant.getCustomerByIndex(i);	
					customerTable.addRow(new Object[]{currentCustomer.getName(), currentCustomer.getMobileNumber(), currentCustomer.getCustomerType(),
							currentCustomer.getLocationX()+", "+currentCustomer.getLocationY(),String.valueOf(decimalFormat.format(currentCustomer.getDeliveryDistance()))});
					pizzasModel.addRow(new Object[]{currentPizza.getPizzaType(), currentPizza.getQuantity(), String.valueOf(decimalFormat.format(currentPizza.getOrderPrice())), 
							String.valueOf(decimalFormat.format(currentPizza.getOrderCost())), String.valueOf(decimalFormat.format(currentPizza.getOrderProfit()))});
					displayInfoBtn.setEnabled(false);
				} catch (PizzaException | CustomerException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(gui, e1.getMessage(), fileName, JOptionPane.ERROR_MESSAGE);
				}
			}
			JOptionPane.showMessageDialog(gui, "Information generated.", "Notice", JOptionPane.INFORMATION_MESSAGE);
			
		} else if (source == calTotalDistanceButton) {
			totalDistance.setText(String.valueOf(decimalFormat.format(restaurant.getTotalDeliveryDistance())));
			JOptionPane.showMessageDialog(gui, "Total distance calculated.", "Notice", JOptionPane.INFORMATION_MESSAGE);
		} else if (source == calTotalProfitButton) {
			totalProfit.setText(String.valueOf(decimalFormat.format(restaurant.getTotalProfit())));
			JOptionPane.showMessageDialog(gui, "Total profit calculated.", "Notice", JOptionPane.INFORMATION_MESSAGE);
		
		} else if (source == resetBtn) {
			
			restaurant.resetDetails();
			customerTable.setRowCount(0);
			pizzasModel.setRowCount(0);
			displayInfoBtn.setEnabled(false);
			resetBtn.setEnabled(false);
			calTotalDistanceButton.setEnabled(false);
			calTotalProfitButton.setEnabled(false);
			browseFile.setEnabled(true);
			filePath.setText("");
			totalDistance.setText("");
			totalProfit.setText("");
			JOptionPane.showMessageDialog(gui, "All data reset.", "Information", JOptionPane.INFORMATION_MESSAGE);
		} else {
			
		}
		
	}

	

}