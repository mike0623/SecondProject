package tw.eeit162.gameplat.model.javabean;

import java.io.Serializable;

public class BoardgameBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int gameID;
	private String gameName;
	private String creater;
	private String createdDate;
	private String degreeOfDifficulty;
	private String spendTime;
	
	
	
	
	public BoardgameBean(int gameID, String gameName, String creater, String createdDate, String degreeOfDifficulty,
			String spendTime) {
		this.gameID = gameID;
		this.gameName = gameName;
		this.creater = creater;
		this.createdDate = createdDate;
		this.degreeOfDifficulty = degreeOfDifficulty;
		this.spendTime = spendTime;
	}
	
	public BoardgameBean(String gameName, String creater, String createdDate, String degreeOfDifficulty,
			String spendTime) {
		super();
		this.gameName = gameName;
		this.creater = creater;
		this.createdDate = createdDate;
		this.degreeOfDifficulty = degreeOfDifficulty;
		this.spendTime = spendTime;
	}

	
	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getDegreeOfDifficulty() {
		return degreeOfDifficulty;
	}
	public void setDegreeOfDifficulty(String degreeOfDifficulty) {
		this.degreeOfDifficulty = degreeOfDifficulty;
	}
	public String getSpendTime() {
		return spendTime;
	}
	public void setSpendTime(String spendTime) {
		this.spendTime = spendTime;
	}
	
	

}
