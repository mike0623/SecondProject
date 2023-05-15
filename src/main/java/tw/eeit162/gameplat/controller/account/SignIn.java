package tw.eeit162.gameplat.controller.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SignIn.do")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response)  throws IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
		if((boolean)request.getAttribute("isRegistered") == false) {
			response.getWriter().write("請先註冊!3秒後導入註冊頁面!");
//			out.close();
			response.setHeader("Refresh", "3;URL=Register.jsp");
		}else if((boolean)request.getAttribute("isRegistered") == true){
			HttpSession session = request.getSession();
			
			
//			Cookie[] cookies = request.getCookies();
//			if(cookies != null) {
//				System.out.println("有餅乾喔!!");
//				for(Cookie cookie:cookies) {
//					System.out.println("地n個餅乾");
//					System.out.println("名稱:" + cookie.getName().toString() + "內容: " + cookie.getValue());
//					if(cookie.getName().toString() == "JSESSIONID") {
//						session.setAttribute("JSESSIONID",cookie.getValue());
//						System.out.println("回圈內的: " + cookie.getValue());
//					}
//				}
//			}
			session.setAttribute("userAccount", (String)request.getParameter("userAccount"));
			session.setAttribute("userPwd", (String)request.getParameter("userPwd"));
			session.setAttribute("isLogined", true);
			
			response.sendRedirect("Lobby.jsp");
			
		}
		
	}

}
