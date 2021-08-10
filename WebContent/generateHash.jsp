<%@page import="Steganography.Steganography"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%
            response.setContentType("text/xml");
			String k=request.getParameter("k");
			String mat=request.getParameter("mat");
			String hash_Val="";
			if(k==null)
			{
				hash_Val=(String)session.getAttribute("hash_Val");
			}
			else
			{
				hash_Val=(String)session.getAttribute("verfy");
			}
			if(mat!=null)
			{
				String match=(String)session.getAttribute("hiddMes");
				String stega=new Steganography().decode(match);
				%>
				
				<h2 style="color:white;">The Secret message/data is:&nbsp;&nbsp; " <%=stega %> "</h2>
<!-- 				<center><textarea rows="19" cols="50" readonly="readonly"></textarea></center> -->
				<%
			}
			else
			{
            
%>
<h3>Hash Value Successfully Generated...</h3>
<%-- <h3 style="color: blue;"><%=hash_Val %></h3> --%>

<%if(k==null)
	{
%>
	<h3 style="color: orange;">Click here to create patch images ... <a onclick="return myFunction()">click</a></h3>
<%
	}
else
{%>

	<h3 style="color: lime;">verify hash value...!</h3>
	<html>
	<body>
	<form action="match" method="post">
	<input type="text" name="mat" autocomplete="off" />
	<input type="submit" value="Match" />
	</form>
	</body>
	</html>
<%}}
%>
