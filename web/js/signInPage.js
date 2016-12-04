function validation(){
    var enrol  = document.getElementById("EnrolNo");
    var password  = document.getElementById("Password");

    var check = true;
    
    enrol.classList.remove("invalid");
    password.classList.remove("invalid");
    
    if(enrol.value === ""){
        enrol.classList.add("invalid");
        check = false;
    }
    if(password.value === ""){
    //    alert("");
        password.classList.add("invalid");
        check = false;
    }
    if(!check){
        alert("All Fields are mandatory, can't be empty");

        return false;
    }
    if(password.value.length >= 4 && password.value.length <= 15){}
    else{
        alert("Password lenght should be betweem 4 to 15 Charaters");
        password.classList.add("invalid");  
        cpassword.classList.add("invalid");
        return false;
    }
    return true;
}
