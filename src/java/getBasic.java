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
public class getBasic extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ResultSet rs = null;
        HttpSession session = req.getSession();
        String enrol = (String) session.getAttribute("EnrolNo");
        String result = "";
        Connect dc = (Connect) getServletContext().getAttribute("DatabaseConnection");
        try {
            rs = dc.getBasicInfo(enrol);
            rs.next();
            result="<div class=\"operationalButton float-right\" onclick=\"editProfile()\">"+
                	"Edit"+
                    "</div>"+
                    "<h1>Basic Info </h1>\n" +
                "<p><b>Enrolment No.: </b><span  id=\"enrol\">"+rs.getString("enrolno")+"</span></p>\n" +
                "<p><b>First Name: </b>"+rs.getString("fname")+"</p>" +
                "<p><b>Middle Name: </b>"+rs.getString("mname")+"</p>" +
                "<p><b>Last Name: </b>"+rs.getString("lname")+"</p>" +
                "<p><b>Date of Birth: </b>"+rs.getString("dob")+"</p>" +
                "<p><b>Institute: </b>"+rs.getString("institute")+"</p>" +
                "<p><b>Branch: </b>"+rs.getString("branch")+"</p>" +
                "<p><b>Email ID: </b><span id=\"email\">"+rs.getString("email")+"</span></p>";
            if(rs.getString("verified").equals("Y")){
                  result+="<p><b>Email ID Verified: </b><span class=\"green\">Yes</span></p>";     
            }
            else{
                result+="<p><b>Email ID Verified: </b><span class=\"green\">No</span></p>";        
            }
                    
            result+="<p><b>Number Permission to Create Event: </b>"+rs.getString("permission")+"</p>";

        } catch (SQLException ex) {
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
        }
        result += "</ul>";
        out.println(result);
    }
}
