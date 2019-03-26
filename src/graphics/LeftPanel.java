package graphics;

import javax.swing.JPanel;

import controller.SnakeController;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class LeftPanel extends JPanel {
	
	private final SnakeController MANAGER = SnakeController.getInstance();
	private JTextArea console;

	/**
	 * Create the panel.
	 * @return 
	 */
	
	public LeftPanel() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 372, 35);
		add(menuBar);
		
		JMenu mnProgram = new JMenu("Program");
		menuBar.add(mnProgram);
		
		JMenuItem mntmMenu = new JMenuItem("MENU");
		mntmMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPanel menuPanel = new MenuPanel();
				MANAGER.getFrame().getMainPanel().changeRightPanel(menuPanel);
			}
		});
		mnProgram.add(mntmMenu);
		
		JMenuItem mntmLogout = new JMenuItem("LOGOUT");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPanel loginPanel = new LoginPanel();
				MANAGER.getFrame().getMainPanel().changeRightPanel(loginPanel);
			}
		});
		mnProgram.add(mntmLogout);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnProgram.add(mntmExit);
		
		console = new JTextArea();
		console.setBackground(Color.LIGHT_GRAY);
		console.setBounds(6, 47, 354, 509);
		add(console);
		console.setEditable(false);
		console.setText("CONSOLE:");

	}

	public JTextArea getConsole() {
		return console;
	}

	public void setConsole(JTextArea console) {
		this.console = console;
	}
	
	public void writeInConsole(String event) {
		StringBuilder cadena = new StringBuilder();
		cadena.append(console.getText());
		cadena.append("\n");
		cadena.append(event);
		console.setText(String.valueOf(cadena));
	}
	

}
