package tw.eeit162.gameplat.controller.game;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class GameFilter
 */
@WebFilter("/game/*")
public class GameFilter extends HttpFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		boolean isLogined = false;
		if(session.getAttribute("isLogined") != null) {
			isLogined = (boolean)session.getAttribute("isLogined");
		}
		if(isLogined == false) {
			response.getWriter().write("Not Login");
			return;
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
	}
}
