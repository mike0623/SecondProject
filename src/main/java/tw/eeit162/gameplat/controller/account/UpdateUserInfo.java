package tw.eeit162.gameplat.controller.account;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import tw.eeit162.gameplat.controller.ConnectionFactory;
import tw.eeit162.gameplat.model.dao.UsersDAO;
import tw.eeit162.gameplat.model.javabean.UsersBean;

@WebServlet("/UpdateUserInfo.do")
@MultipartConfig
public class UpdateUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String userPhoto = null;

		if ((boolean) request.getAttribute("columnIsNull") == true
				|| (boolean) request.getAttribute("testPwdError") == true) {
			request.getRequestDispatcher("UpdateUserInfo.jsp").forward(request, response);
			return;
		}

		String updatePwd = request.getParameter("updatePwd");
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		Part part = request.getPart("userPhoto");
		
		HttpSession session = request.getSession();
		if (part.getSize() != 0) {
			InputStream in =part.getInputStream();

			userPhoto = "data:image/png;base64," + Base64.getEncoder().encodeToString(in.readAllBytes());
			in.close();
		} else {
			String realPath = request.getServletContext().getRealPath("");
			
			File file = new File(realPath + "WEB-INF/img/userPhotoForNull.jpg");
			FileInputStream fis = new FileInputStream(file);
			userPhoto = "data:image/png;base64," + Base64.getEncoder().encodeToString(fis.readAllBytes());
			fis.close();
			
		}
		session.setAttribute("userPwd", updatePwd);
		UsersBean myUser = (UsersBean) session.getAttribute("myUser");
		myUser.setUserPwd(updatePwd);
		myUser.setUserName(userName);
		myUser.setGender(gender);
		myUser.setBirthday(birthday);
		myUser.setUserPhoto(userPhoto);
		session.setAttribute("myUser", myUser);

		Connection conn;
		try {
			conn = ConnectionFactory.getConnection();
			UsersDAO usersDAO = new UsersDAO(conn);
			usersDAO.updateUserInfoByAccountWithinPhoto((String) session.getAttribute("userAccount"), updatePwd, userName, gender,
					birthday, userPhoto);
			response.setHeader("Refresh", "0;URL=ManageUserInfo.jsp");
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
