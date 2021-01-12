<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
html {
	height: 100%;
}

body {
	min-height: 90%;
	position: relative;
	padding-bottom: 80px;
}

h1 {
	margin: 0;
}

#header {
	position: relative;
	top: 0;
	width: 100%;
	height: 3.5rem;
	text-align: center;
	background-color: lightblue;
	margin-bottom: 10px;
}

h2 {
	margin: 0;
}

img {
	display: block;
	margin: auto;
	min-height: 100%;
	padding-bottom: 10px;
}

#footer {
	position: absolute; bottom : 0;
	width: 100%;
	height: 50px;
	text-align: center;
	background-color: gray;
	margin: auto;
	margin-top: -50px;
	display: block;
	bottom: 0;
}
</style>
</head>
<body>
<!-- 	html elements to get included in other JSP´s -->
	<header id="header">
		<h1>Header</h1>
	</header>
	<footer id="footer">
		<h2>Footer</h2>
	</footer>
</body>
</html>