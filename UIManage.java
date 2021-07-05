package cnt4714_project2;

import javax.swing.*;
import javax.swing.UIManager.*;

public class UIManage extends JFrame{
	
	public UIManage() 
	{
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		    // handle exception
			e.printStackTrace();
		} catch (InstantiationException e) {
		    // handle exception
			e.printStackTrace();
		} catch (IllegalAccessException e) {
		    // handle exception
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
