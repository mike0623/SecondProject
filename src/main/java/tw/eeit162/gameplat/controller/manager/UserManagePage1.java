package tw.eeit162.gameplat.controller.manager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.eeit162.gameplat.controller.ConnectionFactory;
import tw.eeit162.gameplat.model.dao.UsersDAO;
import tw.eeit162.gameplat.model.javabean.UsersBean;

@WebServlet("/UserManagePage1.do")
public class UserManagePage1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			HttpSession session = request.getSession();
			int page = 1;
			System.out.println(session.getAttribute("page1"));
			if(session.getAttribute("page1") != null) {
				page = Integer.parseInt((String)session.getAttribute("page1")) ;
			}
			Connection conn = ConnectionFactory.getConnection();
			UsersDAO usersDAO = new UsersDAO(conn);
			ArrayList<UsersBean> users = usersDAO.selectTenUsers(page);
			int count =  usersDAO.countUsers();
			int totalPage = (int)Math.ceil(count/10.0);
			conn.close();
			session.setAttribute("totalPage", totalPage);
			session.setAttribute("users", users);
			
			response.sendRedirect("Manager.jsp");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
