<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Uppgift 1</title>
</head>
<body>
<!-- 	include Header + Footer  -->
	<jsp:include page="inclHead.jsp" />
	<%
	// Variables to get form inputs.
	String field1 = request.getParameter("inputstr1");
	String field2 = request.getParameter("inputstr2");
	// Variables to handle input and select form elements.
	String urlVar = field1 + "/" + field2;
	int selection = Integer.parseInt(request.getParameter("select-result"));
	// If statement to show correct content.
	if (selection == 1) {
		out.print("<h2> Kitten it is! </h2>");
		out.print("<img src='http://placekitten.com/" + urlVar + "'>");
	} else if (selection == 2) {
		out.print("<h2> Meat it is! </h2>");
		out.print("<img src='https://baconmockup.com/" + urlVar + "'>");
	}
	%>
	
</body>
</html>