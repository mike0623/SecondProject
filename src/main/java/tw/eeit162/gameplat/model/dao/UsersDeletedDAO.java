package tw.eeit162.gameplat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tw.eeit162.gameplat.model.javabean.UsersDeletedBean;

public class UsersDeletedDAO {
private Connection conn;
	
	public UsersDeletedDAO(Connection conn) {
		this.conn=conn;
	}
	
	
	public void insert(UsersDeletedBean usersDeletedBean) throws SQLException {
		String sqlstr = "insert into usersDeleted(userAccount,userPwd,userName,gender,birthday,userPhoto,deleter) values(?,?,?,?,?,?,'manager')";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		psmt.setString(1, usersDeletedBean.getUserAccount());
		psmt.setString(2, usersDeletedBean.getUserPwd());
		psmt.setString(3, usersDeletedBean.getUserName());
		psmt.setString(4, usersDeletedBean.getGender());
		psmt.setString(5, usersDeletedBean.getBirthday());
		psmt.setString(6, usersDeletedBean.getUserPhoto());
		psmt.executeUpdate();
		
		psmt.close();
	
	}
	

}
