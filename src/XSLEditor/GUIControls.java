package XSLEditor;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.StyledDocument;


public class GUIControls {
	
	private static JFrame mainFrame;
	private static JPanel controlPanel;
	private static JMenu fileMenu;
	private static JMenu editMenu;
	private static JMenu runMenu;
	private static JMenu helpMenu;
	private static JMenuBar menuBar;
	private static JTextPane txtProgrammingConsole;
	private static JTextPane txtOutputConsole;
	//private static String[] sMenuNames = {"File","Edit","Run","Help"};
	private static JLabel headerLabel;
	private static JLabel statusLabel;
	private static JPanel programmingConsolePanel;
	private static JPanel outputConsolePanel;
	private static JToolBar toolBar;
	private static JTextArea txtPgmArea;
	private static JTextArea txtOutputArea;
	private static JPanel consolePanel;
	
	
	private static MenuItemListener menuItemListener = new MenuItemListener();
	public static void prepareGUI(){
		mainFrame = new JFrame();		
		mainFrame.setSize(400,400);
		mainFrame.setTitle("XSL Editor");
		//mainFrame.setLayout(new GridLayout(3,1));
		mainFrame.setLayout(new BorderLayout());
		headerLabel = new JLabel("",JLabel.CENTER);
		statusLabel = new JLabel("",JLabel.CENTER);
		statusLabel.setSize(350,100);
		mainFrame.add(headerLabel);
		//
		mainFrame.add(statusLabel);		
		mainFrame.setVisible(true);
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}			
		});
		showMenu();
		mainFrame.add(CreateConsolePanel());
		//mainFrame.add(CreatePgmConsolePanel());		
		//mainFrame.add(CreateOutputConsolePanel());
		//mainFrame.add(CreateToolBar());
	
		mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void showMenu(){
		mainFrame.setJMenuBar(CreateMenuBar());
	}
	
	/*
	private static JPanel CreateControlPanel(){
		controlPanel = new JPanel();
		controlPanel.setLayout(new BorderLayout());
		return controlPanel;		
	}
	*/
	private static JMenu  CreateFileMenu(){
		//String[] sFileMenuItems = {"New","Open","Close","Quit"};
		fileMenu = new JMenu("File");
	
		try{
			JMenuItem newMenuItem = new JMenuItem("New");
			newMenuItem.setMnemonic(KeyEvent.VK_N);
			newMenuItem.setActionCommand("NEW");
			newMenuItem.addActionListener(menuItemListener);;
			
			JMenuItem openMenuItem = new JMenuItem("Open");
			openMenuItem.setActionCommand("OPEN");
			openMenuItem.addActionListener(menuItemListener);
			
			JMenuItem closeMenuItem = new JMenuItem("Close");
			closeMenuItem.setActionCommand("CLOSE");
			closeMenuItem.addActionListener(menuItemListener);
			
			JMenuItem quitMenuItem = new JMenuItem("Quit");
			quitMenuItem.setActionCommand("QUIT");
			quitMenuItem.addActionListener(menuItemListener);
			
			fileMenu.add(newMenuItem);
			fileMenu.add(openMenuItem);
			fileMenu.add(closeMenuItem);
			fileMenu.add(quitMenuItem);
		}
		catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		
		return fileMenu;
	}
	
	private static JMenu CreateEditMenu(){
		//String[] sEditMenu = {"Cut","Copy","Paste"};
		editMenu = new JMenu("Edit");
		try{
			JMenuItem cutMenuItem = new JMenuItem("Cut");
			cutMenuItem.setActionCommand("CUT");
			cutMenuItem.addActionListener(menuItemListener);
			
			JMenuItem copyMenuItem = new JMenuItem("Copy");
			copyMenuItem.setActionCommand("COPY");
			copyMenuItem.addActionListener(menuItemListener);
			
			JMenuItem pasteMenuItem = new JMenuItem("Paste");
			pasteMenuItem.setActionCommand("PASTE");
			pasteMenuItem.addActionListener(menuItemListener);
			
			editMenu.add(cutMenuItem);
			editMenu.add(copyMenuItem);
			editMenu.add(pasteMenuItem);
			
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}		
		
		return editMenu;
	}
	
	private static JMenu CreateRunMenu(){
		//String[] sRunMenu = {"Run"};
		runMenu = new JMenu("Run");
		try{
			JMenuItem runMenuItem = new JMenuItem("Run");
			runMenuItem.setActionCommand("RUN");
			runMenuItem.addActionListener(menuItemListener);
			
			runMenu.add(runMenuItem);
		}
		catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		
		return runMenu;
	}
	
	private static JMenu CreateHelpMenu(){
		//String[] sHelpMenu = {"Help Contents","About XSL Editor"};
		helpMenu = new JMenu("Help");
		try{
			JMenuItem helpContentsMenuItem = new JMenuItem("Contents");
			helpContentsMenuItem.setActionCommand("HELP_CONTENTS");
			helpContentsMenuItem.addActionListener(menuItemListener);
			
			JMenuItem aboutMenuItem = new JMenuItem("About XSL Editor");
			aboutMenuItem.setActionCommand("ABOUT_XSL_EDITOR");
			aboutMenuItem.addActionListener(menuItemListener);
			
			helpMenu.add(helpContentsMenuItem);
			helpMenu.add(aboutMenuItem);
			
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		
		return helpMenu;
	}
	
	private static JMenuBar CreateMenuBar(){
		menuBar = new JMenuBar();		
		menuBar.add(CreateFileMenu());
		menuBar.add(CreateEditMenu());
		menuBar.add(CreateRunMenu());
		menuBar.add(CreateHelpMenu());
		return menuBar;
	}
	
	private static JPanel CreatePgmConsolePanel(){
		programmingConsolePanel = new JPanel(new BorderLayout());
		programmingConsolePanel.setPreferredSize(new Dimension(200,100));
		programmingConsolePanel.setMinimumSize(new Dimension(200,100));
		programmingConsolePanel.add(CreatePgmTextArea(),BorderLayout.CENTER);
		
		//programmingConsolePanel.add(CreateOutputTextArea(),BorderLayout.CENTER);
		return programmingConsolePanel;
	}
	
	
	private static JPanel CreateOutputConsolePanel(){
		outputConsolePanel = new JPanel(new BorderLayout());
		outputConsolePanel.setPreferredSize(new Dimension(400,100));
		outputConsolePanel.setMinimumSize(new Dimension(100,50));
		
		outputConsolePanel.add(CreateOutputTextArea(),BorderLayout.CENTER);
		
		return outputConsolePanel;
	}
	
	
	private static JPanel CreateConsolePanel(){
		consolePanel = new JPanel(new BorderLayout());
		consolePanel.add(CreatePgmConsolePanel(),BorderLayout.NORTH);
		consolePanel.add(CreateOutputConsolePanel(),BorderLayout.SOUTH);
		
		return consolePanel;
	}
	private static JTextPane CreateProgrammingConsoleTextPane(){
		
		txtProgrammingConsole = new JTextPane();
		JScrollPane scrollPgmConsole = new JScrollPane(txtProgrammingConsole);
		scrollPgmConsole.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPgmConsole.setPreferredSize(new Dimension(200,100));
		scrollPgmConsole.setMinimumSize(new Dimension(60,80));
		StyledDocument doc = txtProgrammingConsole.getStyledDocument();
		
		txtProgrammingConsole.setBounds(0, 0, 600, 300);
		txtProgrammingConsole.setAutoscrolls(true);
		return txtProgrammingConsole;
	}
	
	private static JToolBar CreateToolBar(){
		toolBar = new JToolBar();
		toolBar.setPreferredSize(new Dimension(200,25));
		
		toolBar.setFloatable(false);
		toolBar.addSeparator();		
		return toolBar;
	}
	
	private static JScrollPane CreatePgmTextArea(){
		txtPgmArea = new JTextArea(6,20);
		//txtPgmArea.setSize(100, 200);
		JScrollPane jInputScroll = new JScrollPane(txtPgmArea);
		txtPgmArea.setEditable(true);
		txtPgmArea.setText("Text Area...");
		return jInputScroll;
	}
	
	
	private static JScrollPane CreateOutputTextArea(){
		txtOutputArea = new JTextArea(4,20);
		txtOutputArea.setText("Output...");
		//txtOutputArea.setSize(20, 20);
		JScrollPane jOutputScroll = new JScrollPane(txtOutputArea);
		txtOutputArea.setEditable(false);
		return jOutputScroll;
	}
}
