/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
public class getEventInfo extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ResultSet rs = null;
        int id = Integer.parseInt(req.getParameter("id"));
        String result = " <h1>Event Details </h1>";
        Connect dc = (Connect)getServletContext().getAttribute("DatabaseConnection");
        try {
            rs = dc.getEventInfo(id);
            while(rs.next()){
            result +="<p><b>Event ID.: </b>#"+rs.getString("ID")+"</p>\n" +
                "<p><b>Title: </b>"+rs.getString("title")+"</p>" +
                "<p><b>Detail: </b>"+rs.getString("detail")+"</p>" +
                "<p><b>Category: </b>"+rs.getString("category")+"</p>" +
                "<p><b>Venue: </b>"+rs.getString("venue")+"</p>" +
                "<p><b>Date: </b>"+rs.getString("edate")+"</p>" +
                "<p><b>Time: </b>"+rs.getString("etime")+"</p>" +
                "<br>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println(result);
    }   
}
