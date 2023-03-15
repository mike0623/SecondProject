package tw.eeit162.gameplat.controller.manager;

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

@WebServlet("/UserManageUpdate.do")
@MultipartConfig
public class UserManageUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		UsersBean UserOnlyForGetID =  (UsersBean)session.getAttribute("userForUpdate");
//		session.removeAttribute("userForUpdate");
		int userID = UserOnlyForGetID.getUserID();
		String userAccount = request.getParameter("userAccount");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String createDate = request.getParameter("createDate");
		Part part = request.getPart("userPhoto");
		UsersBean user = new UsersBean();
		user.setUserAccount(userAccount);
		user.setUserPwd(userPwd);
		user.setUserName(userName);
		user.setGender(gender);
		user.setBirthday(birthday);
		user.setCreateDate(createDate);
		
		try {
			Connection conn = ConnectionFactory.getConnection();
			UsersDAO usersDAO = new UsersDAO(conn);
			if (part.getSize() != 0) {
				InputStream in =part.getInputStream();
				String userPhoto = "data:image/png;base64," + Base64.getEncoder().encodeToString(in.readAllBytes());
				in.close();
				user.setUserPhoto(userPhoto);
				usersDAO.updateUserInfoWithinPhotoById(userID,user);
			} else {
				usersDAO.updateUserInfoWithoutPhotoById(userID,user);
			}
			conn.close();
			response.sendRedirect("UserManagePage1.do");
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
