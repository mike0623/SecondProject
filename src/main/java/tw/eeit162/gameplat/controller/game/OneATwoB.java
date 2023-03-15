package tw.eeit162.gameplat.controller.game;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.tomcat.jdbc.pool.interceptor.ResetAbandonedTimer;

import com.google.gson.Gson;

import tw.eeit162.gameplat.controller.ConnectionFactory;
import tw.eeit162.gameplat.model.dao.ScoreDAO;

@WebServlet("/OneATwoB.do")
public class OneATwoB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
			session.setAttribute("answer", getAnswer());
			ArrayList forScore =new ArrayList();
			forScore.add((int[])session.getAttribute("answer"));
			session.setAttribute("forScore", forScore);
			
		}
		int count = (int)session.getAttribute("count");
		count++;
		session.setAttribute("count", count);
		String input = request.getParameter("input");
		String result = getResult(input, (int[])session.getAttribute("answer"));
		
		ArrayList list = new ArrayList();
		list.add(count);
		list.add(input);
		list.add(result);
		System.out.print(((int[])session.getAttribute("answer"))[0]);
		System.out.print(((int[])session.getAttribute("answer"))[1]);
		System.out.print(((int[])session.getAttribute("answer"))[2]);
		System.out.println(((int[])session.getAttribute("answer"))[3]);
		ArrayList forScore = (ArrayList)session.getAttribute("forScore");
		forScore.add(list);
		session.setAttribute("forScore", forScore);
		
		
		
		
		
		
		Gson gson = new Gson();
		String dataForScript = gson.toJson(list);
		
		
		if("4A0B".equals(result)) {
			reset(session);
			int score = 101 - count;
			try {
				Connection conn = ConnectionFactory.getConnection();
				ScoreDAO scoreDAO = new ScoreDAO(conn);
				scoreDAO.insertNewScore(score,(String)session.getAttribute("userAccount"));
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.getWriter().write("win");
		}else {
			response.getWriter().write(dataForScript);
		}
	}
	
	
	private int[] getAnswer() {
		int[] answer = new int[4];
		for(int i = 0;i<answer.length;i++) {
			answer[i] = (int)Math.floor(Math.random()*10);
			for(int j = 0;j<i;j++) {
				if(answer[i] == answer[j]) {
					answer[i] = (int)Math.floor(Math.random()*10);
					j=-1;
				}
			}
		}
		return answer;
	}
	
	private String getResult(String input, int[] answer) {
		int a = 0;
		int b = 0;
		for(int i = 0;i<4;i++) {
			for(int j =0;j<4;j++) {
				if(Integer.parseInt(""+input.charAt(i))  == answer[j]){
					if(i == j) {
						a++;
					}else {
						b++;
					}
				}
			}
		}
		String result = a+"A"+b+"B";
		return result;
	}
	
	public static void reset(HttpSession session) {
		session.removeAttribute("count");
		session.removeAttribute("answer");
	}
}
