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

@WebServlet("/UpdateUserInfo.do")
public class UpdateUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		if( (boolean)request.getAttribute("columnIsNull") == true || (boolean)request.getAttribute("testPwdError") == true) {
			try {
				request.getRequestDispatcher("UpdateUserInfo.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			String updatePwd = request.getParameter("updatePwd");
			String userName = request.getParameter("userName");
			String gender = request.getParameter("gender");
			String birthday = request.getParameter("birthday");
			session.setAttribute("userPwd", updatePwd);
			UsersBean myUser = (UsersBean)session.getAttribute("myUser");
			myUser.setUserPwd(updatePwd);
			myUser.setUserName(userName);
			myUser.setGender(gender);
			myUser.setBirthday(birthday);
			session.setAttribute("myUser", myUser);
			
			Connection conn;
			try {
				conn = ConnectionFactory.getConnection();
				UsersDAO usersDAO = new UsersDAO(conn);
				usersDAO.updateUserInfoByAccount((String)session.getAttribute("userAccount"), updatePwd, userName, gender, birthday);
				response.setHeader("Refresh", "0;URL=ManageUserInfo.jsp");
				conn.close();
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
