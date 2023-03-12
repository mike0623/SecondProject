package tw.eeit162.gameplat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
					rs.getString("birthday")
					
					);
		}
		rs.close();
		psmt.close();
		
		
		return usersBean;
	}
	
	
	public void updateUserInfoByAccount(String account,String userPwd, String userName, String gender, String birthday) throws SQLException {
		String sqlstr = "update users set userPwd = ? where userAccount = ?; "+
		"update users set userName = ? where userAccount = ?; "+
		"update users set gender = ? where userAccount = ?; "+
		"update users set birthday = ? where userAccount = ?;";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		psmt.setString(1, userPwd);
		psmt.setString(2, account);
		psmt.setString(3, userName);
		psmt.setString(4, account);
		psmt.setString(5, gender);
		psmt.setString(6, account);
		psmt.setString(7, birthday);
		psmt.setString(8, account);
		psmt.executeUpdate();
		psmt.close();
	}
	
	
	public boolean isExistedAccount(String account) throws SQLException {
		boolean done = true;
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
	
	public void insertNewUser(String userAccount, String userPwd, String userName, String gender, String birthday) throws SQLException {
		String sqlstr = "insert into users(userAccount,userPwd,userName,gender,birthday) values(?,?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		psmt.setString(1, userAccount);
		psmt.setString(2, userPwd);
		psmt.setString(3, userName);
		psmt.setString(4, gender);
		psmt.setString(5, birthday);
		psmt.executeUpdate();
	}
}
