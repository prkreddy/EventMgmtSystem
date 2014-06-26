<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ page import="java.util.List"%>
<!DOCTYPE HTML>
<html>

<head>
<title>PhotoArtWork2</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<!-- stylesheets -->
<link href="user/css/style.css" rel="stylesheet" type="text/css" />
<link href="user/css/colour.css" rel="stylesheet" type="text/css" />
<!-- modernizr enables HTML5 elements and feature detects -->
<script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>

<body>
	<div id="main">

		<!-- begin header -->
		<header>
			<div id="logo">
				<h1>
					E<a href="#">M</a>S ORGNAISER SI<a href="exit.action">GN OU</a>T
				</h1>
			</div>
			<nav>
				<ul class="sf-menu" id="nav">
					<li class="selected"><a href="index.html">home</a></li>
					<li><a href="about.html">about me</a></li>
					<li><a href="#">services</a>
						<ul>
							<li><a href="createEvent">Create Event</a></li>
							<li><a href="#">Modify Event</a></li>
							<li><a href="#">Delete Event</a></li>
						</ul></li>
					<li><a href="contact.html">contact</a></li>
				</ul>
			</nav>
		</header>
		<!-- end header -->

		<!-- begin content -->
		<div id="site_content">
			<ul class="slideshow">
	<%
					List<String> events= (List)request.getAttribute("eventids"); 				
									int i=0;
								for (String event: events){
									System.out.println(event);																				
								if(i==0){
				%>

				<li class="show"><a href="#"><img width="950" height="450"
						src="imageAction?userId=<%=event%>"
						alt="&quot;You can put a caption for your image right here&quot;" /></a></li>
				<%
					} else {
				%>
				<li><a href="#"><img width="950" height="450"
						src="imageAction?userId=<%=event%>"
						alt="&quot;You can put a description of the image here if you like, or anything else if you want.&quot;" /></a></li>

				<%
					}++i;
																							}
				%></ul>
		</div>
		<!-- end content -->

		<!-- begin footer -->
		<footer> </footer>
		<!-- end footer -->

	</div>
	<!-- javascript at the bottom for fast page loading -->
	<script type="text/javascript" src="user/js/jquery.min.js"></script>
	<script type="text/javascript" src="user/js/jquery.easing-sooper.js"></script>
	<script type="text/javascript" src="user/js/jquery.sooperfish.js"></script>
	<script type="text/javascript" src="user/js/image_fade.js"></script>
	<!-- initialise sooperfish menu -->
	<script type="text/javascript">
    $(document).ready(function() {
      $('ul.sf-menu').sooperfish();
    });
  </script>
</body>
</html>
