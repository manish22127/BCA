<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%>
<%@page import="Database.conn"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>patch images</title>
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
                <li><a href="#" class="selected">Patch Images</a></li>
                <li><a href="Inbox.jsp">Inbox</a></li>
                <li><a href="UserImage">Upload</a></li>
<!--                 <li><a href="about.html">About</a></li>                 -->
<!--                 <li class="last"><a href="contact.html" class="last">Contact</a></li> -->
            	<li><a href="logout.jsp">Logout</a></li>  
            </ul>
            <br style="clear: left" />
        </div> <!-- end of tooplate_menu -->
   
    </div> <!-- END of slider -->
   <center> <table width="562" border="0" cellpadding="17" cellspacing="0">
       <tr>
       <h1>Patch Images with sparse encoded data</h1>
       <h2 style="color: silver">Select any one Patch Image as Cover Image</h2>
        <td style="color:999999;line-height:5.6em; ">
        <div align="justify"> 
        
        
        
        
        
        	<%
        	
	conn co=new conn();
	try
	{
		String hash_Val=(String)session.getAttribute("hash_Val");
		Statement ste=co.conn().createStatement();
		ResultSet rs1=ste.executeQuery("select * from HashImage where hash='"+hash_Val+"'");
		int i=1;
		while(rs1.next())
       	{
     		byte[] b1=rs1.getBytes(2);
     	    System.out.println("bytes at display "+b1);
     		String imag=Base64.encode(b1);
     		byte[] b=(byte[])session.getAttribute("byte");
     	    System.out.println("bytes at display "+b);
     		String imag1=Base64.encode(b1);
     	%>
	
	<a href="selected_Image?SIm=<%=i%>"><img src="data:image/jpg;base64,<%=imag1%>" alt="image" style="height: 100px; width: 250px;"/></a>
	
	<%
	i++;
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	

	%>

        
        
        
        
        
        
        
        
         </div>
        </td>
       </tr>
      </table> </center>   
    </div> <!-- END of main wrapper -->
</div> <!-- END of tooplate_wrapper -->


        <div class="clear"></div>
	</div> <!-- END of tooplate_footer -->
</div> <!-- END of tooplate_footer_wrapper -->

<div id="tooplate_copyright_wrapper">
    <div id="tooplate_copyright">
        Copyright ©Your Company Name 
    	| Design: <a href=""></a>
    </div>
</div>

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