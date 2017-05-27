package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Nicholas Stolberg and Niall Stone
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {	
	
	private static final long serialVersionUID = -7031008862559936404L;
	public static final int WIDTH = 900;
	public static final int HEIGHT = 700;
	
	
	private JPanel pizzaTopPanel;
	
	private JLabel pizzaTopSelectLabel;
	
	private JButton loadLogFileBTN;
	private JFileChooser logFile = new JFileChooser();
	private JFileChooser chooser = new JFileChooser();
	
	private JButton browseButton;
	private TextField logFileName;
	
	private JButton displayButton;
	private JButton clearButton;
		
	private PizzaRestaurant restaurant;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		super(title);
		
	}
	
	private void InitialiseGUI(){
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 182, 140));
	}
	
	@SuppressWarnings("deprecation")
	private void createGUI(){
		
		pizzaTopPanel = new javax.swing.JPanel();
		pizzaTopSelectLabel = new javax.swing.JLabel();
		logFile = new javax.swing.JFileChooser();
		browseButton =  new javax.swing.JButton();
		displayButton = new javax.swing.JButton();
		clearButton = new javax.swing.JButton();
		
		
		logFileName = new java.awt.TextField();
		
		
		
		
		InitialiseGUI();
        
	       

	        pizzaTopPanel.setBackground(new java.awt.Color(153, 255, 153));
	        pizzaTopPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "pizzaOrderItem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(61, 181, 216))); // NOI18N

	        pizzaTopSelectLabel.setForeground(new java.awt.Color(255, 51, 51));
	        pizzaTopSelectLabel.setText("selectFile");
	        pizzaTopSelectLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 153, 153), new java.awt.Color(51, 255, 51)));

	        logFileName.setText("logAFile");

	        browseButton.setActionCommand("button1\n");
	        browseButton.setBackground(new java.awt.Color(255, 0, 0));
	        browseButton.setForeground(new java.awt.Color(255, 204, 51));
	        browseButton.setLabel("Browse");
	        browseButton.setName(""); // NOI18N
	        browseButton.addActionListener(new java.awt.event.ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		// TODO Auto-generated method stub
	        		  JFileChooser Logfile = new JFileChooser();
	        	        logFile.showOpenDialog(null);
	        	        File f = logFile.getSelectedFile();
	        	        String filename = f.getAbsolutePath();
	        	        logFileName.setText(filename);
	        	}
	           /* public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	browseButtonActionPerformed(evt);
	            }*/
	        });

	        
	        displayButton.setBackground(new java.awt.Color(255, 72, 207));
	        displayButton.setForeground(new java.awt.Color(255, 204, 51));
	        displayButton.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
	        displayButton.setLabel("displayInformation");

	        clearButton.setBackground(new java.awt.Color(255, 51, 51));
	        clearButton.setForeground(new java.awt.Color(255, 204, 51));
	        clearButton.setText("clearInformation");
	        
	        
	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(pizzaTopPanel);
	        pizzaTopPanel.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGap(25, 25, 25)
	                .addComponent(pizzaTopSelectLabel)
	                .addGap(40, 40, 40)
	                .addComponent(logFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(37, 37, 37)
	                .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(52, 52, 52)
	                .addComponent(displayButton)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(clearButton)
	                .addContainerGap())
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(pizzaTopSelectLabel)
	                    .addComponent(logFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(displayButton)
	                        .addComponent(clearButton)))
	                .addGap(0, 16, Short.MAX_VALUE))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(pizzaTopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(pizzaTopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(384, Short.MAX_VALUE))
	        );
	        pack();
		
		/*pizzaTopPanel = new javax.swing.JPanel();
		pizzaTopSelectLabel = new javax.swing.JLabel();
		logFile = new javax.swing.JFileChooser();
		InitialiseGUI();
        
        
        
        pizzaTopPanel.setBackground(new java.awt.Color(204, 204, 255));
        pizzaTopPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pizza Order System", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, new java.awt.Font("Footlight MT Light", 0, 12), javax.swing.UIManager.getDefaults().getColor("CheckBox.select")));
        //pizzaTopPanel.setBackground(new java.awt.Color(153, 255, 153));
        //pizzaTopPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "pizzaOrderItem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(61, 181, 216))); // NOI18N

        pizzaTopSelectLabel.setForeground(new java.awt.Color(255, 51, 51));
        pizzaTopSelectLabel.setText("selectFile");
        pizzaTopSelectLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 153, 153), new java.awt.Color(51, 255, 51)));
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(pizzaTopPanel);
        pizzaTopPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(pizzaTopSelectLabel)
                    .addContainerGap(390, Short.MAX_VALUE))
            //.addGap(0, 460, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(pizzaTopSelectLabel)
                    .addGap(0, 84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pizzaTopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pizzaTopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        pack();
        
	/*	this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());*/
		
		
	/*	btnPanel = createPanel(Color.GRAY);
		this.getContentPane().add(btnPanel,BorderLayout.SOUTH);
		
		loadLogFileBTN = createButton("Load Log File");
		
		layoutButtonPanel();*/
	
		this.setVisible(true);
	}
	
	/*private JButton createButton(String btnText){
		JButton btn = new JButton();
		btn.setText(btnText);
		btn.addActionListener(this);
		return btn;
	}
	
	private JPanel createPanel(Color c) {
		JPanel panel = new JPanel();
		panel.setBackground(c);
		return panel;
	} 
	
	private void layoutButtonPanel() {
		GridBagLayout layout = new GridBagLayout();
		btnPanel.setLayout(layout);
		//Lots of layout code here
		//add components to grid
		GridBagConstraints constraints = new GridBagConstraints();
		//Defaults
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 100;
		constraints.weighty = 100;
		
		addToPanel(btnPanel, loadLogFileBTN,constraints,0,0,2,1);
	} */
	
	/**
	*
	* A convenience method to add a component to given grid bag
	* layout locations. Code due to Cay Horstmann
	*
	* @param c the component to add
	* @param constraints the grid bag constraints to use
	* @param x the x grid position
	* @param y the y grid position
	* @param w the grid width of the component
	* @param h the grid height of the component
	*/
/*	private void addToPanel(JPanel jp,Component c, GridBagConstraints
	constraints,int x, int y, int w, int h) {
	constraints.gridx = x;
	constraints.gridy = y;
	constraints.gridwidth = w;
	constraints.gridheight = h;
	jp.add(c, constraints);
	}*/
	
	/**
	 * @param args
	 */
	
	public void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        JFileChooser Logfile = new JFileChooser();
        logFile.showOpenDialog(null);
        File f = logFile.getSelectedFile();
        String filename = f.getAbsolutePath();
        logFileName.setText(filename);
        
        
    } 

	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		  JFileChooser Logfile = new JFileChooser();
	        logFile.showOpenDialog(null);
	        File f = logFile.getSelectedFile();
	        String filename = f.getAbsolutePath();
	        logFileName.setText(filename);
	}
	
	@Override
	public void run() {
		// TO DO
		createGUI();
		 JFrame.setDefaultLookAndFeelDecorated(true);
	      SwingUtilities.invokeLater(new PizzaGUI("CHENXIGUO & Hoseob Jeon"));
	}

	

}