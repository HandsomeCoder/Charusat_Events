<%-- 
    Document   : profile
    Created on : 08-Nov-2016, 17:40:15
    Author     : Harsh Shah
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="x.Connect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <link rel="stylesheet" href="../CSS/site.css">
        <link rel="stylesheet" href="../CSS/profile.css">
        <link rel="stylesheet" href="../CSS/invalid.css">
    </head>
    <body onload="getBasic()">
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
                My Profile
            </div>
            <div id="signout" class="operationalButton">
                    Sign Out
            </div>
            <a href="home.jsp">
                <div id="home" class="operationalButton">
                    Home
                </div>
            </a>
        </nav>
        <section id="profileInfo">
            <div id="title">
                <h3> About </h3>
                <ul>
                    <li onclick="getBasic()"> Basic Information</li>
                    <li onclick="getSecurityInfo()"> Account Security</li>
                    <li onclick="getMyEvents()"> My Events</li>
                    <li onclick="getRegistry()"> Registered Events</li>
                </ul>
            </div>
            <div id="desc">

            </div>
        </section>
        <script src="../js/profile.js" type="text/javascript"></script>
        <script src="../js/signout.js" type="text/javascript"></script>
    </body>
</html>
