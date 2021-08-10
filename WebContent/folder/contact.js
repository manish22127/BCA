function contactusvalidate() {
	
	var user=document.getElementById("uservalue").value;
	var email=document.getElementById("mailid").value;
	var web=document.getElementById("comput").value;
	var feedback=document.getElementById("texting").value;
	
	if(user.length==0)
		{
		alert("pls enter the user name");
		document.getElementById("uservalue").focus();
		return false;
		
		}
	
	
	if(email.length==0)
	{
	alert("pls enter the emailid");
	document.getElementById("mailid").focus();
	return false;
	
	}
	if(web.length==0)
	{
	alert("pls enter the website");
	document.getElementById("comput").focus();
	return false;
	
	}
	if(feedback.length==0)
	{
	alert("pls enter the feedback");
	document.getElementById("texting").focus();
	return false;
	
	}


}