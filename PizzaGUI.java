package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author CHENXI GUO and Mattw Stone
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {	
	
	private static final long serialVersionUID = -7031008862559936404L;
	private static final int WIDTH = 900;
	private static final int HEIGHT = 700;
	
	
	private static PizzaGUI gui;
	
	
	private PizzaRestaurant restaurant;
	
	
	
	
	private JButton browseButton;
    private JButton displayButton;
    private JButton resetButton;
    private JButton calProfit;
    private JButton calDistance;
    private JFileChooser fileChooser;
    private JLabel fileChoose;
    private JPanel filePanel;
    private JPanel customerPizzaPanel;
    private JScrollPane customerScroll;
    private JScrollPane pizzaScroll;
    private JTable customerTable;
    private JTable pizzaTable;
    private JTextField filePath;
    private JTextField totalProfit;
    private JTextField totalDistance;
    private DecimalFormat deciamlFormat;
    private String fileName;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		super(title);
		gui = this;
		restaurant = new PizzaRestaurant();
		//createGUI();
		initComponents();
		
	}
	
	private void initComponents(){
		
		filePanel = new javax.swing.JPanel();
        fileChoose = new javax.swing.JLabel();
        filePath = new javax.swing.JTextField();
        filePath.setEditable(false);
        
        browseButton = new javax.swing.JButton();
        browseButton.addActionListener(this);
        
        displayButton = new javax.swing.JButton();
        displayButton.setEnabled(false);
        displayButton.addActionListener(this);
        
        
        resetButton = new javax.swing.JButton();
        resetButton.setEnabled(false);
        resetButton.addActionListener(this);
        
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "logs"));
        
        calProfit = new javax.swing.JButton();
        calProfit.setEnabled(false);
        calProfit.addActionListener(this);
        totalProfit = new javax.swing.JTextField();
        totalProfit.setEditable(false);
        
        
        calDistance = new javax.swing.JButton();
        calDistance.setEnabled(false);
        calDistance.addActionListener(this);
        
        
        totalDistance = new javax.swing.JTextField();
        totalDistance.setEditable(false);
        
        customerPizzaPanel = new javax.swing.JPanel();
        customerScroll = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        pizzaScroll = new javax.swing.JScrollPane();
        pizzaTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        filePanel.setBackground(new java.awt.Color(102, 204, 0));
        filePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "fileOperated", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(153, 255, 102))); // NOI18N
        filePanel.setForeground(java.awt.Color.cyan);

        fileChoose.setBackground(java.awt.Color.green);
        fileChoose.setFont(new java.awt.Font("Marlett", 0, 14)); // NOI18N
        fileChoose.setForeground(new java.awt.Color(255, 153, 102));
        fileChoose.setText("fileChoose");

        filePath.setBackground(new java.awt.Color(0, 255, 255));
        filePath.setForeground(new java.awt.Color(255, 51, 51));

        browseButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        browseButton.setForeground(new java.awt.Color(255, 102, 102));
        browseButton.setText("Browse");

        displayButton.setBackground(java.awt.Color.green);
        displayButton.setForeground(new java.awt.Color(255, 153, 153));
        displayButton.setText("displayInformation");

        resetButton.setBackground(new java.awt.Color(153, 255, 255));
        resetButton.setForeground(new java.awt.Color(255, 0, 0));
        resetButton.setText("clearInfo");

        calProfit.setBackground(new java.awt.Color(204, 102, 0));
        calProfit.setForeground(new java.awt.Color(255, 102, 102));
        calProfit.setText("calProfit");

        totalProfit.setBackground(new java.awt.Color(51, 102, 255));
        totalProfit.setForeground(new java.awt.Color(255, 255, 255));

        calDistance.setBackground(new java.awt.Color(255, 153, 153));
        calDistance.setForeground(new java.awt.Color(102, 0, 255));
        calDistance.setText("calDistance");

        totalDistance.setBackground(new java.awt.Color(0, 51, 255));
        totalDistance.setForeground(new java.awt.Color(255, 255, 255));

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
                        .addComponent(browseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(filePanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(displayButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(filePanelLayout.createSequentialGroup()
                                .addComponent(calProfit, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(totalProfit, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                .addGap(76, 76, 76)
                                .addComponent(calDistance, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(filePanelLayout.createSequentialGroup()
                                .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                            .addGroup(filePanelLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(totalDistance, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
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
                    .addComponent(browseButton))
                .addGap(18, 18, 18)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayButton)
                    .addComponent(resetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calProfit)
                    .addComponent(totalProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calDistance))
                .addContainerGap())
        );

        customerPizzaPanel.setBackground(new java.awt.Color(255, 255, 102));
        customerPizzaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer and Pizza Table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 51, 102))); // NOI18N
        customerPizzaPanel.setForeground(new java.awt.Color(255, 153, 153));

        customerTable.setBackground(new java.awt.Color(255, 102, 102));
        customerTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 102, 102))); // NOI18N
        customerTable.setForeground(new java.awt.Color(255, 255, 153));
        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer Name", "Mobile Number", "Customer Type", "X and Y Location", "Delivery Distance from Restaurant"
            }
        ));
        customerScroll.setViewportView(customerTable);

        pizzaTable.setBackground(new java.awt.Color(255, 102, 102));
        pizzaTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pizza Table", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 102, 51))); // NOI18N
        pizzaTable.setForeground(new java.awt.Color(255, 102, 102));
        pizzaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Pizza Type", "Quantity", "Order Price", "Order Cost", "Order Profit"
            }
        ));
        pizzaScroll.setViewportView(pizzaTable);

        javax.swing.GroupLayout customerPizzaPanelLayout = new javax.swing.GroupLayout(customerPizzaPanel);
        customerPizzaPanel.setLayout(customerPizzaPanelLayout);
        customerPizzaPanelLayout.setHorizontalGroup(
            customerPizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPizzaPanelLayout.createSequentialGroup()
                .addComponent(customerScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pizzaScroll)
                .addGap(0, 0, 0))
        );
        customerPizzaPanelLayout.setVerticalGroup(
            customerPizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPizzaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerPizzaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerScroll)
                    .addComponent(pizzaScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(customerPizzaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(filePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(customerPizzaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        
		
		
	}
	
	
	
	
	
	private void createGUIandDisplay(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setSize(WIDTH,HEIGHT);
		this.setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Component source = (Component) e.getSource();
		if (source == browseButton) {
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
					JOptionPane.showMessageDialog(gui, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (logProcessStatus) {
					displayButton.setEnabled(true);
					resetButton.setEnabled(true);
					calDistance.setEnabled(true);
					calProfit.setEnabled(true);
					browseButton.setEnabled(false);
					JOptionPane.showMessageDialog(gui, "File loaded.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			} 
		} else if (source == displayButton) {
			for (int i = 0; i < restaurant.getNumPizzaOrders(); i++) {
				Pizza currentPizza = null;
				Customer currentCustomer = null;
				try {
					currentPizza = restaurant.getPizzaByIndex(i);
					currentCustomer = restaurant.getCustomerByIndex(i);	
					customerTable.add(source, new Object[]{currentCustomer.getName(), currentCustomer.getMobileNumber(), currentCustomer.getCustomerType(),
						currentCustomer.getLocationX()+", "+currentCustomer.getLocationY(),String.valueOf(deciamlFormat.format(currentCustomer.getDeliveryDistance()))});
					pizzaTable.add(source, new Object[]{currentPizza.getPizzaType(), currentPizza.getQuantity(), String.valueOf(deciamlFormat.format(currentPizza.getOrderPrice())), 
							String.valueOf(deciamlFormat.format(currentPizza.getOrderCost())), String.valueOf(deciamlFormat.format(currentPizza.getOrderProfit()))});
					displayButton.setEnabled(false);
				} catch (PizzaException | CustomerException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(gui, e1.getMessage() + " (index " + i +").", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			JOptionPane.showMessageDialog(gui, "Information displayed.", "Information", JOptionPane.INFORMATION_MESSAGE);
			
		} else if (source == calDistance) {
			totalDistance.setText(String.valueOf(deciamlFormat.format(restaurant.getTotalDeliveryDistance())));
			JOptionPane.showMessageDialog(gui, "Total distance calculated.", "Information", JOptionPane.INFORMATION_MESSAGE);
		} else if (source == calProfit) {
			totalProfit.setText(String.valueOf(deciamlFormat.format(restaurant.getTotalProfit())));
			JOptionPane.showMessageDialog(gui, "Total profit calculated.", "Information", JOptionPane.INFORMATION_MESSAGE);
		} else if (source == resetButton) {
			restaurant.resetDetails();
			customerTable.setRowHeight(0);
			pizzaTable.setRowHeight(0);
			displayButton.setEnabled(false);
			resetButton.setEnabled(false);
			calDistance.setEnabled(false);
			calProfit.setEnabled(false);
			browseButton.setEnabled(true);
			filePath.setText("");
			
			totalDistance.setText("");
			totalProfit.setText("");
			JOptionPane.showMessageDialog(gui, "All data reset.", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	
	@Override
	public void run() {
		// TO DO
		//createGUI();
		createGUIandDisplay();

	}

	

}