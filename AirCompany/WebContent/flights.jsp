<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome/css/font-awesome.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="css/prettyPhoto.css">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900,300'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/modernizr.custom.js"></script>
<title>Susanoo</title>

</head>
<body>
	<nav id="menu" class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp"><i class="fa fa-sun-o"></i>
					Susanoo<strong></strong></a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href=<c:url value="/index"/> class="page-scroll">${employee.getFullName()}</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="head-image"></div>
	<table class="table table-hover table-inverse">
		<thead>
			<tr>
				<th>#</th>
				<th>Departure Point</th>
				<th>Destination Point</th>
				<th>Departure Date</th>
				<th>Crew</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="flights" items="${flights}">
				<tr>
					<th scope="row">${flights.getId()}</th>
					<td>${flights.getDeparturePoint()}</td>
					<td>${flights.getDestinationPoint()}</td>
					<td>${flights.getDepartureDate()}</td>
					<td>
						<button class="btn btn-primary" type="button"
							data-toggle="collapse"
							data-target="#collapseButton${flights.getId()}"
							aria-expanded="false"
							aria-controls="collapseButton${flights.getId()}">View
							crew</button>
						<div class="collapse" id="collapseButton${flights.getId()}">
							<div class="card card-body">
								<table class="table">
									<tbody>
										<c:forEach var="crew" items="${flights.getCrew()}">
											<tr>
												<td>${crew.getFullName()}</td>
												<td>${crew.getPosition()}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.1.11.1.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/SmoothScroll.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.counterup.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/waypoints.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.prettyPhoto.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery.isotope.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jqBootstrapValidation.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/contact_me.js"></script>

	<!-- Javascripts
    ================================================== -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/main.js"></script>

</body>
</html>