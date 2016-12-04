/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
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
public class signInServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String enrol, pass;
        enrol = req.getParameter("EnrolNo");
        pass = req.getParameter("Password");
        ResultSet result;
        Connect dc = (Connect) getServletContext().getAttribute("DatabaseConnection");
        try {
            result = dc.AuthenticateUser(enrol, pass);
            if (result.next()) {
                String veri = result.getString("verified");
                if (veri.equals("Y")) {
                    HttpSession session = req.getSession(true);
                    session.setAttribute("EnrolNo",enrol);
                    res.sendRedirect("jsp/home.jsp");
                } else {
                    res.sendRedirect("jsp/verificationPage.jsp");
                }
            } else {
                res.sendRedirect("Html/SignInPage.html");
            }
        } catch (SQLException ex) {
            Logger.getLogger(signUpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
