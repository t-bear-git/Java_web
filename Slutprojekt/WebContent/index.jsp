<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Slutprojekt Skånetrafiken</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/scrolling-nav.css" rel="stylesheet">

</head>
<body id="page-top">

	<!-- Navigation & Header -->
	<jsp:include page="navhead.jsp" />

	<section id="search">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2>Ange Ort, Gata eller Stationsnamn för att lista stationer:</h2>

					<form action="<%=request.getContextPath()%>/ControllerServlet"
						method="get">
						<p>
							Sök station: <input name="inpPointfr" type="text" required />
						</p>

						<input type="submit" value="Sökning" class="btn btn-danger" />
					</form>
				</div>
			</div>
		</div>
	</section>

	


	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom JavaScript for this theme -->
	<script src="js/scrolling-nav.js"></script>

</body>

</html>