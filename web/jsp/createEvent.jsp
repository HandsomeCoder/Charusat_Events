<%-- 
    Document   : createEvent
    Created on : 08-Nov-2016, 14:18:46
    Author     : Harsh Shah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Event</title>
          <link rel="stylesheet" href="../CSS/createEvent.css"/>
    </head>
    <body>
        <section>
            <form name="createEvent" id="createEvent" action="../createEvent" method="get">
                <table>
                    <thead>
                        <tr>
                            <th colspan="2"> Create Event </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <label for="category"> Category : </label>
                            </td>
                            <td>
                                <select name="category" id="category">
                                    <option value="select">--- Select Category ---</option>
                                    <option value="Sport"> Sport </option>
                                    <option value="tech"> Technical </option>
                                    <option value="nontech"> Non - Technical </option>
                                    <option value="workshop"> Workshop </option>
                                    <option value="lec"> Seminars/Expert - Lectures </option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="title"> Title: </label>
                            </td>
                            <td>
                                <input type="text" name="title" id="title" placeholder="Charusat Event">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="venue"> Venue: </label>
                            </td>
                            <td>
                                <input type="text" name="venue" placeholder="CE/IT Seminar Hall">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="date"> Date: </label>
                            </td>
                            <td>
                                <input type="date" name="date">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="time"> Time: </label>
                            </td>
                            <td>
                                <input type="time" name="time">
                            </td>
                        </tr>  
                        <tr>
                            <td>
                                <label for="detail"> Detail: </label>
                            </td>
                            <td>
                                <textarea rows="4" cols="50" name="detail" placeholder="Event Description">
                                    
                                </textarea>
                            </td>
                        </tr>

                    </tbody>
                    <tfoot>
                        <tr>
                            <td>
                                <input type="reset">
                            </td>
                            <td>
                                <input type="submit" class="float-right" value="Create Event">
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </form>
        </section>
    </body>
</html>
