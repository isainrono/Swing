package model;

import java.util.ArrayList;
import java.util.Arrays;

import utilities.Utilities;

public class User {
	
	private String name;
	private String pass;
	private int[] scores = {1,3,5,7,10,12};
	private ArrayList<Score> scoreList;
	
	public User() {
		this.scoreList = new ArrayList<Score>();
		Score score1 = new Score(1, Utilities.actualTimeString());
		scoreList.add(score1);
		Score score2 = new Score(2, Utilities.actualTimeString());
		scoreList.add(score2);
		Score score3 = new Score(3, Utilities.actualTimeString());
		scoreList.add(score3);
		Score score4 = new Score(4, Utilities.actualTimeString());
		scoreList.add(score4);
		Score score5 = new Score(5, Utilities.actualTimeString());
		scoreList.add(score5);
	}
	
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}
	

	@Override
	public String toString() {
		return name;
	}
	
	public ArrayList<User> getUserList(){
		ArrayList <User> userList = new ArrayList<>();
		
		User isain = new User("isain", "1234");
		userList.add(isain);
		User camilo = new User("camilo", "1234");
		userList.add(camilo);
		User david = new User("david", "1234");
		userList.add(david);
		User angelly = new User("angelly", "1234");
		userList.add(angelly);
		User isain1 = new User("isain", "1234");
		userList.add(isain1);
		User camilo1 = new User("camilo", "1234");
		userList.add(camilo1);
		User david1 = new User("david", "1234");
		userList.add(david);
		User angelly1 = new User("angelly", "1234");
		userList.add(angelly1);
		User isain2 = new User("isain", "1234");
		userList.add(isain2);
		User camilo2 = new User("camilo", "1234");
		userList.add(camilo2);
		User david2 = new User("david", "1234");
		userList.add(david2);
		User angelly2 = new User("angelly", "1234");
		userList.add(angelly2);
		
		return userList;
	}
	
	public int getBestScore() {
		int maxScore = 0;
		
		if(this.scoreList.size() > 0) {
			for (int i = 0; i < scoreList.size(); i++) {
				if(scoreList.get(i).getScore() > maxScore) {
					maxScore = scoreList.get(i).getScore();
				}
			}
		}
		
		return maxScore;
	}
	
	public String getBestScoreDate() {
		int maxScore = 0;
		
		if(scoreList.size() > 0) {
			for (int i = 0; i < scoreList.size(); i++) {
				if(scoreList.get(i).getScore() > maxScore) {
					return scoreList.get(i).getDate();
				}
			}
		}
		
		
		return Utilities.actualTimeString();
	}

	public ArrayList<Score> getScoreList() {	
		return scoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}
	
	public void addScore(Score score) {
		this.scoreList.add(score);
	}
	
}
