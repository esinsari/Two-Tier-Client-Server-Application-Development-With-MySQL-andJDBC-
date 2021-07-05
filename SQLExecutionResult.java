package cnt4714_project2;

import java.awt.*;
import javax.swing.*;

public class SQLExecutionResult extends JPanel {

	private JTable table;
	private JScrollPane scroll;
	private GridBagLayout resultLayout;

	public SQLExecutionResult()
	{
		resultLayout = new GridBagLayout();
		this.setLayout(resultLayout);	
		this.setBorder(BorderFactory.createTitledBorder("SQL Execution Result Window"));			
	}
	
	/*SET METHODS*/
	public void setSQLResult(JTable model)
	{   
		table = model;
		table.setRowHeight(24);
		table.setAutoCreateRowSorter(true);
   
		scroll = new JScrollPane(table);
	    this.add(scroll);
	}
}
