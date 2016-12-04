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
public class getRegistration extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));

        ResultSet rs;
        int i = 0;
        String result = "<center> <table id=\"registry\" border=\"2\">\n"
                + "    <thead>\n"
                + "      <tr>\n"
                + "        <th class=\"font-thead\"colspan=\"9\"> Registration Record</th>\n"
                + "      </tr>\n"
                + "    </thead>\n"
                + "    <tbody>\n"
                + "       <tr>\n"
                + "        <th>Sr. no</th>\n"
                + "        <th>Enroll No.</th>\n"
                + "        <th>First name</th>\n"
                + "        <th>Middle name</th>\n"
                + "        <th>Last name</th>\n"
                + "        <th>Dob</th>\n"
                + "        <th>Institute</th>\n"
                + "        <th>Branch</th>\n"
                + "        <th>Email ID</th>  \n"
                + "      </tr>\n";
        Connect dc = (Connect) getServletContext().getAttribute("DatabaseConnection");
        try {
            rs = dc.getRegistration(id);
            while (rs.next()) {
                i++;
                result += "<tr>"
                        + "<td>" + i + "</th>"
                        + "<td>" + rs.getString("enrolno") + "</td>"
                        + "<td>" + rs.getString("fname") + "</td>"
                        + "<td>" + rs.getString("mname") + "</td>"
                        + "<td>" + rs.getString("lname") + "</td>"
                        + "<td>" + rs.getString("dob") + "</td>"
                        + "<td>" + rs.getString("institute") + "</td>"
                        + "<td>" + rs.getString("branch") + "</td>"
                        + "<td>" + rs.getString("email") + "</td>"
                        + " </tr>";
            }
            if (i == 0) {
                result += "<tr>"
                        + " <th colspan=\"9\"> No. Record Found</th>"
                        + "</tr>";
            }

        } catch (SQLException ex) {
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
        }

        result += "    </tbody>\n"
                + "  </table><center>";
        out.println(result);
    }
}
