<%-- 
    Document   : updateEventSucess
    Created on : 20-Nov-2016, 15:31:52
    Author     : Harsh Shah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit Event</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../CSS/createEventSucess.css"/>
        <link rel="stylesheet" href="../CSS/site.css"/>
    </head>
    <body>
        <div id="eventSucess">
                <h1>Update Event is successfully.</h1>
                <div>
                    <a href="home.jsp">
                    <div class="operationalButton">
                        Edit Profile.
                    </div></a>
                    <div class="operationalButton" onclick="back()">
                        Manage Event.
                    </div>
                </div>
        </div>
      <script type="text/javascript" src="../js/updateEvent.js"></script>
    </body>
</html>
