<html>
<head>
<link rel="stylesheet" href="css/log.css" type="text/css" media="all" />


<script src="css/js/jquery-1.7.1.min.js"></script>
	<script src="css/js/jquery.reveal.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			 	$('#modal').reveal({ // The item which will be opened with reveal
				  	animation: 'fade',                   // fade, fadeAndPop, none
					animationspeed: 700,                       // how fast animtions are
					closeonbackgroundclick: true,              // if you click background will modal close?
					dismissmodalclass: 'close'    // the class of a button or element that will close an open modal
				});
			return false;
		});
		
		
		
	</script>


</head>
<%
	session.invalidate();
response.sendRedirect("index.html");
 %>

</html>

