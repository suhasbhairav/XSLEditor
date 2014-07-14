package XSLEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItemListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String sEvent = e.getActionCommand().toUpperCase();
		switch(sEvent){
		case "NEW":
			System.out.println("New!");
			break;
		case "OPEN":
			break;
		case "CLOSE":
			break;
		case "QUIT":
			break;
		case "CUT":
			break;
		case "COPY":
			break;
		case "PASTE":
			break;
		case "RUN":
			break;
		case "HELP_CONTENTS":
			break;
		case "ABOUT_XSL_EDITOR":
			break;		
		
		}
		
		
	}

}
