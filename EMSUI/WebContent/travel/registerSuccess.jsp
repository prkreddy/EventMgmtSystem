<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta charset="utf-8">
</head>
<body id="page2">


	<script>
		// When the document is ready
		$(document).ready(function() {

			$('#departureDate').datepicker({
				format : "yyyy-mm-dd"
			});

		});

		$(document).ready(function() {

			$('#returnDate').datepicker({
				format : "yyyy-mm-dd"
			});

		});
	</script>




<!-- 	<div class="main">
		<div id="banner">
			<div class="text1">
			COMFORT<span>Guaranteed</span><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
		</div>
		</div>
	</div> -->
	<!-- <div class="ic">More Website Templates at TemplateMonster.com!</div> -->
	<!-- header -->
	<div class="main">
		<!-- content -->
		<section id="content">
			<h3 align="left">Your Travelling details</h3>
			<h3 align="left">--------------------------</h3>
			<form id="form_1" action="eventsRegisteredAction" method="post">

				<h4>Mode Of Transport :</h4><%=request.getParameter("travelmode")%>
				<br>

				<h4>Travel Type :</h4><%=request.getParameter("travel_type")%>
				<br>
				<h4>Source :</h4><%=request.getParameter("source")%><br>
				<h4>destination :</h4><%=request.getParameter("destination")%><br>

				<h4>departureDate :</h4><%=request.getParameter("departureDate")%><br>
				<h4>departureTime :</h4><%=request.getParameter("departureTime")%><br>
				<h4>returnDate :</h4><%=request.getParameter("returnDate")%><br>
				<h4>returnTime :</h4><%=request.getParameter("returnTime")%><br>
				<h4>trackingId :</h4><%=request.getAttribute("trackingId")%><br>
				<h4>passCount :</h4><%=request.getParameter("passCount")%>
				<br> <a href="#" class="button2"
					onClick="document.getElementById('form_1').submit()">go!</a>
			</form>
		</section>
		<!-- / content -->
	</div>


	<script type="text/javascript">
		$('.form_time').datetimepicker({
			language : 'uk',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 1,
			minView : 0,
			maxView : 1,
			forceParse : 0
		});

		$(".form_time").change(function() {
			//alert("Handler for .change() called.");
			var value = $(this).val();
			if (value != null) {
				var datetime = value.split(" ");
				//alert(datetime[1]);
				$(this).val(datetime[1]);

			}

		});

		$(('input:radio[name=travel_type]')).click(function() {
			if ($(this).val() == 'oneway') {
				/* $("#returndata").attr("disabled", "disabled"); 
				$("#returnTime").attr("disabled", "disabled");  */

				$("#returnDate").prop('disabled', true);
				$("#returnTime").prop('disabled', true);
				/* $("#returnDate").val('disabled');
				$("#returnTime").val('disabled'); */
				$("#returnDate").css({
					"background-color" : "gray"
				});
				$("#returnTime").css({
					"background-color" : "gray"
				});
			} else {
				$("#returnDate").prop('disabled', false);
				$("#returnTime").prop('disabled', false);
				$("#returnDate").val('mm/dd/yyyy');
				$("#returnTime").val('hh:mm');
				$("#returnDate").css({
					"background-color" : "white"
				});
				$("#returnTime").css({
					"background-color" : "white"
				});
			}
		});
	</script>
	<script type="text/javascript">
		Cufon.now();
	</script>
</body>
</html>