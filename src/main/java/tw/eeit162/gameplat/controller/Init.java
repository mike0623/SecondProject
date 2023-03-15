package tw.eeit162.gameplat.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Init implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext servletContext = sce.getServletContext();
    	String contextPath = servletContext.getContextPath();
    	contextPath = "http://localhost:8080" + contextPath;
    	servletContext.setAttribute("root", contextPath);
    	System.out.println(servletContext.getAttribute("root"));
    }
	
}
