/*
 * Name............: Esin Sari
 * Course..........: CNT 4714 Summer 2021
 * Assignment title: Project 2 – Two-Tier Client-Server Application Development With MySQL andJDBC
 * Date............: July 4, 2021
 * Class...........: Enterprise Computing
*/

package cnt4714_project2;

import java.awt.*;
import javax.swing.*;

public class Main extends JPanel {
	
	SQLCommand sql;	
	DatabaseInfo db;
	Buttons buttons;
	SQLExecutionResult result;
	
	public static void main(String[] args) 
	{
		ClientApp app = new ClientApp();

		app.setVisible(true);
	}
	
	public Main() {
		
		db = new DatabaseInfo();
		this.add(db);
		
		sql = new SQLCommand();
		this.add(sql);
		
		buttons = new Buttons();
		this.add(buttons);
		
		result = new SQLExecutionResult();
		result.setVisible(false);
		this.add(result);
    }
}
