package tw.eeit162.gameplat.controller.account;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.eeit162.gameplat.controller.ConnectionFactory;
import tw.eeit162.gameplat.model.dao.UsersDAO;
import tw.eeit162.gameplat.model.javabean.UsersBean;

@WebServlet("/ManageUserInfo.do")
public class ManageUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		Connection conn;
		HttpSession session = request.getSession();
		try {
			conn = ConnectionFactory.getConnection();
			UsersDAO usersDAO = new UsersDAO(conn);
			UsersBean myUser = usersDAO.selectUserByAccount((String)session.getAttribute("userAccount"));
			
			session.setAttribute("myUser", myUser);
//			request.getRequestDispatcher("ManageUserInfo.jsp").forward(request, response);
			response.sendRedirect("ManageUserInfo.jsp");
			conn.close();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
