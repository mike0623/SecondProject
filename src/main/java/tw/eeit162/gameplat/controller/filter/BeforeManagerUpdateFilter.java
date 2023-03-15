package tw.eeit162.gameplat.controller.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.eeit162.gameplat.model.javabean.UsersBean;

/**
 * Servlet Filter implementation class BeforeManageUpdateFilter
 */
@WebFilter("/ManagerUpdate.jsp")
public class BeforeManagerUpdateFilter extends HttpFilter implements Filter {
       

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		String page = req.getParameter("page");
		System.out.println(page);
		session.setAttribute("page1", page);
		UsersBean forUpdateBean = null;
		String userID = req.getParameter("userID");
		ArrayList<UsersBean> users = (ArrayList<UsersBean>)session.getAttribute("users");
		for(UsersBean user:users) {
			if(userID.equals(""+user.getUserID())) {
				forUpdateBean = user;
			}
		}
		session.setAttribute("userForUpdate", forUpdateBean);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
