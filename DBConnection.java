package cnt4714_project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	boolean flag = false;
	private String databaseURL;
	private String username;
	private String password;
	private Connection connection;

	
	public DBConnection(String URL, String username, String password) {
		this.databaseURL = URL;
		this.username = username;
		this.password = password;
	}

	public void establishConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection = DriverManager.getConnection(this.databaseURL, this.username, this.password);
		flag = true;
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public void disconnect() throws SQLException {
		if (flag) {
			try {                                    
		       connection.close();                       
		    }                                 
		    catch (SQLException e) {                                            
		         e.printStackTrace();           
		    }                             
			flag = false;                              
		}      
		return;
	}
}
