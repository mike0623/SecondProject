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

@WebFilter("/OneATwoB.do")
public class TestOneATwoBFilter extends HttpFilter implements Filter {
       

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String input = request.getParameter("input");
		if(input.length() != 4) {
			response.getWriter().write("Wrong Input Type");
			return;
		}
		for(int j =0; j<input.length();j++) {
			if(!Character.isDigit(input.charAt(j))) {
				response.getWriter().write("Wrong Input Type");
				return;
			}
//			System.out.println("-------------");
//			System.out.println(input.charAt(j));
			for(int i = j+1;i<input.length();i++) {
//				System.out.println(input.charAt(i));
				if(input.charAt(j) == input.charAt(i)) {
//					System.out.println("有重複");
					response.getWriter().write("Wrong Input Type");
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}


	public void destroy() {
	}
}
