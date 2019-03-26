package graphics;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTable;

import model.Score;
import model.Snake;
import model.User;
import snakeGame.Game;
import utilities.Utilities;

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
    private final SnakeController MANAGER = SnakeController.getInstance();
    private JTable table;
    
    public Object[][] history;
    /*public Object[][] data = {
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
		    
		};*/
    public String[] columNames = {"DATE", "SCORE"};

	/**
	 * Create the panel.
	 */
	public MenuPanel() {
		
		fillScoreGame();
		history = new Object[MANAGER.getGameScore().size()][2];
		
		int fechas = 0;
		
		System.out.println(MANAGER.getGameScore().size());
		for (int i = 0; i < MANAGER.getGameScore().size(); i++) {
			history[i][0] = MANAGER.getGameScore().get(i).getDate();
			history[i][1] = MANAGER.getGameScore().get(i).getScore();
			 
		}
		
		
		/*for (int i = 0; i < history.length; i++) {
			for (int j = 0; j < history[i].length; j++) {
				System.out.print(history[i][j] + " ");
			}
			System.out.println(" ");
		}*/
		
		
		setLayout(null);
		
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SnakeController.getInstance().getFrame().getMainPanel().getLeftPanel().writeInConsole("ENTRAMOS A MODO JUEGO...");
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
				SnakeController.getInstance().getFrame().getMainPanel().getLeftPanel().writeInConsole("ENTRAMOS EN VENTANA SCORES");
				JPanel scorePanel = new ScoresPanel();
				SnakeController.getInstance().getFrame().getMainPanel().changeRightPanel(scorePanel);
			}
		});
		btnNewButton_1.setBounds(205, 430, 117, 29);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SnakeController.getInstance().getFrame().getMainPanel().getLeftPanel().writeInConsole("SE VA A SALIR DEL JUEGO");
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(371, 430, 117, 29);
		add(btnNewButton_2);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 151, 389, 248);
		add(scrollPane);
		
		
		table = new JTable(history, columNames);
		scrollPane.setViewportView(table);
		
		JLabel lblYourBestPlays = new JLabel("Your Best Plays");
		lblYourBestPlays.setBounds(67, 123, 138, 16);
		add(lblYourBestPlays);

	}
	

	public Object[][] getHistory() {
		return history;
	}

	public void setHistory(Object[][] history) {
		this.history = history;
	}


	public String[] getColumNames() {
		return columNames;
	}

	public void setColumNames(String[] columNames) {
		this.columNames = columNames;
	}
	
	public void fillScoreGame() {
		SnakeController.getInstance().setGameScore(SnakeController.getInstance().getUserLogged().getScoreList());
	}
}
