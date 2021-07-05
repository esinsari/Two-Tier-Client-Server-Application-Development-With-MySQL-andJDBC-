package cnt4714_project2;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class ClientApp extends UIManage {
	
	int flag = 0;
	public Main main;
	public JTable sqlResult;
	public GridBagLayout gbl;
	private static RunQuery run;
	private static DBConnection connection = null;
	Commands commands = new Commands(this);

	public ClientApp()
	{
		main = new Main();
		sqlResult = new JTable();
		gbl = new GridBagLayout();
		
		main.buttons.getConnect().addActionListener(commands);
		main.buttons.getExecute().addActionListener(commands);
		main.buttons.getClear().addActionListener(commands);
		main.buttons.getClearResult().addActionListener(commands);
		
		this.setLayout(gbl);
		this.setPreferredSize(new Dimension(1300,300));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Project 2 - SQL Client App - (MJL - CNT4714 - Summer 2021)");
		this.getContentPane().add(main, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0, 0, 0, 0),0,0));

		pack();
	}
	
	class Commands implements ActionListener {
		
		ClientApp frame;
		
		public Commands(ClientApp frame) 
		{
			this.frame = frame;
		}
		
		public void actionPerformed(ActionEvent ae)
		{
			/*CONNECT BUTTON*/
			if(ae.getActionCommand().equalsIgnoreCase(main.buttons.getConnectButton()))
			{
				
				connection = new DBConnection(main.db.getDatabaseURL(), main.db.getUsername(), main.db.getPassword());
					
				try {
					connection.establishConnection();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(frame, "Please Enter A Valid Username & Password", "Error",  JOptionPane.ERROR_MESSAGE);
				}
				
				if(connection.getConnection() != null) {
					main.buttons.connectionStatus.setText("Connected to " + main.db.getDatabaseURL());
					main.db.userField.setEditable(false);
					main.db.passField.setEditable(false);
					main.sql.setEditable();
				}
			}
			/*EXECUTE BUTTON*/
			if(ae.getActionCommand().equalsIgnoreCase(main.buttons.getExecuteButton()))
			{
				flag++;
				String query = main.sql.getSQLCommand();
				
				run = new RunQuery(connection.getConnection());
				
				Vector<String> columns = new Vector<String>();
				Vector<Vector<String>> results = new Vector<Vector<String>>();
				
				if(query.toLowerCase().startsWith("select")) 
				{
					try {
						results = run.runQuery(query);
						columns = run.getColumns();
						
						System.out.println(results);
						
						sqlResult.setModel(new DefaultTableModel(results, columns));
						main.result.setSQLResult(sqlResult);
						main.result.setVisible(true);
					
						if(flag == 1) 
							main.buttons.setClearResult();
						
						frame.setPreferredSize(new Dimension(1300, 500));
						frame.pack();
						
					} 
					catch (SQLException e) {
						JOptionPane.showMessageDialog(frame, e.getMessage(), "Error",  JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					try {
						run.update(query);
						sqlResult.setModel(new DefaultTableModel(new String[][]{new String[]{"Row Updated!"}},new String[]{""}));
						main.result.setSQLResult(sqlResult);
					} 
					catch (SQLException e){
						JOptionPane.showMessageDialog(frame, e.getMessage(), "Error",  JOptionPane.ERROR_MESSAGE);
					}
				}
			} 
			
			/*CLEAR BUTTON*/
			if(ae.getActionCommand().equalsIgnoreCase(main.buttons.getClearButton()))
			{
				main.sql.setSQLCommand();
			}
			
			/*CLEAR RESULT BUTTON*/
			if(ae.getActionCommand().equalsIgnoreCase(main.buttons.getClearResultButton()))
			{
				sqlResult.setModel(new DefaultTableModel(new String[][]{new String[]{""}},new String[]{""}));
				main.result.setSQLResult(sqlResult);
			}
			
		}
	}
}
