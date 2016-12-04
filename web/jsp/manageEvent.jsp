<%-- 
    Document   : manageEvent
    Created on : 19-Nov-2016, 23:25:16
    Author     : Harsh Shah
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="x.Connect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Event</title>
        <link rel="stylesheet" href="../CSS/site.css">
        <link rel="stylesheet" href="../CSS/profile.css">
        <link rel="stylesheet" href="../CSS/invalid.css">
        <link rel="stylesheet" href="../CSS/createEvent.css">
        <link rel="stylesheet" href="../CSS/manageEvent.css">
    </head>
    <body onload="getEventInfo(<%out.print(request.getParameter("id"));%>)">
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
                Manage Event
            </div>
            <div id="signout" class="operationalButton">
                    Sign Out
            </div>
            <a href="profile.jsp">
                <div id="home" class="operationalButton">
                    Profile
                </div>
            </a>
        </nav>
        <section id="profileInfo">
            <div id="title">
                <h3> Manage </h3>
                <ul>
                    <li onclick="getEventInfo(<%out.print(request.getParameter("id"));%>)"> Event Information</li>
                    <li onclick="EditEvent(<%out.print(request.getParameter("id"));%>)"> Edit Event</li>
                    <li onclick="getRegistration(<%out.print(request.getParameter("id"));%>)"> No. of Registration</li>
                    <li onclick="sendUpdate(<%out.print(request.getParameter("id"));%>)"> Send Updates</li>
                    <li onclick="closeDelete(<%out.print(request.getParameter("id"));%>)"> Close/Delete Event</li>
                </ul>
            </div>
            <div id="desc">

            </div>
        </section>
        <script src="../js/signout.js" type="text/javascript"></script>
        <script src="../js/manageEvent.js" type="text/javascript"></script>
    </body>
</html>