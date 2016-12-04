<%-- 
    Document   : profile
    Created on : 05-Nov-2016, 15:44:55
    Author     : Harsh Shah
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="x.Connect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="../CSS/site.css">
        <link rel="stylesheet" href="../CSS/home.css">
    </head>
    <body>
        <nav>
            <%         Connect dc = (Connect)getServletContext().getAttribute("DatabaseConnection");
                        String enrol = (String)session.getAttribute("EnrolNo");
                        ResultSet rs = dc.isAdmin(enrol);
                        rs.next();
                        if(rs.getString("admin").equals("Y")){
            %>
            <a href="createEvent.jsp">
                <div id="createEvent" class="operationalButton">
                    + Create Event
                </div>
            </a>
            <%
                        }
            %>
            <div id="pageTitle">
                Home
            </div>
            <div id="signout" class="operationalButton">
                    Sign Out
            </div>
            <a href="profile.jsp">
                <div id="editProfile" class="operationalButton">
                    Edit Profile
                </div>
            </a>
        </nav>
        <section id="eventsSection">
            <div onclick="getTitle('sport')">
                Sports Events
            </div>
            <div onclick="getTitle('tech')">
                Technical Events
            </div>
            <div onclick="getTitle('nontech')">
                Non-Technical Event
            </div>
            <div onclick="getTitle('workshop')">
                Workshops
            </div>
            <div onclick="getTitle('lec')">
                Seminars/Expert - Lectures
            </div>
        </section>
        <section id="eventInfo">
            <div id="eventTitleContainer">
                <h3> Events Title </h3>
                <div id="eventTitle">
                    
                </div>
            </div>
            <div id="eventDesc">
                <h3> Event Description </h3>
            </div>
        </section>
        <script src="../js/signout.js" type="text/javascript"></script>
        <script src="../js/home.js" type="text/javascript"></script>
    </body>
</html>
