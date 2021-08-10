<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />

<link href="tooplate_style.css" rel="stylesheet" type="text/css" />

<script type="text/JavaScript" src="js/jquery-1.6.3.js"></script> 

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/ddsmoothmenu.js">


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
    	<a href="index.html" class="sitetitle"></a>        
    </div> <!-- END of header -->
    <div id="tooplate_main_wrapper"><span class="tmw_frame tmw_framet"></span><span class="tmw_frame tmw_frameb"></span>
    	<div id="tooplate_menu" class="ddsmoothmenu">
            <ul>
                <li><a href="index.html" class="selected">Home</a></li>
                <li><a href="Register.jsp">Register</a></li>
                <li><a href="gallery.html">Gallery</a></li>
                <li><a href="about.html">About</a></li>                
                <li class="last"><a href="contact.html" class="last">Contact</a></li>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of tooplate_menu -->

    
        <div align="justify"> 
        <br><br><br>
        
        <center><h1 style="color: green;">Welcome</h1>
         <h2 style="color:maroon;">Login</h2>
          <form action="Login" method="post">
<table >
<tr>
<td>USER NAME:</td>
<td><input type="text" name="user" required size="20"  id="uservalues"/></td>
</tr><br />
<tr>
<td>PASSWORD:</td>
<td><input type="password" name="pass" required size="20" id="passvalues" /></td>
</tr><br><br>


</table><br>
<center><input type="submit"  value="submit" style="margin-left: 100px;" onclick="return loginvalidate()"/>
<input type="reset"  value="reset" /></center>
<br>
<p style="color: blue;">Are you new User?<a href="Register.jsp">Click here</a></p>

</form></center>
        
        
         </div>  
    </div> <!-- END of main wrapper -->
</div> <!-- END of tooplate_wrapper -->

 <!-- END of tooplate_footer_wrapper -->


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