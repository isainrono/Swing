package graphics;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTable;

import model.Snake;
import model.User;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.SnakeController;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends JPanel {
	
	private final int B_WIDTH = 525;
    private final int B_HEIGHT = 525;
    private JTable table;
    
    public Object[][] data = {
		    {"Kathy", "30"},
		    {"John", "40"},
		    {"Sue", "60"},
		    {"Jane", "80"},
		    {"Joe", "90"},
		    {"Kathy", "30"},
		    {"John", "40"},
		    {"Sue", "60"},
		    {"Jane", "80"},
		    {"Joe", "90"},
		    {"Kathy", "30"},
		    {"John", "40"},
		    {"Sue", "60"},
		    {"Jane", "80"},
		    {"Joe", "90"},
		    {"Kathy", "30"},
		    {"John", "40"},
		    {"Sue", "60"},
		    {"Jane", "80"},
		    {"Joe", "90"}
		    
		};
    public String[] columNames = {"DATE", "SCORE"};

	/**
	 * Create the panel.
	 */
	public MenuPanel() {
		setLayout(null);
		
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel snake = new Snake();
				
				SnakeController.getInstance().getFrame().getMainPanel().changeRightPanel(snake);
			}
		});
		
		
		btnNewButton.setBounds(26, 430, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Scores");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel scorePanel = new ScoresPanel();
				SnakeController.getInstance().getFrame().getMainPanel().changeRightPanel(scorePanel);
			}
		});
		btnNewButton_1.setBounds(205, 430, 117, 29);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBounds(371, 430, 117, 29);
		add(btnNewButton_2);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 151, 389, 248);
		add(scrollPane);
		
		
		table = new JTable(data, columNames);
		scrollPane.setViewportView(table);
		
		JLabel lblYourBestPlays = new JLabel("Your Best Plays");
		lblYourBestPlays.setBounds(67, 123, 138, 16);
		add(lblYourBestPlays);

	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public String[] getColumNames() {
		return columNames;
	}

	public void setColumNames(String[] columNames) {
		this.columNames = columNames;
	}
}
