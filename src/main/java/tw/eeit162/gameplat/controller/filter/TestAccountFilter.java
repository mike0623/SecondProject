package tw.eeit162.gameplat.controller.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import tw.eeit162.gameplat.controller.ConnectionFactory;

@WebFilter("/SignIn.do")
public class TestAccountFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	Connection conn;
	
       
	public void init(FilterConfig fConfig) throws ServletException {
//		try {
//			System.out.println("連上了!!!");
//			conn = ConnectionFactory.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("utf-8");
			conn = ConnectionFactory.getConnection();
			String sqlstr = "select * from users where userAccount = ? and userPwd = ?";
			PreparedStatement psmt = conn.prepareStatement(sqlstr);
			psmt.setString(1, request.getParameter("userAccount"));
			psmt.setString(2, request.getParameter("userPwd"));
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				request.setAttribute("isRegistered", true);
			}else {
				request.setAttribute("isRegistered", false);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			chain.doFilter(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}


	public void destroy() {
//		try {
//			System.out.println("段開了!!!!!!");
//			if(!conn.isClosed()) {
//				conn.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}
