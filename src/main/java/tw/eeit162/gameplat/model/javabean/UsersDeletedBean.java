package tw.eeit162.gameplat.model.javabean;

import java.io.Serializable;

public class UsersDeletedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int deletedUserID;
	private String userAccount;
	private String userPwd;
	private String userName;
	private String gender;
	private String birthday;
	private String deleteDate;
	private String userPhoto;
	private String deleter;
	
	
	
	public UsersDeletedBean() {
	}
	
	
	public UsersDeletedBean(String userAccount, String userPwd, String userName, String gender, String birthday,
			String userPhoto) {
		this.userAccount = userAccount;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.birthday = birthday;
		this.userPhoto = userPhoto;
	}


	public UsersDeletedBean(String userAccount, String userPwd, String userName, String gender, String birthday,
			String deleteDate, String userPhoto, String deleter) {
		this.userAccount = userAccount;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.birthday = birthday;
		this.deleteDate = deleteDate;
		this.userPhoto = userPhoto;
		this.deleter = deleter;
	}


	public int getDeletedUserID() {
		return deletedUserID;
	}
	public void setDeletedUserID(int deletedUserID) {
		this.deletedUserID = deletedUserID;
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
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getDeleter() {
		return deleter;
	}
	public void setDeleter(String deleter) {
		this.deleter = deleter;
	}
	
	
	

}
