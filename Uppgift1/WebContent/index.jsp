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
	
<!-- 	Form to get executed to next page. -->
	<form action="resultpage.jsp">
	<select name="select-result">
			<option value="1">Kittens</option>
			<option value="2">Meat</option>
	</select>
	<br>
	<p>Input numbers between 50 - 1500 in the fields and click submit:</p>
	<input type="text" name="inputstr1">
	<input type="text" name="inputstr2"> 
	<input type="submit" value="Submit">
	</form>
	

</body>
</html>