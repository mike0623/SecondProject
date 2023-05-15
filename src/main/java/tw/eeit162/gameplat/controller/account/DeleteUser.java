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
import tw.eeit162.gameplat.model.dao.UsersDeletedDAO;
import tw.eeit162.gameplat.model.javabean.UsersBean;
import tw.eeit162.gameplat.model.javabean.UsersDeletedBean;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser.do")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String userAccount = (String)session.getAttribute("userAccount");
		if(session.getAttribute("deleteUser") == null) {
			session.setAttribute("deleteUser", true);
			
		}else {
			if("我確定".equals(request.getParameter("confirmDelete"))) {
				try {
					response.sendRedirect("LoginPage.jsp");
					Connection conn = ConnectionFactory.getConnection();
					UsersDAO usersDAO = new UsersDAO(conn);
					//取得將刪除用戶資料後刪除
					UsersBean user = usersDAO.selectUserByAccount(userAccount);
					usersDAO.deleteUser(userAccount);
					//
					UsersDeletedDAO usersDeletedDAO = new UsersDeletedDAO(conn);
					UsersDeletedBean usersDeletedBean = new UsersDeletedBean();
					usersDeletedBean.setUserAccount(userAccount);
					usersDeletedBean.setUserPwd(user.getUserPwd());
					usersDeletedBean.setUserName(user.getUserName());
					usersDeletedBean.setGender(user.getGender());
					usersDeletedBean.setBirthday(user.getBirthday());
					usersDeletedBean.setUserPhoto(user.getUserPhoto());
					usersDeletedDAO.insertWhenUserDelete(usersDeletedBean);
					
					conn.close();
					session.removeAttribute("deleteUser");
					if(userAccount != null) {
						session.removeAttribute("userAccount");			
					}
					if(session.getAttribute("userPwd") != null) {
						session.removeAttribute("userPwd");			
					}
					session.setAttribute("isLogined", false);
					return;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			session.removeAttribute("deleteUser");
			
			
		}
		
		response.sendRedirect("ManageUserInfo.jsp");
	}
}
