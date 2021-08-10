function registervalidate() {

	
	var user=document.getElementById("users").value;
	
	var password=document.getElementById("passing").value;
	
	var cpassword=document.getElementById("cpass1").value;
//	alert("");
	var email=document.getElementById("email12").value;
//	alert("");
	var mobile=document.getElementById("number").value;
//	alert("");
	//var address=document.getElementById("add").value;
	alert("");
	if(user.length==0)
		{
		alert("pls enter your name");
		document.getElementById("users").focus();
		return false;
		}
	
	if(password.length=="")
	{
	alert("Please Enter the password");
	document.getElementById("passing").focus();
	return false;
	}
	if(cpassword.length=="")
	{
	alert("Please Enter the confirm password");
	document.getElementById("cpass1").focus();
	return false;
	}
	if(cpassword!=password)
	{
	alert("you password is mismatch");
	document.getElementById("passing").value="";
	document.getElementById("cpass1").value="";
	document.getElementById("passing").focus();
	
	return false;
}
	
	if(email.length=="")
	{
	alert("Pls enter the mail id");
	
	document.getElementById("email12").focus();
	return false;
	}
	
	if(isNaN(mobile))
		{
		alert("pls verify the mobile number ex:1234567890");
		document.getElementById("number").focus();
		document.getElementById("number").value="";
		return false;
		}

	if(mobile.length=="")
	{
	alert("pls enter the mobile number");
	document.getElementById("number").focus();
	return false;
	}

	if(mobile.length<10||mobile.length>=11)
	{
	alert("Number must be 10 digit");
	document.getElementById("number").focus();
	return false;
	}

	
	
}
