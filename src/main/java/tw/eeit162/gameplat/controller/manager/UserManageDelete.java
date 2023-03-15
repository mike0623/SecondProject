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
import tw.eeit162.gameplat.model.dao.UsersDeletedDAO;
import tw.eeit162.gameplat.model.javabean.ForManagerjspBean;
import tw.eeit162.gameplat.model.javabean.UsersBean;
import tw.eeit162.gameplat.model.javabean.UsersDeletedBean;

/**
 * Servlet implementation class UserManageDelete
 */
@WebServlet("/UserManageDelete.do")
public class UserManageDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		String userAccount = request.getParameter("userAccount");
		int page = Integer.parseInt(request.getParameter("page"));
		try {
			Connection conn = ConnectionFactory.getConnection();
			UsersDAO usersDAO = new UsersDAO(conn);
			// 先取得即將刪除用戶的資料後刪除
			UsersBean user = usersDAO.selectUserByAccount(userAccount);
			usersDAO.deleteUser(userAccount);
			UsersDeletedDAO usersDeletedDAO = new UsersDeletedDAO(conn);
			// 將刪除的用戶新增到新表格
			UsersDeletedBean usersDeletedBean = new UsersDeletedBean();
			usersDeletedBean.setUserAccount(userAccount);
			usersDeletedBean.setUserPwd(user.getUserPwd());
			usersDeletedBean.setUserName(user.getUserName());
			usersDeletedBean.setGender(user.getGender());
			usersDeletedBean.setBirthday(user.getBirthday());
			usersDeletedBean.setUserPhoto(user.getUserPhoto());
			usersDeletedDAO.insert(usersDeletedBean);
			// 重新取得當前頁面10筆資料回傳
			ArrayList<UsersBean> users = usersDAO.selectTenUsers(page);
			if (users.size() == 0) {
				users = usersDAO.selectTenUsers(page - 1);
			}
			session.setAttribute("users", users);
			int count = usersDAO.countUsers();
			int totalPage = (int) Math.ceil(count / 10.0);
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
