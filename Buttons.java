package cnt4714_project2;

import javax.swing.*;

public class Buttons extends JPanel{

	private JButton connect;
	private JButton execute;
	private JButton clear;
	private JButton clearResult;
	
	public JTextField connectionStatus;
	
	public Buttons() {

		connectionStatus = new JTextField(60);
		connectionStatus.setText("No Connection Now");	
		connectionStatus.setEditable(false);		
		this.add(connectionStatus);
		
		connect = new JButton("Connect to Database");
		this.add(connect);
		
		execute = new JButton("Execute SQL Command");
		this.add(execute);
		
		clear = new JButton("Clear SQL Command");	
		this.add(clear);

		clearResult = new JButton("Clear Result Window");	
	}

	/*GET METHODS*/
	
	public JTextField getConnectionStatus() 
	{
		return connectionStatus;
	}

	public String getConnectButton() 
	{
		return "Connect to Database";
	}

	public String getExecuteButton() 
	{
		return "Execute SQL Command";
	}
	
	public String getClearButton() 
	{
		return "Clear SQL Command";
	}
	

	public JButton getConnect() {
		return connect;
	}

	public JButton getExecute() {
		return execute;
	}
		
	public JButton getClear() {
		return clear;
	}
	
	public String getClearResultButton() 
	{
		return "Clear Result Window";
	}
	
	public JButton getClearResult() {
		return clearResult;
	}
	
	/*SET METHODS*/
	public void setConnectionStatus(JTextField connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
		
	public void setClearResult() {
		clearResult.setVisible(true);
		this.add(clearResult);
	}
	
}
