function loginvalidate(){

	
	//alert("");
	
	var username=document.getElementById("uservalues").value;
	var password=document.getElementById("passvalues").value;
	
	if(username.length==0)
		{
		
		alert("pls enter your username");
		document.getElementById("uservalues").focus();
		return false;
		}
	
	
	if(password.length==0)
	{
	alert("pls enter your password");
	document.getElementById("passvalues").focus();
	return false;
	}
	
	
}