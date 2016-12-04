function getEventInfo(id) {
    var request;

    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            document.getElementById("desc").innerHTML = request.responseText;
        }
    };

    request.open("GET", "../getEventInfo?id=" + id, true);
    request.send();
}

function editEventDetails() {
    var id = document.getElementById("id").value;
    var category = document.getElementById("category").value;
    var title = document.getElementById("etitle").value;
    var venue = document.getElementById("venue").value;
    var date = document.getElementById("date").value;
    var time = document.getElementById("time").value;
    var detail = document.getElementById("detail").value;




    var request;
    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if (request.responseText === "1") {
                window.location.assign("http://localhost:8080/Charusat_Events/jsp/updateEventSucess.jsp");
            } else {
                window.location.assign("http://localhost:8080/Charusat_Events/jsp/updateEventFail.html");
            }
        }
    };

    request.open("GET", "../editEvent?id=" + id + "&category=" + category + "&title=" + title + "&venue=" + venue + "&date=" + date + "&time=" + time + "&detail=" + detail, true);
    request.send();
}

function EditEvent(id) {
    document.getElementById("desc").innerHTML = "                <table>\n" +
            "                    <thead>\n" +
            "                        <tr>\n" +
            "                            <th class=\"font-thead\" colspan=\"2\"> Edit Event </th>\n" +
            "                        </tr>\n" +
            "                    </thead>\n" +
            "                    <tbody>\n" +
            "                        <tr>\n" +
            "                            <td>\n" +
            "                                <label for=\"id\"> ID : </label>\n" +
            "                            </td>\n" +
            "                            <td>\n" +
            "                                <input type=\"text\" name=\"id\" id=\"id\" disabled value=" + id + ">\n" +
            "                            </td>\n" +
            "                        </tr>\n" +
            "                        <tr>\n" +
            "                            <td>\n" +
            "                                <label for=\"category\"> Category : </label>\n" +
            "                            </td>\n" +
            "                            <td>\n" +
            "                                <select name=\"category\" id=\"category\">\n" +
            "                                    <option value=\"select\">--- Select Category ---</option>\n" +
            "                                    <option value=\"Sport\"> Sport </option>\n" +
            "                                    <option value=\"tech\"> Technical </option>\n" +
            "                                    <option value=\"nontech\"> Non - Technical </option>\n" +
            "                                    <option value=\"workshop\"> Workshop </option>\n" +
            "                                    <option value=\"lec\"> Seminars/Expert - Lectures </option>\n" +
            "                                </select>\n" +
            "                            </td>\n" +
            "                        </tr>\n" +
            "                        <tr>\n" +
            "                            <td>\n" +
            "                                <label for=\"etitle\"> Title: </label>\n" +
            "                            </td>\n" +
            "                            <td>\n" +
            "                                <input type=\"text\" name=\"etitle\" id=\"etitle\" placeholder=\"Charusat Event\">\n" +
            "                            </td>\n" +
            "                        </tr>\n" +
            "                        <tr>\n" +
            "                            <td>\n" +
            "                                <label for=\"venue\"> Venue: </label>\n" +
            "                            </td>\n" +
            "                            <td>\n" +
            "                                <input type=\"text\" id=\"venue\" name=\"venue\" placeholder=\"CE/IT Seminar Hall\">\n" +
            "                            </td>\n" +
            "                        </tr>\n" +
            "                        <tr>\n" +
            "                            <td>\n" +
            "                                <label for=\"date\"> Date: </label>\n" +
            "                            </td>\n" +
            "                            <td>\n" +
            "                                <input type=\"date\" id=\"date\" name=\"date\">\n" +
            "                            </td>\n" +
            "                        </tr>\n" +
            "                        <tr>\n" +
            "                            <td>\n" +
            "                                <label for=\"time\"> Time: </label>\n" +
            "                            </td>\n" +
            "                            <td>\n" +
            "                                <input type=\"time\" id=\"time\" name=\"time\">\n" +
            "                            </td>\n" +
            "                        </tr>  \n" +
            "                        <tr>\n" +
            "                            <td>\n" +
            "                                <label for=\"detail\"> Detail: </label>\n" +
            "                            </td>\n" +
            "                            <td>\n" +
            "                                <textarea rows=\"4\" cols=\"50\" id=\"detail\" name=\"detail\" placeholder=\"Event Description\">\n" +
            "                                    \n" +
            "                                </textarea>\n" +
            "                            </td>\n" +
            "                        </tr>\n" +
            "\n" +
            "                    </tbody>\n" +
            "                    <tfoot>\n" +
            "                        <tr>\n" +
            "                            <td>\n" +
            "                                <input type=\"reset\">\n" +
            "                            </td>\n" +
            "                            <td>\n" +
            "                                <input type=\"submit\" class=\"float-right\" onclick=\"editEventDetails()\" value=\"Edit Event\">\n" +
            "                            </td>\n" +
            "                        </tr>\n" +
            "                    </tfoot>\n" +
            "                </table>\n";

}

function getRegistration(id) {
    var request;

    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            document.getElementById("desc").innerHTML = request.responseText;
        }
    };

    request.open("GET", "../getRegistration?id=" + id, true);
    request.send();
}

function sendUpdate(id) {
    document.getElementById("desc").innerHTML = " <table>\n" +
            "  <tr>\n" +
            "    <td><label forname=\"subject\">Subject: <label></td>\n" +
            "    <td><input type=\"text\"class=\"width\" id=\"subject\" name=\"subject\" placeholder=\"Subject\"/></td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td><label forname=\"message\">Message: <label></td>\n" +
            "    <td><textarea rows=\"10\" cols=\"40\" id=\"message\" name=\"message\" placeholder=\"message\"></textarea></td>\n" +
            "  </tr>\n" +
            "  <tr>\n" +
            "    <td>  <input type=\"reset\" value=\"Reset\"/></td>\n" +
            "    <td><input type=\"submit\" value=\"Submit\" onclick=\"sendEventUpdate("+id+")\"/></td>\n" +
            "  </tr>\n" +
            "  </table>\n";
}

function sendEventUpdate(id){
    var subject = document.getElementById("subject").value;
    var msg = document.getElementById("message").value;
    var request;

    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if(request.responseText === '1'){
                alert("Update Send Successfully");
            }
            else{
                alert("There is no registration to send Updates"+request.responseTex);
            }
        }
    };

    request.open("GET", "../sendEventUpdate?id="+id+"&subject="+subject+"&message="+msg, true);
    request.send();   
}

function closeDelete(id) {
    document.getElementById("desc").innerHTML = "<center><section id=\"closeDelete\"><h2>Event Close will close the Registration:</h2>\n" +
            " <div class=\"operationalButton\" onclick=\"closeEvent("+id+")\">\n" +
            "    Close Event\n" +
            "  </div><br>\n" +
            "<br><h2>Event Delete will delete the Event:</h2>\n" +
            "    <div class=\"operationalButton\" onclick=\"deleteEvent("+id+")\">\n" +
            "    Delete Event\n" +
            "  </div></section><center>";
}

function closeEvent(id){
    var request;

    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if(request.responseText === '1'){
                alert("Regisatration is Closed");
            }
            else{
                alert("Someting went wrong! Try Again");
            }
        }
    };

    request.open("GET", "../closeEvent?id="+id, true);
    request.send();   
}

function deleteEvent(id){
    var request;

    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if(request.responseText === '1'){
                alert("Event is Deleted");
                window.location.assign("http://localhost:8080/Charusat_Events/jsp/profile.jsp");
            }
            else{
                alert("Someting went wrong! Try Again");
            }
        }
    };

    request.open("GET", "../deleteEvent?id="+id, true);
    request.send();   
}