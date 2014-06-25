
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252">
<title>Bootstrap 3 Tutorial - cyberdesigncraft.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- MAKE SURE TO ADD THE STYLESHEET -->
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.css" />
<link rel="stylesheet" href="css/datepicker.css">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
</head>
<body>

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>

	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-datetimepicker.js"></script>
	<script src="js/bootstrap-datetimepicker.uk.js"></script>

	<!-- COPY AND PASTE YOUR CODE BELOW!!! -->
	<div class="container">


		<div class="row">

			<div class="span6">

				<form class="form-horizontal" action="addTikcetAction" method="post">
					<h2 style="text-align: left;">Add Venue To Event</h2>
					<hr>
					<div class="control-group">
						<label class="control-label" for="ticketType">ticketType</label>
						<div class="controls">
							<input type="text" id="ticketType" name="ticketType"
								placeholder="ticketType">
						</div>
					</div>

					<input type="hidden" id="venueid" name="venueid"
						value='<s:property value="venueid"/>'>
						
						 <input
						type="hidden" id="eventid" name="eventid"
						value='<s:property value="eventid"/>'>

					<div class="control-group">
						<label class="control-label" for="description">description</label>
						<div class="controls">
							<!-- 							<input type="text" id="eventstartdate"
								placeholder="eventstartdate"> -->
							<input type="text" placeholder="description" name="description"
								id="description">
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="cost">cost</label>
						<div class="controls">
							<!-- <input type="text" id="eventenddate" placeholder="event enddate"> -->

							<input type="text" placeholder="cost" id="cost" name="cost">
						</div>
					</div>



					<div class="control-group">
						<label class="control-label" for="ticketcount">ticketcount</label>
						<div class="controls">
							<input type="text" id="ticketcount" placeholder="ticketcount"
								name="ticketcount">
						</div>
					</div>

					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn">Next</button>
						</div>
					</div>



				</form>

			</div>
		</div>


	</div>
	<br>
	<br>
</body>
</html>