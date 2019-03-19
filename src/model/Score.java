package model;

public class Score {
	private int score;
	private String date;
	
	public Score(int score, String date){
		this.score = score;
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
