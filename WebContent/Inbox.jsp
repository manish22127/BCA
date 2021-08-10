<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>inbox</title>
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

<%
String userName=(String)session.getAttribute("pname");
%>
<%-- <h1>Welcome <%= userName%></h1> --%>
<div id="tooplate_wrapper">
	<div id="tooplate_header">
    	
    </div> <!-- END of header -->
    <div id="tooplate_main_wrapper"><span class="tmw_frame tmw_framet"></span><span class="tmw_frame tmw_frameb"></span>
    	<div id="tooplate_menu" class="ddsmoothmenu">
            <ul>
                <li><a href="#" class="selected">Inbox</a></li>
                <li><a href="UserImage.jsp">Upload</a></li>
<!--                 <li><a href="gallery.html">Gallery</a></li> -->
<!--                 <li><a href="about.html">About</a></li>                -->
<!--                 <li class="last"><a href="contact.html" class="last">Contact</a></li> -->
                <li><a href="logout.jsp">Logout</a></li> 
                 <li><a href="#">Welcome:<%= userName%></a>
                 </ul>
            <br style="clear: left" />
        </div> <!-- end of tooplate_menu -->
    <div id="tooplate_slider">
    	<div class="slider-wrapper theme-default">
            <div id="slider" class="nivoSlider">
                <img src="images/slider/01.jpg" alt="" title="#caption1" />
                <img src="images/slider/02.jpg" alt="" title="#caption2" />
                 <img src="images/slider/01.jpg" alt="" title="#caption1" />
                <img src="images/slider/03.jpg" alt="" title="#caption3" />                
            </div>
           
        </div>
        <script type="text/javascript" src="js/jquery-1.6.3.min.js"></script>
		<script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
        <script type="text/javascript">
        $(window).load(function() {
            $('#slider').nivoSlider({
			effect: 'fade',
			controlNav: true, // 1,2,3... navigation
			directionNavHide: false,
            directionNav: true,
			animSpeed: 800, // Slide transition speed
	        pauseTime: 4000, // How long each slide will show
			});
        });
        </script>	
    </div> <!-- END of slider -->
   
    <center> <table width="542" border="0" cellpadding="17" cellspacing="0">
    
       <tr>
       
        <td style="color:999999;line-height:1.6em">
    <div align="justify"> 
        
        <br><br>
        
        <table align="center" border="2">
       
        <center> <h1 style="color: blue">Inbox</h1></center>
            <tr>
            <th style="width: 136px; text-align: left; ">Sender</th>
            <th style="width: 136px; text-align: left; ">Subject</th>            
            <th style="width: 134px; text-align: left; ">Message</th>
            
            
            </tr>
    
        
               
  
    <%
           String ss=(String)session.getAttribute("pname");
			System.out.println(ss);
			
			//System.out.println("Hi Mono");
            %>
            <%
        int i=0;
        Connection con;
        Statement st;
        /* String text="";
        String keys=""; */
        byte[] file=null;
        String from="";
        String message="";
        String to="";
        String subject="";
        List li=new ArrayList();
        ServletContext context=getServletContext();
        String encrypt=(String)application.getAttribute("encryption");
        System.out.print("inbox message"+encrypt);

        try
                {
        	Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root","root");
            st=con.createStatement();
         /*    ResultSet rs=st.executeQuery("select * from compose where to1='"+ss+"'"); */
            ResultSet rs=st.executeQuery("select * from composeImage where rec='"+ss+"'");
           
            if(rs.next())
                {
                /* text=rs.getString(1).toString().trim();
                keys=rs.getString(2).toString().trim(); */
                file=rs.getBytes(2);
                from=rs.getString(3).toString().trim();
               	session.setAttribute("filInbox", file);
                subject=rs.getString(4).toString().trim();
              
              %>
              <tr>
         			<td style="width: 143px; "><%=from %></td>
         			<td style="width: 141px; "><a href="Details.jsp?from=<%=from%>&sub=<%=subject%>"><%=subject %></a></td>
                    <%-- <td><%=t%></td> --%>
                    <%-- <td><%=m%></td> --%>
                    <td><a href="Details.jsp?from=<%=from%>&sub=<%=subject%>"><img src="images/tag.png" width="30" height="30"/></a></td>
                    </tr>
              <%
                
            }
            st=con.createStatement();
            st.executeUpdate("delete from composeImage where rec='"+ss+"'");


        }
        catch(Exception e)
                {
            e.printStackTrace();
            }
        

   	%> 
           </table> 
        
        
        
        
        
        
        
        
        
        
         </div>
          </td>
       </tr>
      </table></center>
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