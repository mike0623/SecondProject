package tw.eeit162.gameplat.model.javabean;

import java.io.Serializable;

public class ScoreBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int scoreID;
	private int score;
	private String createdDate;
	private UsersBean f_userID;
	private BoardgameBean f_gameID;
	
	
	
	public ScoreBean() {
	}

	public ScoreBean(int scoreID, int score, UsersBean f_userID, BoardgameBean f_gameID) {
		this.scoreID = scoreID;
		this.score = score;
		this.f_userID = f_userID;
		this.f_gameID = f_gameID;
	}
	
	public ScoreBean(int score, UsersBean f_userID, BoardgameBean f_gameID) {
		this.score = score;
		this.f_userID = f_userID;
		this.f_gameID = f_gameID;
	}
	

	public ScoreBean(int scoreID, int score, String createDate, UsersBean f_userID, BoardgameBean f_gameID) {
		super();
		this.scoreID = scoreID;
		this.score = score;
		this.createdDate = createDate;
		this.f_userID = f_userID;
		this.f_gameID = f_gameID;
	}

	
	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public int getScoreID() {
		return scoreID;
	}

	public void setScoreID(int scoreID) {
		this.scoreID = scoreID;
	}

	public UsersBean getF_userID() {
		return f_userID;
	}

	public void setF_userID(UsersBean f_userID) {
		this.f_userID = f_userID;
	}

	public BoardgameBean getF_gameID() {
		return f_gameID;
	}

	public void setF_gameID(BoardgameBean f_gameID) {
		this.f_gameID = f_gameID;
	}
	
	
	

}
