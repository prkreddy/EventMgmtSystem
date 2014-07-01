<%@ page import="edu.iiitb.ems.model.*"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta charset="utf-8">
</head>
<body id="page2">

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
					<h2>Transport Registered List</h2>
					<table class="table table-hover">
						<!-- 	<caption>Events Registered</caption> -->
						<thead>
							<tr>
								<th>S.no</th>
								<th>TransactionID</th>
								<th>EventName</th>
								<th>Source</th>
								<th>Destination</th>
								<th>passengerCount</th>
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
								<td><%=event.getTransport().getTransportId()%></td>
								<td><%=event.getEvent_name()%></td>
								<td><%=event.getTransport().getSource()%></td>
								<td><%=event.getTransport().getDestination()%></td>
								<td><%=event.getTransport().getPassCount()%></td>
								<%-- 			<td><form action="registerTransport" method="post">
										<input type="hidden" value="<%=event.getUser_event_id()%>"
											name="user_event_id" id="user_event_id" />
										<button type="submit" class="btn btn-primary" onclick="">Register</button>
									</form></td> --%>
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


</body>
</html>