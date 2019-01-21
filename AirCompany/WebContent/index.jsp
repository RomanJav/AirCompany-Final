<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Susanoo</title>
<meta name="description" content="">
<meta name="author" content="">


<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/fonts/font-awesome/css/font-awesome.css">



<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900,300'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300'
	rel='stylesheet' type='text/css'>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/modernizr.custom.js"></script>

</head>
<body>
	<!-- Navigation
    ==========================================-->
	<nav id="menu" class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
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

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#home" class="page-scroll">Home</a></li>
					<c:choose>
						<c:when test="${employee.getFullName()==null}">
							<li><a href="#contact-section" class="page-scroll">Log
									In</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="#contact-section" class="page-scroll">${employee.getFullName()}</a></li>
							<li><a href="${pageContext.request.contextPath}/logout"
								class="page-scroll">Log Out</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- Header -->
	<header class="text-center">
		<div class="intro-text">
			<h1>
				Welcome to <strong>Susanoo</strong>
			</h1>
			<p>Air company #1 in Minsk</p>

			<a href=<c:url value="/flights"/>
				class="btn btn-default btn-lg page-scroll">VIEW FLIGHTS</a>
			<c:choose>
				<c:when test="${employee.getPosition()==\"Administrator\"}">
					<a href=<c:url value="/add_flight"/>
						class="btn btn-default btn-lg page-scroll">ADD FLIGHTS</a>
				</c:when>
				<c:when test="${employee.getPosition()==\"Dispatcher\"}">
					<a href=<c:url value="/add_crew"/>
						class="btn btn-default btn-lg page-scroll">ADD CREW</a>
				</c:when>
			</c:choose>
		</div>
	</header>

	<!-- Achievements Section -->
	<div id="achievements" class="section dark-bg">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-3">
					<div class="achievement-box">
						<span class="count">11,210</span>
						<h4>Happy clients</h4>
					</div>
				</div>
				<div class="col-md-3 col-sm-3">
					<div class="achievement-box">
						<span class="count">119,500</span>
						<h4>Fly hours</h4>
					</div>
				</div>
				<div class="col-md-3 col-sm-3">
					<div class="achievement-box">
						<span class="count">190</span>
						<h4>Planes in sky</h4>
					</div>
				</div>
				<div class="col-md-3 col-sm-3">
					<div class="achievement-box">
						<span class="count">42</span>
						<h4>Awards won</h4>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Contact Section -->
	<div id="contact-section" class="text-center">
		<div class="container">
			<h2>Log In</h2>
			<div class="col-md-8 col-md-offset-2">
				<h3>Log In</h3>
				<form action="LoginServlet" method="post">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" name="name" class="form-control"
									placeholder="Name" required="required">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<input type="password" name="password" class="form-control"
									placeholder="Password" required="required">
								<p class="help-block text-danger"></p>
							</div>
						</div>
					</div>
					<div id="success"></div>
					<button type="submit" value="login" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</div>

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