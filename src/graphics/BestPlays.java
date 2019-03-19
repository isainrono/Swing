package graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JList;

public class BestPlays extends JPanel {

	/**
	 * Create the panel.
	 */
	public BestPlays() {
		setLayout(null);
		
		JButton newGame = new JButton("New Game");
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		newGame.setBounds(30, 240, 117, 29);
		add(newGame);
		
		JButton scores = new JButton("Scores");
		scores.setBounds(187, 240, 117, 29);
		add(scores);
		
		JButton exit = new JButton("Exit");
		exit.setBounds(316, 240, 117, 29);
		add(exit);
		
		JList list = new JList();
		list.setBounds(41, 28, 373, 193);
		add(list);

	}
}
