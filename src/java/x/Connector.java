package x;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harsh Shah
 */
public class Connector implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--------Listener-------------------");
        ServletContext sc = sce.getServletContext();
        String url = sc.getInitParameter("URL");
    	String uname = sc.getInitParameter("USER");
    	String pass = sc.getInitParameter("PASS");
        Connect dc = new Connect(url,uname,pass);
        sc.setAttribute("DatabaseConnection", dc);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    
    
    
    }
    
}
