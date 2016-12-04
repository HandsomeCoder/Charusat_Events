/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import x.Connect;

/**
 *
 * @author Harsh Shah
 */
public class createEvent extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String category,title,venue,date,time,detail,createby;
        category = req.getParameter("category");
        title = req.getParameter("title");
        venue = req.getParameter("venue");
        date = req.getParameter("date");
        time = req.getParameter("time");
        detail = req.getParameter("detail");
        HttpSession session = req.getSession(true);
        createby = (String)session.getAttribute("EnrolNo");
        int result;
        Connect dc = (Connect)getServletContext().getAttribute("DatabaseConnection");
        try {
            result = dc.createEvent(createby,title,detail,category,venue,date,time);
            if(result == 0){
                res.sendRedirect("html/createEventFail.html");
            }
            else{
                res.sendRedirect("jsp/createEventSucess.jsp");
            }

        } catch (SQLException ex) {
            Logger.getLogger(signUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
