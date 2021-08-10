<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Register</title>
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


</script>
<script type="text/javascript" src="Reg_Validation.js">
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
                <li><a href="index.html" class="selected">Home</a></li>
                <li><a href="Userinterface.jsp">Login</a></li>
                <li><a href="gallery.html">Gallery</a></li>
                <li><a href="about.html">About</a></li>                
                <li class="last"><a href="contact.html" class="last">Contact</a></li>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of tooplate_menu -->
  
    </div> <!-- END of slider -->
    <br>
       <div align="justify"> 
        
         <center>
          <h1 style="color: green;">WELCOME</h1>
         <h2 style="color:maroon;">REGISTRATION</h2>
                          <form action="Register" method="post">
  <table>
  <tr>
  <td><p>USERNAME</p></td><td>:</td><td><input type="text" name="Name" required id="users" ></td>
  </tr>
  <tr>
  <span id="userresult"></span>
  </tr>
  <tr>
  <td><p>PASSWORD</p></td><td>:</td><td><input type="password" required name="pwd" id="passing"> </td>
  </tr>
  <tr>
  <td><p>CONFIRM PASSWORD</p></td><td>:</td><td><input type="password" required name="cpwd" id="cpass1" onchange="return Validatecpass()"></td>
  </tr>
  <tr>
  <td><p>EMAIL</p></td><td>:</td><td><input type="email" required name="email" id="email12"></td>
  </tr>
  <tr>
  <td><p>DATE OF BIRTH</p></td><td>:</td><td>
  <select name="Day" required>
  <%for(int i=1;i<=31;i++){ %>
  
  <option value="<%=i%>"><%=i %></option>
  <%} %>
  </select>
  <select name="mm" required>
  <%for(int i=1;i<=12;i++){ %>
  <option <%=i %>><%=i %></option>
  <%} %>
  </select>
  
  <select name="yr" required>
  <%for(int i=1970;i<=2020;i++){ %>
  <option value="<%=i%>"><%=i%></option>
  <%} %>
  </select>  
  </td>
  </tr>
  <tr>
  <td>GENDER</td><td>:</td><td>  male:<input type="radio" name="m1" required id="m" value="male"/>
                  female <input type="radio" name="m1" id="n" required value="female"/>
                    </td>
  </tr>
  <tr>
  <td><p>MOBILE NUM</p></td><td>:</td><td><input type="number" name="phone" id="phone" required id="number" onchange="return ValidateContact()"></td>
  </tr>
  <tr>
  <td>ADDRESS</td><td>:</td><td> <textarea id="text" name="Address" required rows="0" cols="0" class="required" id="addvertise"></textarea></td>
  </tr>
  <tr>
  <td></td><td></td><td><input type="submit" name="submit" id="submit" value="submit" onclick="return registervalidate()"><input type="reset" name="reset" id="reset" value=" Reset ">
  </tr>
  </table>
  
  </form>
        
 </center>       
        
        
         </div>
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