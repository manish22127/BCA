<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>stegno</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<!--
Template 2063 Wide Mode
http://www.tooplate.com/view/2063-wide-mode
-->
<link href="tooplate_style.css" rel="stylesheet" type="text/css" />

<script type="text/JavaScript" src="js/jquery-1.6.3.js"></script> 

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "tooplate_menu", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>

<link rel="stylesheet" href="css/slimbox2.css" type="text/css" media="screen" /> 
<script type="text/JavaScript" src="js/slimbox2.js"></script> 

<link rel="stylesheet" href="css/nivo-slider.css" type="text/css" media="screen" />

<script type="text/javascript">


function fun()
{
	var a;
	 var url="generateHash.jsp";
    if (window.XMLHttpRequest)
    {
    	element = document.getElementById('anc');
    	element.style.display = "none";
      a=new XMLHttpRequest();
    }
   else
    {//If browser is IE6, IE5
      a=new ActiveXObject("Microsoft.XMLHTTP");
    }
 
a.onreadystatechange=function()
{
  if (a.readyState==4 && a.status==200)
  {
	  var store=a.responseText;
    document.getElementById("mi").innerHTML=store;
   }
}
 
a.open("POST",url,true);
a.send();
}

</script>

</head>
<body>

<div id="tooplate_wrapper">
	<div id="tooplate_header">
    	        
    </div> <!-- END of header -->
    <div id="tooplate_main_wrapper"><span class="tmw_frame tmw_framet"></span><span class="tmw_frame tmw_frameb"></span>
    	<div id="tooplate_menu" class="ddsmoothmenu">
            <ul>
                <li><a href="#" class="selected">Hidden Data</a></li>
                <li><a href="Inbox.jsp">Inbox</a></li>
                <li><a href="UserImage.jsp">Upload</a></li>
<!--                 <li><a href="about.html">About</a></li>                 -->
<!--                 <li class="last"><a href="contact.html" class="last">Contact</a></li> -->
            	<li><a href="logout.jsp">Logout</a></li>  
            </ul>
            <br style="clear: left" />
        </div> <!-- end of tooplate_menu -->
   
    </div> <!-- END of slider -->
   <center> <table width="542" border="0" cellpadding="17" cellspacing="0">
       <tr>
        <td style="color:999999;line-height:1.6em">
        <div align="justify"> 
        
        
        
        
        
        
        
  
<%
byte[] b1=(byte[])application.getAttribute("img");
System.out.println("bytes at display "+b1);
String imag1=Base64.encode(b1);
	
	byte[] b=(byte[])session.getAttribute("byte");
    System.out.println("bytes at display "+b);
	String imag=Base64.encode(b);
	%>
	
	 <center>
	 <h1>Generate Hash Key For Image</h1><br/>
	 <img src="data:image/jpg;base64,<%=imag1 %>" alt="image" style="height: 300px; width: 400px;"/><br/>
	 <h2><a id="anc" onclick="fun()">click here to Generate Hash key</a></h2>
	 <div id="mi"></div>
	 </center>
  
  
        
         </div>
        </td>
       </tr>
      </table>   </center>
      <script>
function myFunction()
{
	var name=prompt("Plz Enter 2 to 10 range","");
	

 	if ((name<2))
  	{
      	alert("Plz Enter 2 to 10 range");
  	}
  	else if((name>10))
    {
       alert("Plz Enter 2 to 10 range");
    }
 	else
 	{
 		window.location.href="ImgeSplit?split="+name;
 	}
}
</script>
<script type='text/javascript' src='js/logging.js'></script>
    </div> <!-- END of main wrapper -->
</div> <!-- END of tooplate_wrapper -->



</body>
</html>