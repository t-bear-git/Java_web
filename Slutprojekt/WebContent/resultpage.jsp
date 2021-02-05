<%@page import="skanetrafikenAPI.ParseXML"%>
<%@page import="skanetrafikenAPI.Station"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Slutprojekt Skånetrafiken</title>
</head>
<body>
	<%--Assigning ArrayList object containing Station data to the local object --%>
	<%
	ArrayList<Station> stationResults = (ArrayList<Station>) request.getAttribute("FoundStations");
	%>
	<!-- Navigation & Header -->
	<jsp:include page="navhead.jsp" />
	
	 <section id="result">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 mx-auto">
            <h2>Resultat</h2>
            <table class="table table-bordered">
  		<thead>
    		<tr>
		      <th scope="col">Stationsnamn</th>
		      <th scope="col">Stations ID</th>
		      <th scope="col">Latitud (RT-90)</th>
		      <th scope="col">Longitud (RT-90)</th>
    		</tr>
  		</thead>
  		<tbody>
	<%
	if (request.getAttribute("FoundStations") != null) // Check if object is not null
	{
		Iterator<Station> iterator = stationResults.iterator(); // Iterator interface

		while (iterator.hasNext()) // iterate through all the items in the object
		{
			Station stationDetails = iterator.next(); //assign individual item data to the station class object
	%>
	<tr> 
		<td><%=stationDetails.getStationName()%></td>
		<td><%=stationDetails.getStationNbr()%></td>
		<td><%=stationDetails.getLatitude()%></td>
		<td><%=stationDetails.getLongitude()%></td>
	</tr>
	<%
	}
	}
	%>
	</tbody>
	</table>
          </div>
        </div>
      </div>
    </section>
	
</body>
</html>