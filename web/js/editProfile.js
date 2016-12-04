function validate(){
    var enrol  = document.getElementById("EnrolNo");
    var fname  = document.getElementById("Fname"); 
    var mname  = document.getElementById("Mname");
    var lname  = document.getElementById("Lname");
    var dob  = document.getElementById("Dob");
    var inst  = document.getElementById("Institute");
    var branch  = document.getElementById("Branch");
    var email  = document.getElementById("Email");
    var check = true;
    
    enrol.classList.remove("invalid");
    fname.classList.remove("invalid");
    mname.classList.remove("invalid");
    lname.classList.remove("invalid");
    dob.classList.remove("invalid");
    inst.classList.remove("invalid");
    branch.classList.remove("invalid");
    email.classList.remove("invalid");
    
    if(enrol.value === ""){
        enrol.classList.add("invalid");
        check = false;
    }
    if(fname.value === ""){
    //    alert("");
        fname.classList.add("invalid");
        check = false;
    }
    if(mname.value === ""){
    //    alert("");
        mname.classList.add("invalid");
        check = false;
    }
    if(lname.value === ""){
    //    alert("");
        lname.classList.add("invalid");
        check = false;
    }
    if(dob.value === ""){
    //    alert("");
        dob.classList.add("invalid");
        check = false;
    }
    if(inst.value === "select"){
    //    alert("");
        inst.classList.add("invalid");
        check = false;
    }
    if(branch.value === "select"){
    //    alert("");
        branch.classList.add("invalid");
        check = false;
    }
    if(email.value === ""){
    //    alert("");
        email.classList.add("invalid");
        check = false;
    }
    if(!check){
        alert("All Fields are mandatory, can't be empty");

        return false;
    }
    return true;
}


