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

@WebFilter("/RegisterData.do")
public class TestRegisterFilter extends HttpFilter implements Filter {
       
	public void init(FilterConfig fConfig) throws ServletException {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String registerAccount = request.getParameter("registerAccount");
		String registerPwd = request.getParameter("registerPwd");
		String testPwd = request.getParameter("testPwd");
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		if("".equals(registerAccount) || "".equals(registerPwd) || "".equals(userName) || "".equals(gender) || "".equals(birthday)) {
			request.setAttribute("columnIsNull", true);
		}else {
			request.setAttribute("columnIsNull", false);
		}
		if(!registerPwd.equals(testPwd)) {
			request.setAttribute("testPwdError", true);
		}else {
			request.setAttribute("testPwdError", false);
		}
		
		
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
