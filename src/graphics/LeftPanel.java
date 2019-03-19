package graphics;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LeftPanel extends JPanel {

	/**
	 * Create the panel.
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
		mnProgram.add(mntmMenu);
		
		JMenuItem mntmLogout = new JMenuItem("LOGOUT");
		mnProgram.add(mntmLogout);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mnProgram.add(mntmExit);

	}
}
