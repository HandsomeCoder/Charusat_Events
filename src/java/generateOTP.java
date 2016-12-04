/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Harsh Shah
 */
public class generateOTP extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        Random r = new Random();
        HttpSession session = req.getSession(true);
        int otp = r.nextInt(8999) + 1000;
        String email = req.getParameter("email");
        String enrol = req.getParameter("EnrolNo");
        session.setAttribute("OTP", otp);
        session.setAttribute("EnrolNo", enrol);
        session.setMaxInactiveInterval(300);
        EmailControl ess = new EmailControl();
        String welcomeSub = "Welcome to Charusat Events";
        String welcomeMsg = "Your OTP is <b>" + otp + "</b>";
        ess.sendMail(email, welcomeSub, welcomeMsg);
        res.sendRedirect("jsp/verificationPage.jsp");
    }
}
