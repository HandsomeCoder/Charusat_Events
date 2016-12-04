function getBasic(){
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

    request.open("GET", "../getBasic", true);
    request.send();
}

function getSecurityInfo(){
    document.getElementById("desc").innerHTML = '<center><h1>Account Security</h1>'
                +'<form>'
                +    '<table>'
                +        '<tr>'
                +            '<td><label for="opass">Old Password: </label></td>'
                +            '<td><input type="password" name="opass" id="opass" placeholder="Old Password"></td>'
                +        '</tr>'
                +        '<tr>'
                +            '<td><label for="npass">New Password: </label></td>'
                +            '<td><input type="password" name="npass" id="npass" placeholder="New Password"></td>'
                +        '</tr>'
                +        '<tr>'
                +            '<td><label for="cpass">Confirm New Password: </label></td>'
                +            '<td><input type="password" name="cpass" id="cpass" placeholder="Confirm New Password"></td>'
                +        '</tr>'                        
                +         '<tr>'
                +            '<td><input type="reset"></td>'
                +            '<td><input id="changepass" type="button" value="Change Password" onclick="updatePass()"></td>'
                +        '</tr>'                        
                +    '</table>'
                +'</form><center>';

}

function validate(){
    var opass = document.getElementById("opass");
    var npass = document.getElementById("npass");
    var cpass = document.getElementById("cpass");
    
    opass.classList.remove("invalid");
    npass.classList.remove("invalid");
    cpass.classList.remove("invalid");

    if(opass.value === ""){
        alert("All Fields are mandatory");
        opass.classList.add("invalid");
        return false;
    }else{
        if(opass.value.length >= 4 && opass.value.length <= 15){}
        else{
            alert("Password lenght should be betweem 4 to 15 Charaters");
            return false;
        }
    }
    
    if(npass.value === ""){
        alert("All Fields are mandatory");
        npass.classList.add("invalid");
        return false;
    }else{
        if(npass.value.length >= 4 && npass.value.length <= 15){}
        else{
            alert("Password lenght should be betweem 4 to 15 Charaters");
            return false;
        }  
    }
    
    if(cpass.value === ""){
        alert("All Fields are mandatory");
        cpass.classList.add("invalid");
        return false;
    }else{
        if(cpass.value.length >= 4 && cpass.value.length <= 15){}
        else{
            alert("Password lenght should be betweem 4 to 15 Charaters");
            return false;
        }          
    }
    
    if(npass.value !== cpass.value){
        alert("Password and Confirm Password Should be same");
        return false;
    }
    return true;
}

function updatePass(){
    if(validate()){
        var request;
        var opass = document.getElementById("opass").value;
        var npass = document.getElementById("npass").value;
        if (window.XMLHttpRequest) {
            request = new XMLHttpRequest();
        }
        else if (window.ActiveXObject) {
            request = new ActiveXObject("Microsoft.XMLHTTP");
        }

        request.onreadystatechange = function () {
            if (request.readyState === 4) {
                alert(request.responseText);
            }
        };
        request.open("GET", "../changePassword?opass="+opass+"&npass="+npass, true);
        request.send();
    }
}

function getMyEvents(){
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
    request.open("GET", "../myEvents", true);
    request.send();
}

function getRegistry(){
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
    request.open("GET", "../myEventsRegistry", true);
    request.send();  
}

function editProfile(){
    var enrol = document.getElementById("enrol").innerHTML;
    var email = document.getElementById("email").innerHTML;
    console.log(email);
    window.location.assign("http://localhost:8080/Charusat_Events/jsp/EditProfile.jsp?enrol="+enrol+"&email="+email);
}

function manage(id){
    window.location.assign("http://localhost:8080/Charusat_Events/jsp/manageEvent.jsp?id="+id);
}