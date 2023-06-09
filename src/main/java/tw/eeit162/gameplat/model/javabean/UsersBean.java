package tw.eeit162.gameplat.model.javabean;

import java.io.Serializable;

public class UsersBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userID;
	private String userAccount;
	private String userPwd;
	private String userName;
	private String gender;
	private String birthday;
	private String createDate;
	private String userPhoto;
	
	
	
	
	public UsersBean() {

	}
	
	
	public UsersBean(int userID, String userAccount, String userPwd, String userName, String gender, String birthday,
			String createDate, String userPhoto) {
		this.userID = userID;
		this.userAccount = userAccount;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.birthday = birthday;
		this.createDate = createDate;
		this.userPhoto = userPhoto;
	}





	public UsersBean(String userAccount, String userPwd, String userName, String gender, String birthday) {
		this.userAccount = userAccount;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.birthday = birthday;
	}
	

	public UsersBean(int userID, String userAccount, String userPwd, String userName, String gender, String birthday) {
		this.userID = userID;
		this.userAccount = userAccount;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.birthday = birthday;
	}
	
	


	public UsersBean(int userID, String userAccount, String userPwd, String userName, String gender, String birthday,
			String userPhoto) {
		this.userID = userID;
		this.userAccount = userAccount;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.birthday = birthday;
		this.userPhoto = userPhoto;
	}


	
	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getUserPhoto() {
		return userPhoto;
	}


	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}


	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
	
	
	
	
	
	

}
