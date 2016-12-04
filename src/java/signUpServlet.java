/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;
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
public class signUpServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String enrol,fname,mname,lname,dob,institute,branch,email,pass;
        enrol = req.getParameter("EnrolNo");
        fname = req.getParameter("Fname");
        mname = req.getParameter("Mname");
        lname = req.getParameter("Lname");
        dob = req.getParameter("Dob");
        institute = req.getParameter("Institute");
        branch = req.getParameter("Branch");
        email = req.getParameter("Email");
        pass = req.getParameter("Password");
        int result;
        Connect dc = (Connect)getServletContext().getAttribute("DatabaseConnection");
        try {
            result = dc.createUser(enrol, fname, mname, lname, dob, institute, branch, email, pass);
            if(result == 0){
                res.sendRedirect("Html/SignUpPage.html");
            }
            else{
                res.sendRedirect("generateOTP?EnrolNo="+enrol+"&email="+email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(signUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
