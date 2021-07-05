package cnt4714_project2;

import java.awt.*;
import javax.swing.*;

public class DatabaseInfo extends JPanel{
	
	private JLabel JDBCDriver; 
	private JLabel databaseURL;
	private JLabel username;
	private JLabel password;
	
	private JComboBox<String> driver;
	private JComboBox<String> dbURL;
	
	private GridLayout loginLayout;
	
	Dimension field = new Dimension(100, 30);
	Dimension label = new Dimension(100, 30);
	
	JTextField userField = new JTextField(25);
	JTextField passField = new JTextField(25);
	
	JPasswordField passwordField = new JPasswordField(25);
	
	
	public DatabaseInfo()
	{
		JDBCDriver = new JLabel("JDBC Driver:");
		JDBCDriver.setPreferredSize(label);
		
		driver = new JComboBox<String>();
		driver.addItem("com.mysql.cj.jdbc.Driver");
		driver.addItem("com.mysql.jdbc.Driver");
		driver.addItem("oracle.jdbc.driverOracleDriver");
		driver.addItem("com.jbm.db2.jdbc.netDB2Driver");
		driver.addItem("com.jdbc.odbc.jdbcOdbcDriver");
		driver.setPreferredSize(field);
		
		this.add(JDBCDriver);
		this.add(driver);
		
		/****DATABASE URL****/
		databaseURL = new JLabel("Database URL:");
		databaseURL.setPreferredSize(label);
		
		dbURL = new JComboBox<String>();
		dbURL.addItem("jdbc:mysql://localhost:3306/project2");
		dbURL.setPreferredSize(field);
		
		this.add(databaseURL);
		this.add(dbURL);
		
		
		/****USERNAME****/
		username = new JLabel("Username: ");
		this.add(username);
		this.add(userField);
		
		
		/****PASSWORD****/
		password = new JLabel("Password: ");
		password.setLabelFor(passwordField);
		this.add(password);
		this.add(passField);
		
		
		loginLayout = new GridLayout(4, 2);
		this.setLayout(loginLayout);
		
		this.setBorder(BorderFactory.createTitledBorder("Enter Database Information"));	
		
	}

	/*GET METHODS*/
	public static String getJDBCDriver() 
	{
		return "com.mysql.jdbc.Driver";
	}
	
	public String getDatabaseURL() 
	{
		return "jdbc:mysql://localhost:3306/project2";
	}
	
	public String getUsername() 
	{
		return userField.getText();
	}
	
	public String getPassword() 
	{
		return passField.getText();
	}
}
