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
import x.Connect;

/**
 *
 * @author Harsh Shah
 */
public class sendEventUpdate extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        int id = Integer.parseInt(req.getParameter("id"));
        String sub = req.getParameter("subject");
        String msg = req.getParameter("message");
        
        ResultSet rs = null;
        int i = 0;
        String recipients[] = new String[100];
        Connect dc = (Connect) getServletContext().getAttribute("DatabaseConnection");
        try {
            rs = dc.getRegistrationEmail(id);
            while (rs.next()) {
                    recipients[i] = rs.getString("email");
                    System.out.println(recipients[i]);
                i++;
            }
            if(i == 0){
                out.print("0"); 
            }else{
                System.out.println(i);
                EmailControl ess = new EmailControl();
                ess.sendMailMultiple(recipients, sub, msg,i);
                out.print("1");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
