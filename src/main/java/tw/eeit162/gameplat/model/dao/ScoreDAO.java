package tw.eeit162.gameplat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tw.eeit162.gameplat.model.javabean.ScoreBean;
import tw.eeit162.gameplat.model.javabean.UsersBean;

public class ScoreDAO {
	Connection conn = null;

	public ScoreDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void insertNewScore(int score,String account) throws SQLException {
		String sqlstr = "insert into score(score,f_userID,f_gameID) values(?,(select userID from users where userAccount = ?),(select gameID from boardgame where gameName = '1A2B'))";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		psmt.setInt(1, score);
		psmt.setString(2, account);
		psmt.executeUpdate();
	
		psmt.close();
	}
	
	public ArrayList<ScoreBean> selectTopTen() throws SQLException{
		ArrayList<ScoreBean> list = new ArrayList<ScoreBean>();
		String sqlstr = "  select top(10) userName,score,[dbo].[score].[createdDate] from score\r\n"
				+ "  join users on ([dbo].[score].f_userID = [dbo].[users].userID)\r\n"
				+ "  where [f_gameID] = 1 order by score desc,createdDate";
		PreparedStatement psmt = conn.prepareStatement(sqlstr);
		ResultSet rs = psmt.executeQuery();
		while(rs.next()) {
			UsersBean usersBean = new UsersBean();
			usersBean.setUserName(rs.getString("userName"));
			ScoreBean scoreBean = new ScoreBean();
			scoreBean.setF_userID(usersBean);
			scoreBean.setScore(rs.getInt("score"));
			scoreBean.setCreatedDate(rs.getString("createdDate"));
			list.add(scoreBean);
		}
		
		rs.close();
		psmt.close();
		return list;
	}
}
