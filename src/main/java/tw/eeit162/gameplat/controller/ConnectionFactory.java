package tw.eeit162.gameplat.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	private static Connection conn;
	public static Connection getConnection() throws SQLException  {
		InitialContext context;
		try {
			context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/connSqlServerJdbc/gameplat");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
