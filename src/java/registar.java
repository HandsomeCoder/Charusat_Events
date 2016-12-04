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
public class registar extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ResultSet rs = null;
        int check = 0;
        String enrol = req.getParameter("EnrolNo");
        System.out.println(enrol);
        int id = Integer.parseInt(req.getParameter("id"));
        Connect dc = (Connect)getServletContext().getAttribute("DatabaseConnection");
        try {
            rs = dc.isUserRegistar(id, enrol);
            if(rs.next()){
                check = 2;
            }
            else{
                check = dc.registarUser(id,enrol);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println(check);
    }
}
