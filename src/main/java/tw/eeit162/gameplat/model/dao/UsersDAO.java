package tw.eeit162.gameplat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tw.eeit162.gameplat.model.javabean.UsersBean;

public class UsersDAO {
	private Connection conn;
	
	public UsersDAO(Connection conn) {
		this.conn=conn;
	}
	
	public UsersBean selectUserByAccount(String account,String password) throws SQLException {
		UsersBean usersBean = null;
		String sqlstr = "select * from users where userAccount = ? and userPwd = ?";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		psmt.setString(1, account);
		psmt.setString(2, password);
		ResultSet rs = psmt.executeQuery();
		if(rs.next()) {
			usersBean = new UsersBean(
					rs.getInt("userID"),
					rs.getString("userAccount"),
					rs.getString("userPwd"),
					rs.getString("userName"),
					rs.getString("gender"),
					rs.getString("birthday"),
					rs.getString("createDate"),
					rs.getString("userPhoto")
					
					);
		}
		rs.close();
		psmt.close();
		
		
		return usersBean;
	}
	
	public UsersBean selectUserByAccount(String account) throws SQLException {
		UsersBean usersBean = null;
		String sqlstr = "select * from users where userAccount = ?";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		psmt.setString(1, account);
		ResultSet rs = psmt.executeQuery();
		if(rs.next()) {
			usersBean = new UsersBean(
					rs.getInt("userID"),
					rs.getString("userAccount"),
					rs.getString("userPwd"),
					rs.getString("userName"),
					rs.getString("gender"),
					rs.getString("birthday"),
					rs.getString("createDate"),
					rs.getString("userPhoto")
					
					);
		}
		rs.close();
		psmt.close();
		
		
		return usersBean;
	}
	
	
	public void updateUserInfoByAccountWithinPhoto(String account,String userPwd, String userName, String gender, String birthday ,String userPhoto) throws SQLException {
		String sqlstr = "update users set userPwd = ? where userAccount = ?; "+
		"update users set userName = ? where userAccount = ?; "+
		"update users set gender = ? where userAccount = ?; "+
		"update users set birthday = ? where userAccount = ?;"+
		"update users set userPhoto = ? where userAccount = ?;";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		psmt.setString(1, userPwd);
		psmt.setString(2, account);
		psmt.setString(3, userName);
		psmt.setString(4, account);
		psmt.setString(5, gender);
		psmt.setString(6, account);
		psmt.setString(7, birthday);
		psmt.setString(8, account);
		psmt.setString(9, userPhoto);
		psmt.setString(10, account);
		psmt.executeUpdate();
		psmt.close();
	}
	
	public void updateUserInfoWithinPhotoById(int userID,UsersBean user) throws SQLException {
		String sqlstr = 
				"update users set userAccount = ? where userID = ?; "+
				"update users set userPwd = ? where userID = ?; "+
				"update users set userName = ? where userID = ?; "+
				"update users set gender = ? where userID = ?; "+
				"update users set birthday = ? where userID = ?;"+
				"update users set createDate = ? where userID = ?;"+
				"update users set userPhoto = ? where userID = ?;";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		psmt.setString(1, user.getUserAccount());
		psmt.setInt(2, userID);
		psmt.setString(3, user.getUserPwd());
		psmt.setInt(4, userID);
		psmt.setString(5, user.getUserName());
		psmt.setInt(6, userID);
		psmt.setString(7, user.getGender());
		psmt.setInt(8, userID);
		psmt.setString(9, user.getBirthday());
		psmt.setInt(10, userID);
		psmt.setString(11, user.getCreateDate());
		psmt.setInt(12, userID);
		psmt.setString(13, user.getUserPhoto());
		psmt.setInt(14, userID);
		psmt.executeUpdate();
		psmt.close();
	}
	
	public void updateUserInfoWithoutPhotoById(int userID,UsersBean user) throws SQLException {
		String sqlstr = 
				"update users set userAccount = ? where userID = ?; "+
				"update users set userPwd = ? where userID = ?; "+
				"update users set userName = ? where userID = ?; "+
				"update users set gender = ? where userID = ?; "+
				"update users set birthday = ? where userID = ?;"+
				"update users set createDate = ? where userID = ?;";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		psmt.setString(1, user.getUserAccount());
		psmt.setInt(2, userID);
		psmt.setString(3, user.getUserPwd());
		psmt.setInt(4, userID);
		psmt.setString(5, user.getUserName());
		psmt.setInt(6, userID);
		psmt.setString(7, user.getGender());
		psmt.setInt(8, userID);
		psmt.setString(9, user.getBirthday());
		psmt.setInt(10, userID);
		psmt.setString(11, user.getCreateDate());
		psmt.setInt(12, userID);
		psmt.executeUpdate();
		psmt.close();
	}
	
	
	public boolean isExistedAccount(String account) throws SQLException {
		boolean done = false;
		String sqlstr = "select userAccount from users";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			if(rs.getString("userAccount").equals(account)) {
				return true;
			}else {
				done = false;
			}
		}
		rs.close();
		psmt.close();
		return done;
	}
	
	public void insertNewUser(String userAccount, String userPwd, String userName, String gender, String birthday ,String userPhoto) throws SQLException {
		String sqlstr = "insert into users(userAccount,userPwd,userName,gender,birthday,userPhoto) values(?,?,?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		psmt.setString(1, userAccount);
		psmt.setString(2, userPwd);
		psmt.setString(3, userName);
		psmt.setString(4, gender);
		psmt.setString(5, birthday);
		psmt.setString(6, userPhoto);
		psmt.executeUpdate();
		
		psmt.close();
	}
	
	public void deleteUser(String userAccount) throws SQLException {
		String sqlstr = "delete users where userAccount = ?";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		psmt.setString(1, userAccount);
		psmt.executeUpdate();
		
		psmt.close();
	}
	
	public ArrayList<UsersBean> selectAllUser() throws SQLException{
		ArrayList<UsersBean> users = new ArrayList<UsersBean>();
		String sqlstr = "select * from users";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			UsersBean user = new UsersBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
			users.add(user);
		}
		
		rs.close();
		psmt.close();
		return users;
	}
	
	public ArrayList<UsersBean> selectTenUsers(int page) throws SQLException{
		ArrayList<UsersBean> users = new ArrayList<UsersBean>();
		String sqlstr = "select * from users order by userID offset "+ (page-1)*10 +" rows fetch next 10 rows only";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			UsersBean user = new UsersBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
			users.add(user);
		}
		rs.close();
		psmt.close();
		return users;
	}
	
	public int countUsers() throws SQLException {
		int count = 0;
		String sqlstr = " select count(*) from users";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		ResultSet rs = psmt.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);
		}
		rs.close();
		psmt.close();
		return count;
	}
}
