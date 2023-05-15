package tw.eeit162.gameplat.controller.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tw.eeit162.gameplat.controller.ConnectionFactory;
import tw.eeit162.gameplat.model.dao.ScoreDAO;
import tw.eeit162.gameplat.model.javabean.ScoreBean;

@WebFilter("/OneATwoBScore.jsp")
public class BeforeOneATwoBScore extends HttpFilter implements Filter {
    

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		try {
			Connection conn = ConnectionFactory.getConnection();
			ScoreDAO scoreDAO = new ScoreDAO(conn);
			ArrayList<ScoreBean> list = scoreDAO.selectTopTen();
			session.setAttribute("list", list);
			System.out.println(list.get(0));
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
