package controller;

import java.awt.EventQueue;
import java.util.ArrayList;

import graphics.MainPanel;
import graphics.MainView;
import model.User;

public class SnakeController {
	
	private static SnakeController manager;
	
	private MainView frame;
	private User user;
	
	
	private SnakeController() {
		user = new User();
		this.initGame();
	}
	
	public static SnakeController getInstance() {
		if(manager == null) {
			manager = new SnakeController();
		}
		return manager;
	}
	
	
	public void initGame() {
		System.out.println(this.user.getScoreList().size());
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					frame = new MainView();
					frame.setVisible(true);
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
		return this.user.getUserList();
	}

	
	public User getUserAtPositionList(int position) {
		return this.user.getUserList().get(position);
	}

	public User getUser() {
		return user;
	}

	
	
}
