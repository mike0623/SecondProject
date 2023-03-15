package tw.eeit162.gameplat.model.javabean;

import java.io.Serializable;

public class ScoreBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int scoreID;
	private int score;
	private String createDate;
	private int f_userID;
	private int f_gameID;
	
	
	
	public ScoreBean(int scoreID, int score, int f_userID, int f_gameID) {
		this.scoreID = scoreID;
		this.score = score;
		this.f_userID = f_userID;
		this.f_gameID = f_gameID;
	}
	
	public ScoreBean(int score, int f_userID, int f_gameID) {
		this.score = score;
		this.f_userID = f_userID;
		this.f_gameID = f_gameID;
	}
	

	public ScoreBean(int scoreID, int score, String createDate, int f_userID, int f_gameID) {
		super();
		this.scoreID = scoreID;
		this.score = score;
		this.createDate = createDate;
		this.f_userID = f_userID;
		this.f_gameID = f_gameID;
	}

	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getScoreID() {
		return scoreID;
	}
	public void setScoreID(int scoreID) {
		this.scoreID = scoreID;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getF_userID() {
		return f_userID;
	}
	public void setF_userID(int f_userID) {
		this.f_userID = f_userID;
	}
	public int getF_gameID() {
		return f_gameID;
	}
	public void setF_gameID(int f_gameID) {
		this.f_gameID = f_gameID;
	}
	

}
