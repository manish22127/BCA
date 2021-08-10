function  filevalidate() {
	
	var file=document.getElementById("filevalues").value;
	
	var exe=file.split(".").pop();
//	alert("the file extension"+exe);
	if(file.length=="")
		{
		alert("Pls Upload the image");
		document.getElementById("filevalues").focus();
		return false;
		}
	
	  if ( exe == 'jpg' || exe == 'jpeg'||exe=='png')

		{
		return true;
		}
	  else
		  {
		  alert("you can choose only jpg,jpeg or png images");
			document.getElementById("filevalues").value="";
			return false;
		  }
	
	
}