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
	}
	
	
	public User(String name, String pass, ArrayList<Score> scoreList) {
		this.name = name;
		this.pass = pass;
		this.scoreList = scoreList;
		/*scoreList = new ArrayList<Score>();
		Score score1 = new Score(1, Utilities.actualTimeString());
		scoreList.add(score1);
		Score score2 = new Score(2, Utilities.actualTimeString());
		scoreList.add(score2);
		Score score3 = new Score(3, Utilities.actualTimeString());
		scoreList.add(score3);
		Score score4 = new Score(4, Utilities.actualTimeString());
		scoreList.add(score4);
		Score score5 = new Score(10, Utilities.actualTimeString());
		scoreList.add(score5);
		Score score6 = new Score(16, Utilities.actualTimeString());
		scoreList.add(score6);*/
	}
	/*
	
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
		/*scoreList = new ArrayList<Score>();
		Score score1 = new Score(1, Utilities.actualTimeString());
		scoreList.add(score1);
		Score score2 = new Score(2, Utilities.actualTimeString());
		scoreList.add(score2);
		Score score3 = new Score(3, Utilities.actualTimeString());
		scoreList.add(score3);
		Score score4 = new Score(4, Utilities.actualTimeString());
		scoreList.add(score4);
		Score score5 = new Score(10, Utilities.actualTimeString());
		scoreList.add(score5);
		Score score6 = new Score(16, Utilities.actualTimeString());
		scoreList.add(score6);
	}
	
	*/
	
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
		return name + " --> " + getBestScore() ;
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
		
		int maxScoreDay = 0, position = 0;
		
		
		if(scoreList.size() > 0) {
			for (int i = 0; i < scoreList.size(); i++) {
				if(scoreList.get(i).getScore() > maxScoreDay) {
					position = i;
				}
			}
		}
		
		
		return scoreList.get(position).getDate();
	}

	public ArrayList<Score> getScoreList() {
		/*this.scoreList = new ArrayList<Score>();
		
		Score score1 = new Score(1, Utilities.actualTimeString());
		scoreList.add(score1);
		Score score2 = new Score(2, Utilities.actualTimeString());
		scoreList.add(score2);
		Score score3 = new Score(3, Utilities.actualTimeString());
		scoreList.add(score3);
		Score score4 = new Score(4, Utilities.actualTimeString());
		scoreList.add(score4);
		Score score5 = new Score(5, Utilities.actualTimeString());
		scoreList.add(score5);*/
		if(scoreList.size() <= 0) {
			return new ArrayList<Score>();
		} else {
			return this.scoreList;
		}
		
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		this.scoreList = scoreList;
	}
	
	public void addScore(Score score) {
		this.scoreList.add(score);
	}
	
}
