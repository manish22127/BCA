function validatehash() {
	
	var hash=document.getElementById("hashvalue").value;
	
	if(hash.length==0)
		{
		alert("pls enter the hash value");
		document.getElementById("hashvalue").focus();
		return false;
		
		
		}
	
	
	
}