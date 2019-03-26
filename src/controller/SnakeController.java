package controller;

import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import graphics.MainPanel;
import graphics.MainView;
import model.Score;
import model.User;
import utilities.Utilities;

public class SnakeController {
	
	private static SnakeController manager;
	
	private MainView frame;
	private User user;
	private XMLController xmlController;
	private ArrayList<Score> gameScore;
	private User userLogged;
	
	
	private SnakeController() {
		userLogged = new User();
		user = new User();
		xmlController = new XMLController();
		gameScore = new ArrayList<Score>();
		this.initGame();
	}
	
	public static SnakeController getInstance() {
		if(manager == null) {
			manager = new SnakeController();
		}
		return manager;
	}
	
	
	public void initGame() {
	
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					frame = new MainView();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainView getFrame() {
		return frame;
	}

	public void setFrame(MainView frame) {
		this.frame = frame;
	}

	public ArrayList<User> getUserList() {
		return this.xmlController.getUserList();
	}

	
	public User getUserAtPositionList(int position) {
		return this.xmlController.getUserList().get(position);
	}
	
	public User getFindUser(String name) {
		
		for (User user : this.xmlController.getUserList()) {
			if(user.getName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		
		return null;
	}

	public XMLController getXmlController() {
		return xmlController;
	}
	
	public User getBestScoreGame() {
		int bestScore = 0, position = 0;
		
		for (int i = 0; i < this.xmlController.getUserList().size(); i++) {
			if(this.xmlController.getUserList().get(i).getBestScore() > 0) {
				bestScore = this.xmlController.getUserList().get(i).getBestScore();
				position = i;
			}
		}
			
		return this.xmlController.getUserList().get(position);
	}
	
	public ArrayList<User> getUserWithScore(int tscore) {
		ArrayList<User> userScoreList = new ArrayList<User>();
		
		for (User user2 : this.xmlController.getUserList()) {
			for (Score score : user2.getScoreList()) {
				if(score.getScore() >= tscore) {
					userScoreList.add(user2);
				}
			}
		}
		
		return userScoreList;
	}

	public void setXmlController(XMLController xmlController) {
		this.xmlController = xmlController;
	}

	public User getUser() {
		return user;
	}
	
	public User getUserLogged() {
		return userLogged;
	}

	public void setUserLogged(User userLogged) {
		this.userLogged = userLogged;
	}

	public void windowClosing(WindowEvent e) {
	     System.exit(0);
	}
	
	public void saveScore(int totalScore) {
		this.gameScore.add(new Score(totalScore, utilities.Utilities.actualTimeString()));
		ReadXMLDemo write = new ReadXMLDemo();
		write.writeInScores(SnakeController.getInstance().userLogged.getName(), Utilities.actualTimeString(), String.valueOf(totalScore));
	}

	public ArrayList<Score> getGameScore() {
		return gameScore;
	}

	public void setGameScore(ArrayList<Score> gameScore) {
		this.gameScore = gameScore;
	}
	
	
	
}
