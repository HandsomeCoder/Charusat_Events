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
public class getDetail extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ResultSet rs,rs2 = null;
        HttpSession session = req.getSession();
        String enrol = (String)session.getAttribute("EnrolNo");
        int id = Integer.parseInt(req.getParameter("id"));
        String result = "";
        Connect dc = (Connect)getServletContext().getAttribute("DatabaseConnection");
        try {
            rs = dc.getEventDetail(id);
            rs2 = dc.isActive(id);
            rs.next();
            rs2.next();
            if(rs.getString("active").equals("Y")){
            result += "<h1>" + rs.getString("title") +"</h1>"
                    +"<p class=\"right-align right-margin\"><b> - By </b>"+ rs.getString("createby")+"</p>"
                    +"<ul>"
                    +"<li><b>Venue: </b>"+ rs.getString("venue")+"</li>"
                    +"<li><b> Date: </b>"+ rs.getString("edate")+"</li>"
                    +"<li><b>Time: </b>"+ rs.getString("etime")+"</li>"
                    +"</ul>"
                    +"<hr>"
                    + "<p class=\"left-margin right-margin\">"+ rs.getString("detail")+"</p>"
                    +"<div id=\"registar\" class=\"operationalButton\" onclick=\"registar("+id+",\'"+enrol+"\')\">"
                    +" Resgistar"
                    +"</div>";
            }else{
                            result += "<h1>" + rs.getString("title") +"</h1>"
                    +"<p class=\"right-align right-margin\"><b> - By </b>"+ rs.getString("createby")+"</p>"
                    +"<ul>"
                    +"<li><b>Venue: </b>"+ rs.getString("venue")+"</li>"
                    +"<li><b> Date: </b>"+ rs.getString("edate")+"</li>"
                    +"<li><b>Time: </b>"+ rs.getString("etime")+"</li>"
                    +"</ul>"
                    +"<hr>"
                    + "<p class=\"left-margin right-margin\">"+ rs.getString("detail")+"</p>"
                    +"<div id=\"registar\" class=\"operationalButton deactive\" onclick=\"deactive()\">"
                    +" Resgistar"
                    +"</div>";
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.println(result);
    }
}
