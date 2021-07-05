package cnt4714_project2;

import java.awt.*;
import javax.swing.*;

public class SQLCommand extends JPanel{

	private JTextArea command;
	private GridBagLayout commandLayout;
	
	public SQLCommand()
	{
		commandLayout = new GridBagLayout();
		this.setLayout(commandLayout);	
		this.setBorder(BorderFactory.createTitledBorder("Enter An SQL Command"));
	
		command = new JTextArea(7, 45);
		command.setLineWrap(true);
		command.setEditable(false);
		this.add(command);
	}
	
	/*GET METHODS*/
	public String getSQLCommand()
	{
		return command.getText();
	}
	
	/*SET METHODS*/
	public void setSQLCommand()
	{
		command.setText(null);
	}
	
	public void setEditable()
	{
		command.setEditable(true);
	}

	
}
