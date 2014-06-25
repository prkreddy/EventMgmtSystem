<%@ page import="edu.iiitb.ems.model.*"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
<link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
<link rel="stylesheet" href="css/style_travel.css" type="text/css"
	media="all">



<link rel="stylesheet" href="css/bootstrap.css" />
<!-- <link rel="stylesheet" href="css/bootstrap-responsive.css" /> -->
<link rel="stylesheet" href="css/datepicker.css">

<!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">

<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-replace.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_italic_600.font.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_italic_400.font.js"></script>
<script type="text/javascript" src="js/Myriad_Pro_400.font.js"></script>

</head>
<body id="page2">


	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-datetimepicker.js"></script>
	<script src="js/bootstrap-datetimepicker.uk.js"></script>
	<script>
		// When the document is ready
		$(document).ready(function() {

			$('#departuredate').datepicker({
				format : "yyyy-mm-dd"
			});

		});

		$(document).ready(function() {

			$('#returndate').datepicker({
				format : "yyyy-mm-dd"
			});

		});
	</script>



	<div class="body1">
		<div class="main">
			<!-- header -->
			<header>
				<div class="wrapper">
					<h1>
						<a href="index-1.jsp">EMS Travel</a>
					</h1>
					<div class="right">
						<nav>
							<ul id="top_nav">
								<li><a href="index-1.jsp"><img src="images/img1.gif"
										alt=""></a></li>
								<li><a href="index-4.jsp"><img src="images/img2.gif"
										alt=""></a></li>
								<li class="bg_none"><a href="#"><img
										src="images/img3.gif" alt=""></a></li>
							</ul>
						</nav>
						<nav>
							<ul id="menu">
								<li><a href="index-1.jsp">Home</a></li>
								<li id="menu_active"><a href="index-1.jsp">History</a></li>
								<!-- <li><a href="index-2.html">Safety</a></li>
							<li><a href="index-3.html">Charters</a></li> -->
								<li><a href="index-4.jsp">Contacts</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</header>
		</div>
	</div>
	<div class="main">
		<div id="banner">
			<!-- <div class="text1">
			COMFORT<span>Guaranteed</span><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		</div> -->
		</div>
	</div>
	<!-- <div class="ic">More Website Templates at TemplateMonster.com!</div> -->
	<!-- header -->
	<div class="main">
		<!-- content -->
		<section id="content">


			<div class="row">
				<div class="span2"></div>
				<div class="span8">
					<h2>Events Registered</h2>
					<table class="table table-hover">
						<!-- 	<caption>Events Registered</caption> -->
						<thead>
							<tr>
								<th>S.no</th>
								<th>EventName</th>
								<th>Date</th>
								<th>Venue</th>
								<th>Time</th>
								<th>Register</th>
							</tr>
						</thead>

						<%
							List<Event> events = (List<Event>) request.getAttribute("events");
							int i = 0;
						%>


						<tbody>

							<%
								for (Event event : events)
								{
									switch (i % 4)
									{

									case 0:
							%>

							<tr class="active">

								<%
									;
											break;
										case 1:
								%>
							
							<tr class="danger">
								<%
									;
											break;
										case 2:
								%>
							
							<tr class="warning">
								<%
									;
											break;
										case 3:
								%>
							
							<tr class="success">

								<%
									;
											break;

										}
								%>
								<td><%=++i%></td>
								<td><%=event.getEvent_name()%></td>
								<td><%=event.getEvent_start_date()%></td>
								<td><%=event.getVenue().getName()%></td>
								<td><%=event.getEvent_time()%></td>
								<td><form action="registerTransport" method="post">
										<input type="hidden" value="<%=event.getUser_event_id()%>"
											name="user_event_id" id="user_event_id"/>
										<button type="submit" class="btn btn-primary" onclick="">Register</button>
									</form></td>
								<%
									}
								%>
							
						</tbody>
					</table>
				</div>
				<div class="span2"></div>
			</div>

		</section>
		<!-- / content -->
	</div>
	<div class="body2">
		<div class="main">
			<!--footer -->
			<footer>
				<!-- 				<a rel="nofollow" href="http://www.templatemonster.com/"
					target="_blank">Website template</a> designed by iiit.b<br> <a
					href="http://www.templates.com/product/3d-models/" target="_blank">3D
					Models</a> provided by Templates.com -->
			</footer>
			<!-- / footer -->
		</div>
	</div>


</body>
</html>