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
import javax.servlet.RequestDispatcher;
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
public class verify extends HttpServlet {
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int otpEntered = Integer.parseInt(req.getParameter("otp"));
        HttpSession session = req.getSession();
        int sendOtp = (Integer)session.getAttribute("OTP");
        if(sendOtp == otpEntered){
            Connect dc = (Connect)getServletContext().getAttribute("DatabaseConnection");
            String enrol = (String)session.getAttribute("EnrolNo");
            try {
                dc.verifiedUser(enrol);
            } catch (SQLException ex) {
                Logger.getLogger(verify.class.getName()).log(Level.SEVERE, null, ex);
            }
            res.sendRedirect("jsp/home.jsp");
        }else{
            res.sendRedirect("jsp/verificationPage.jsp");
        }
    }
}
