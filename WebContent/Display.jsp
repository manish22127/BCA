<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>display</title>
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

</head>
<body>

<div id="tooplate_wrapper">
	<div id="tooplate_header">
    	      
    </div> <!-- END of header -->
    <div id="tooplate_main_wrapper"><span class="tmw_frame tmw_framet"></span><span class="tmw_frame tmw_frameb"></span>
    	<div id="tooplate_menu" class="ddsmoothmenu">
            <ul>
                <li><a href="#" class="selected">Display</a></li>
                <li><a href="Inbox.jsp">Inbox</a></li>
                <li><a href="UserImage.jsp">Upload</a></li>
<!--                 <li><a href="about.html">About</a></li>                 -->
<!--                 <li class="last"><a href="contact.html" class="last">Contact</a></li> -->
            	<li><a href="logout.jsp">Logout</a></li>  
            </ul>
            <br style="clear: left" />
        </div> <!-- end of tooplate_menu -->
     <!-- END of slider -->
    <br><br>
    <table width="542" border="0" cellpadding="17" cellspacing="0">
       <tr>
        <td style="color:999999;line-height:1.6em">
        <div align="justify"> 
        
        
        
        
        <%
	
	byte[] b=(byte[])application.getAttribute("img");
    System.out.println("bytes at display "+b);
	String imag=Base64.encode(b);
	//Base64.encode(b)
	String code=(String)application.getAttribute("encryption");
	%>
	 <form action="ImageStegano" method="post" name="form">
	<table align="center">
	<tr>
	<th><h1>Selected Image	</h1></th>
	<th><h1>Enter the message</h1></th>
	</tr>
	<tr>
<%-- 	<td><img src="data:image/jpg;base64,<%=imag%>" alt="image" style="height: 300px; width: 400px;"/></td>
 --%>	
 <td><img src=" imgDisplay?param=display.jsp" alt="image" style="height: 300px; width: 400px;"/></td><td><textarea name="message" rows="19" cols="50" id="mess" required></textarea></td>
	</tr>
	
	</table>
	<br>
	<input type="submit" value="Proceed" style="height: 60px; width: 150px; margin-left: 300px;" onclick="return form()" />
	 </form>


        
        
        
        
        
        
         </div>
        </td>
       </tr>
      </table>
    </div> <!-- END of main wrapper -->
</div> <!-- END of tooplate_wrapper -->


       
        
        
        <div class="clear"></div>
	</div> <!-- END of tooplate_footer -->
</div> <!-- END of tooplate_footer_wrapper -->



<script src="js/scroll-startstop.events.jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		var $elem = $('#content');
		
		$('#nav_up').fadeIn('slow');
		
		$(window).bind('scrollstart', function(){
			$('#nav_up,#nav_down').stop().animate({'opacity':'0.2'});
		});
		$(window).bind('scrollstop', function(){
			$('#nav_up,#nav_down').stop().animate({'opacity':'1'});
		});
		
		$('#nav_up').click(
			function (e) {
				$('html, body').animate({scrollTop: '0px'}, 800);
			}
		);
	});
</script>

</body>
</html>