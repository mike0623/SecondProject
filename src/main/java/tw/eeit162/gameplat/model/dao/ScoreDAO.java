package tw.eeit162.gameplat.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
