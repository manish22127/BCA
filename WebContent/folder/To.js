function validateto() {
	
	var recevier=document.getElementById("recid").value;
	var subject=document.getElementById("subid").value;
	
	if(recevier.length==0)
		{
	
		alert("pls enter the receiver name");
		document.getElementById("recid").focus();
		return false;
		}
	
	if(subject.length==0)
		{
		alert("pls enter the subject");
		document.getElementById("subid").focus();
		return false;
		}
	
	
	
}