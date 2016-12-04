signout = document.getElementById("signout");
signout.onclick = function(){
    var request;

    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        request = new ActiveXObject("Microsoft.XMLHTTP");
    }

    request.onreadystatechange = function () {
        window.location.assign("http://localhost:8080/Charusat_Events/index.html");
    };

    request.open("GET", "../signout", true);
    request.send();    
};