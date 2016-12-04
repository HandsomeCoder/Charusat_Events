/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var selectAssociatedClg = {
    'Branch': {
        select: {
            text: ['Select Institute First'],
            value: ['select']
        },
        CSPIT: {
            text: ['BTech(IT)', 'BTech(CE)', 'BTech(CL)', 'BTech(ME)', 'BTech(EE)', 'BTech(EC)', 'MTech(IT)', 'MTech(CE)', 'MTech(CL)', 'MTech(ME)', 'MTech(EE)', 'MTech(EC)'],
            value: ['BTech(IT)', 'BTech(CE)', 'BTech(CL)', 'BTech(ME)', 'BTech(EE)', 'BTech(EC)', 'MTech(IT)', 'MTech(CE)', 'MTech(CL)', 'MTech(ME)', 'MTech(EE)', 'MTech(EC)']

        },
        CMPICA: {
            text: ['BCA', 'DRMCA', 'MSC(IT)', 'MCA', 'MCAL'],
            value: ['BCA', 'DRMCA', 'MSC(IT)', 'MCA', 'MCAL']
        },
        RPCP: {
            text: ['B.PHARM', 'CPCT', 'CPPT', 'DRPC', 'DRPHC', 'M.PHARM(CT)', 'M.PHARM(DRA)', 'M.PHARM(CP)'],
            value: ['B.PHARM', 'CPCT', 'CPPT', 'DRPC', 'DRPHC', 'M.PHARM(CT)', 'M.PHARM(DRA)', 'M.PHARM(CP)']
        },
        IIIM: {
            text: ['BBA', 'DRMBA', 'MBA-CH', 'PGDM'],
            value: ['BBA', 'DRMBA', 'MBA-CH', 'PGDM']
        },
        PDPAIS: {
            text: ['B.SC', 'BSCPHY', 'M.PHIL', 'MSC(AOC)', 'MSC(BC)', 'MSC(BT)', 'MSC(MI)', 'MSC(NST)', 'MSC(PHY)'],
            value: ['B.SC', 'BSCPHY', 'M.PHIL', 'MSC(AOC)', 'MSC(BC)', 'MSC(BT)', 'MSC(MI)', 'MSC(NST)', 'MSC(PHY)']
        },
        ARIP: {
            text: ['BPT', 'DRPT', 'MPT(CS)', 'MPT(CS)', 'MPT(MS)', 'MPT(NS)', 'MPT(PA)', 'MPT(RE)', 'MPT(SS)', 'MPT(WH)'],
            value: ['BPT', 'DRPT', 'MPT(CS)', 'MPT(CS)', 'MPT(MS)', 'MPT(NS)', 'MPT(PA)', 'MPT(RE)', 'MPT(SS)', 'MPT(WH)']
        },
        MTIN: {
            text: ['BSC.NURSING', 'DNR', 'GNM', 'MNCH', 'MNCH', 'MNMH', 'MNMS', 'MNOG', 'MNPN'],
            value: ['BSC.NURSING', 'DNR', 'GNM', 'MNCH', 'MNCH', 'MNMH', 'MNMS', 'MNOG', 'MNPN']
        },
        CIPS: {
            text: ['BMIT', 'BOTAT', 'PGDCH', 'PGDHAT', 'PGDMLT'],
            value: ['BMIT', 'BOTAT', 'PGDCH', 'PGDHAT', 'PGDMLT']
        }
    }
};

function removeAllOptions(sel, removeGrp) {
    var len, groups, par;
    if (removeGrp) {
        groups = sel.getElementsByTagName('optgroup');
        len = groups.length;
        for (i = len; i; i--) {
            sel.removeChild(groups[i - 1]);
        }
    }

    len = sel.options.length;
    for (i = len; i; i--) {
        par = sel.options[i - 1].parentNode;
        par.removeChild(sel.options[i - 1]);
    }
}

function appendDataToSelect(sel, obj) {
    var f = document.createDocumentFragment();
    var labels = [], group, opts;

    function addOptions(obj) {
        var f = document.createDocumentFragment();
        var o;

        for (var i = 0, len = obj.text.length; i < len; i++) {
            o = document.createElement('option');
            o.appendChild(document.createTextNode(obj.text[i]));

            if (obj.value) {
                o.value = obj.value[i];
            }

            f.appendChild(o);
        }
        return f;
    }

    if (obj.text) {
        opts = addOptions(obj);
        f.appendChild(opts);
    } else {
        for (var prop in obj) {
            if (obj.hasOwnProperty(prop)) {
                labels.push(prop);
            }
        }

        for (var i = 0, len = labels.length; i < len; i++) {
            group = document.createElement('optgroup');
            group.label = labels[i];
            f.appendChild(group);
            opts = addOptions(obj[ labels[i] ]);
            group.appendChild(opts);
        }
    }
    sel.appendChild(f);
}

document.getElementById("Institute").onchange = function (e) {
    var relName = 'Branch';

    var relList = document.getElementById(relName);

    var obj = selectAssociatedClg[ relName ][ this.value ];

    console.log(obj);

    removeAllOptions(relList, true);

    appendDataToSelect(relList, obj);
};

(function () {

    var sel = document.getElementById("Institute");
    sel.selectedIndex = 0;

    var relName = 'Branch';
    var rel = document.getElementById(relName);
    var data = selectAssociatedClg[ relName ][ sel.value ];
    appendDataToSelect(rel, data);

}());

function validation(){
    var enrol  = document.getElementById("EnrolNo");
    var fname  = document.getElementById("Fname"); 
    var mname  = document.getElementById("Mname");
    var lname  = document.getElementById("Lname");
    var dob  = document.getElementById("Dob");
    var inst  = document.getElementById("Institute");
    var branch  = document.getElementById("Branch");
    var email  = document.getElementById("Email");
    var password  = document.getElementById("Password");
    var cpassword  = document.getElementById("Cpassword");
    var check = true;
    
    enrol.classList.remove("invalid");
    fname.classList.remove("invalid");
    mname.classList.remove("invalid");
    lname.classList.remove("invalid");
    dob.classList.remove("invalid");
    inst.classList.remove("invalid");
    branch.classList.remove("invalid");
    email.classList.remove("invalid");
    password.classList.remove("invalid");
    cpassword.classList.remove("invalid");
    
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
    if(password.value === ""){
    //    alert("");
        password.classList.add("invalid");
        check = false;
    }
    if(cpassword.value === ""){
    //    alert("");
        cpassword.classList.add("invalid");
        check = false;
    }
    if(!check){
        alert("All Fields are mandatory, can't be empty");

        return false;
    }
    if(email.value.split("@")[1] === "charusat.edu.in" || email.value.split("@")[1] === "charusat.ac.in"){}
    else{
        alert("Invalid Email ID!\nYou have to enter college Email ID");        
        email.classList.add("invalid");
        return false;
    }
    if(email.value.split("@")[0] !== enrol.value){
        alert("Your Email ID doesn't match with your Enrolment Number");
        email.classList.add("invalid");
        enrol.classList.add("invalid");
        return false;
    }
    if(password.value.length >= 4 && password.value.length <= 15){}
    else{
        alert("Password lenght should be betweem 4 to 15 Charaters");
        password.classList.add("invalid");  
        cpassword.classList.add("invalid");
        return false;
    }
    if(password.value !== cpassword.value){
        alert("Password and Confirm Password Should be same");
        password.classList.add("invalid");  
        cpassword.classList.add("invalid");
        return false;
    }
    return true;
}
