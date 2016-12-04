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
public class changePassword extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ResultSet rs = null;
        HttpSession session = req.getSession();
        String enrol = (String) session.getAttribute("EnrolNo");
        String result = "";
        String oldpass,newpass;
        oldpass = req.getParameter("opass");
        newpass = req.getParameter("npass");
        Connect dc = (Connect) getServletContext().getAttribute("DatabaseConnection");
        try {
            rs = dc.getPassword(enrol);
            rs.next();
            String spass = rs.getString("password");
            System.out.println(oldpass+" "+spass);
            if(oldpass.equals(spass)){
                int x = dc.updatePassword(enrol,newpass);
                if(x != 0){
                    System.out.println("sucess");
                    result = "Password Updated Successfully";
                    out.println(result);
                }else{
                    System.out.println("Fail");
                    result = "Password Updation Failed";
                    out.println(result);
                }
            }
            else{
                result = "Old Password is Invalid";
                out.println(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(changePassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
