function ValidateFirstName() {
var fname=document.getElementById("fname");
var letters = /^[A-Za-z]+$/; 

//alert(passw);
if(fname.value=="")
{
	alert("Enter Your Name");
	document.getElementById("fname").focus();
	return false;
}
if(!fname.value.match(letters))
{
    alert("Numeric Values not Allowed in Name field");
    document.getElementById("fname").focus();
    return false;
}
/*if(fname.length>15){
	
	alert("Not More Than 15 Characters");
	document.getElementById("fname").focus();
	return false;
}
else if(fname.length<15){
	//alert("user name is wrong");
	document.getElementById("lname").focus();
	return false;
}*/
}


function ValidateLastName() {
	var letters = /^[A-Za-z]+$/; 
	var lname=document.getElementById("lname");

	//alert(passw);

	if(lname.value=="")
	{
		alert("Enter Your Name");
		document.getElementById("lname").focus();
		return false;
	}
	if(!lname.value.match(letters))
	{
	    alert("Numeric Values not Allowed in Name field");
	    document.getElementById("lname").focus();
	    return false;
	}
	}


function Validatepass() {
	var pass=document.getElementById("pass").value;

	//alert(passw);

	if(pass.length<6||pass.length>10){
		alert("Type between 6-10 Characters");
		document.getElementById("pass").focus();
		return false;
	}
	
	}


function Validatecpass() {
	var cpass=document.getElementById("cpass1");

	//alert(passw);

	/*if(cpass.length<6||cpass.length>10){
		alert("Type between 6-10 Characters");
		document.getElementById("cpass").focus();
		return false;
	}*/
	if(cpass.value!=passing.value){
		alert("Password should be same");
		document.getElementById("cpass1").value='';
		document.getElementById("cpass1").focus();
		return false;
	}
	
	}

function ValidateContact() {
	var numbers = /^[0-9]+$/; 
	var con=document.getElementById("phone");

	//alert(passw);

	if(con.value=="")
	{
		alert("Enter Your Contact No");
		document.getElementById("phone").focus();
		return false;
	}
	 if(!con.value.match(numbers))
	{
	    alert("Letters not Allowed in contact field");
	    document.getElementById("phone").focus();
	    return false;
	}
	 if(con.value.length!=10)
		{
		    alert("Enter 10 Digit No");
		    document.getElementById("phone").focus();
		    return false;
		}
	
	}

function ValidateAddress() {
	
	var add=document.getElementById("addr");

	//alert(passw);

	if(add.value=="")
	{
		alert("Enter Your Address");
		document.getElementById("add").focus();
		return false;
	}
	
	}
/*function validatepass() {
var passw=document.getElementById("passw").value;
if(passw.length==0){
	alert("enter the password");
	document.getElementById("passw").focus();
	return false;
}
else if(passw.length==0){
	alert("enter the password");
	document.getElementById("passw").focus();
	return false;
}

}*/