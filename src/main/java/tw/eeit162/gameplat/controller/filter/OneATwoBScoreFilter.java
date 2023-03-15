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

/**
 * Servlet Filter implementation class OneATwoBScoreFilter
 */
@WebFilter("/OneATwoBScore.jsp")
public class OneATwoBScoreFilter extends HttpFilter implements Filter {
       

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		((HttpServletRequest)request).getSession().removeAttribute("forScore");
	}

	public void destroy() {
	}

}
