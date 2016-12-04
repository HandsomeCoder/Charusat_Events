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
public class editProfile extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String enrol,fname,mname,lname,dob,institute,branch;
        HttpSession ss = req.getSession(true);
        
        enrol = (String)ss.getAttribute("EnrolNo");
        fname = req.getParameter("Fname");
        mname = req.getParameter("Mname");
        lname = req.getParameter("Lname");
        dob = req.getParameter("Dob");      
        institute = req.getParameter("Institute");
        branch = req.getParameter("Branch");
        
        
        int rs;

        String result = "";
        Connect dc = (Connect) getServletContext().getAttribute("DatabaseConnection");
        try {
            rs = dc.updateBasicInfo(enrol,fname,mname,lname,dob,institute,branch);
            System.out.println(rs);
            if(rs == 1){
                res.sendRedirect("http://localhost:8080/Charusat_Events/jsp/editProfileSucess.jsp");
            }
            else{
                res.sendRedirect("http://localhost:8080/Charusat_Events/Html/editProfileFail.html");
            }

        } catch (SQLException ex) {
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
