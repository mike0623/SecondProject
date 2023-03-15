package tw.eeit162.gameplat.controller.filter;

import java.io.IOException;
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

import tw.eeit162.gameplat.controller.game.OneATwoB;

@WebFilter("/Lobby.jsp")
public class BeforeLobbyFlter extends HttpFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
	}
       

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		if("michael@gmail.com".equals((String)session.getAttribute("userAccount")) && "1234".equals(session.getAttribute("userPwd")) ) {
			((HttpServletResponse)response).sendRedirect("UserManagePage1.do");
			return;
		}
		OneATwoB.reset(session);
		
		
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
