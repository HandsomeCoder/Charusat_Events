<%-- 
    Document   : EditProfile
    Created on : 16-Nov-2016, 14:14:22
    Author     : Harsh Shah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>Edit Profile</title>
  <link rel="stylesheet" href="../CSS/signUpPage.css"/>
  <link rel="stylesheet" href="../CSS/invalid.css"/>
</head>
<body>

  <section>
    <form name="editProfile" onsubmit="return validate()" id="editProfile" action="../editProfile" method="get">
    <table>
      <thead>
        <tr>
          <th colspan="2"> Edit Profile </th>
        </tr>
      </thead>
      <tbody>
      <tr>
        <td>
          <label for="EnrolNo"> University Enrolment Number : </label>
        </td>
        <td>
            <input type="text" name="EnrolNo" id="EnrolNo" value="<%out.print(request.getParameter("enrol"));%>" disabled placeholder="14IT120">
        </td>
      </tr>
      <tr>
        <td>
          <label for="Fname"> Full Name : </label>
        </td>
        <td>
          <input type="text" id="Fname" name="Fname" placeholder="First Name">
          <input type="text" id="Mname" name="Mname" placeholder="Middle Name">
          <input type="text" id="Lname" name="Lname" placeholder="Last Name">
        </td>
      </tr>
      <tr>
        <td>
          <label for="Dob"> Date of Birth : </label>
        </td>
        <td>
          <input type="date" id="Dob" name="Dob">
        </td>
      </tr>  
      <tr>
       <td>
         <label for="Institute"> Institute : </label>
       </td>
       <td>
         <select name="Institute" id="Institute">
           <option value="select">--- Select Institute ---</option>
           <option value="CSPIT"> CSPIT </option>
           <option value="CMPICA"> CMPICA </option>
           <option value="RPCP"> RPCP </option>
           <option value="IIIM"> IIIM </option>
           <option value="PDPAIS"> PDPAIS </option>
           <option value="ARIP"> ARIP </option>
           <option value="MTIN"> MTIN </option>
           <option value="CIPS"> CIPS </option>
         </select>
       </td>
      </tr>
      <tr>
       <td>
         <label for="Branch"> Branch : </label>
       </td>
       <td>
         <select name="Branch" id="Branch">
         </select>
       </td>
      </tr>
      <tr>
        <td>
          <label for="Email"> College Email ID : </label>
        </td>
        <td>
            <input type="email" id="Email" name="Email" value="<%out.print(request.getParameter("email"));%>" disabled placeholder="14it120@charusat.edu.in">
        </td>
       </tr>
      </tbody>
      <tfoot>
      <tr>
        <td>
          <input type="reset">
        </td>
        <td>
          <input type="submit">
        </td>
       </tr>
      </tfoot>
    </table>
    </form>
  </section>
      <script type="text/javascript" src="../js/signUpPage.js"></script>
      <script type="text/javascript" src="../js/editProfile.js"></script>
</body>
</html>