
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
import x.Connect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harsh Shah
 */


public class getData extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        ResultSet rs = null;
        String category = req.getParameter("category");
        String result = "<ul>";
        Connect dc = (Connect)getServletContext().getAttribute("DatabaseConnection");
        try {
            rs = dc.getEventsTitle(category);
            while(rs.next()){
                result += "<li onclick='getDetail("+rs.getString("id") +")'>" + rs.getString("title") + "</li>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
        }
        result +="</ul>";
        out.println(result);
    }
}
