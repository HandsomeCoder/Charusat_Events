<%-- 
    Document   : verificationPage
    Created on : 05-Nov-2016, 15:55:45
    Author     : Harsh Shah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verification Page</title>
        <link rel="stylesheet" href="../CSS/site.css">
        <link rel="stylesheet" href="../CSS/verification.css">
    </head>
    <body>
        <div id="verify">
            <form action="../verify" method="get">
                <h1>Enter the 4 - digit One Time Password (OTP)</h1>
                <h3> send to your E-mail address</h3>
                <div id="error"></div>
                <input type="number" name="otp" placeholder="----" min="1000" max="9999">
                <br><br>
                <input type="reset" value="Reset">
                <input type="submit" id="submit" value="Verify">
            </form>
        </div>
    </body>
    <script src="../JS/verificationPage.js"></script>
</html>
