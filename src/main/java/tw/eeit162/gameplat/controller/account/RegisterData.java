package tw.eeit162.gameplat.controller.account;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.eeit162.gameplat.controller.ConnectionFactory;
import tw.eeit162.gameplat.model.dao.UsersDAO;

@WebServlet("/RegisterData.do")
public class RegisterData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("utf-8");
			Connection conn = ConnectionFactory.getConnection();
			UsersDAO usersDAO = new UsersDAO(conn);
			boolean isExistedAccount = usersDAO.isExistedAccount(request.getParameter("registerAccount"));
			String realPath = request.getServletContext().getRealPath("");
			File file = new File(realPath+"WEB-INF/img/userPhotoForNull.jpg");
			FileInputStream fis = new FileInputStream(file);
			String userPhoto = "data:image/png;base64," + Base64.getEncoder().encodeToString(fis.readAllBytes());
			fis.close();
			if(isExistedAccount) {
				request.setAttribute("accountRepeated", true);
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}else if((Boolean)request.getAttribute("columnIsNull")) {
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}else if((Boolean)request.getAttribute("testPwdError")) {
				request.getRequestDispatcher("Register.jsp").forward(request, response);
			}
			else {
				usersDAO.insertNewUser(request.getParameter("registerAccount"),request.getParameter("registerPwd"),request.getParameter("userName"),request.getParameter("gender"),request.getParameter("birthday"), userPhoto);
				response.getWriter().write("註冊成功!3秒後導入登入頁面");
				response.setHeader("Refresh", "3;URL=LoginPage.jsp");
			}
			
			
			
			
			
			
			
			
			
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
	}

}
