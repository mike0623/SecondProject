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

import com.google.gson.Gson;

import tw.eeit162.gameplat.controller.ConnectionFactory;
import tw.eeit162.gameplat.model.dao.UsersDAO;
import tw.eeit162.gameplat.model.javabean.ForManagerjspBean;
import tw.eeit162.gameplat.model.javabean.UsersBean;

@WebServlet("/UserManagePageN.do")
public class UserManagePageN extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}
       
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		int page = Integer.parseInt(request.getParameter("page"));
		try {
			Connection conn = ConnectionFactory.getConnection();
			UsersDAO usersDAO = new UsersDAO(conn);
			int count =  usersDAO.countUsers();
			int totalPage = (int)Math.ceil(count/10.0);
			ArrayList<UsersBean> users = usersDAO.selectTenUsers(page);
			session.setAttribute("users", users);
			conn.close();
			
			ForManagerjspBean forJson = new ForManagerjspBean(totalPage,users);
			Gson gson = new Gson();
			String json = gson.toJson(forJson);
			
			response.getWriter().write(json);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		
		
	}


}
