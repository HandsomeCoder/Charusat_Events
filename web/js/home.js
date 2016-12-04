var createEventBtn = document.getElementById("createEvent");
createEventBtn.onclick = function () {
    var request;

    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            document.getElementById("eventTitle").innerHTML = request.responseText;
        }
    };

    request.open("GET", "../getData", true);
    request.send();
};

function getTitle(category) {
    document.getElementById("eventDesc").innerHTML = "";
    var request;

    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            document.getElementById("eventTitle").innerHTML = request.responseText;
            document.getElementById("eventInfo").style.visibility = "visible";
        }
    };

    request.open("GET", "../getData?category="+category, true);
    request.send();
}

function getDetail(id) {
    var request;

    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            document.getElementById("eventDesc").innerHTML = request.responseText;
         }
    };

    request.open("GET", "../getDetail?id="+id, true);
    request.send();
}

function registar(id,enrol){
    var request;

    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if(request.responseText == 1){
                alert("You have been registered.");
            }
            else if(request.responseText == 2){
                alert("You have alreay registered");
            }
            else{
                alert(request.responseTextS);              
            }
        }
    };

    request.open("GET", "../registar?id="+id+"&EnrolNo="+enrol, true);
    request.send();
}

function deactive(){
    alert("Registration is Closed");
}