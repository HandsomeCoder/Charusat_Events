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
import x.Connect;

/**
 *
 * @author Harsh Shah
 */
public class deleteEvent extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();    
        int id = Integer.parseInt(req.getParameter("id"));
        
        int rs;
        
        Connect dc = (Connect) getServletContext().getAttribute("DatabaseConnection");
        try {
            rs = dc.deleteEvent(id);
            out.print(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
