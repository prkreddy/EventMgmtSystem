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
			<article class="col1">
				<div class="pad_1">
					<h3 align="left">Plan Your Travel</h3>
					<h3 align="left">--------------------------</h3>
					<form id="form_1" action="addTransportService" method="post">

						<h4>Mode Of Transport :</h4>
						<div class="wrapper pad_bot1">
							<div class="radio">
								<input type="radio" value="bus" name="travelmode">Bus<br>
							</div>
							<div class="radio">
								<input type="radio" value="plain" name="travelmode">Plane<br>
							</div>

						</div>

						<div class="wrapper pad_bot1">

							<div class="radio">
								<input type="radio" value="train" name="travelmode">Train<br>
							</div>
							<div class="radio">
								<input type="radio" value="taxi" name="travelmode">Taxi<br>
							</div>
						</div>

						<h4>Travel Type :</h4>
						<div class="wrapper pad_bot1">
							<div class="radio">
								<input type="radio" value="roundtrip" name="travel_type">Round
								Trip<br>
								<!-- 	<input type="radio" name="name1">One Way -->
							</div>
							<div class="radio">
								<input type="radio" value="oneway" name="travel_type">One
								Way<br>
								<!-- <input type="radio" name="name1">Multi-Leg -->
							</div>
						</div>


						<!--  -->

						<input type="hidden"
							value="<%=request.getAttribute("user_event_id")%>"
							name="user_event" />

						<!--  -->



						<div class="wrapper">
							Leaving From:
							<div class="bg">
								<input id="source" autocomplete="off" type="text" class="input input1"
									value="Enter City"
									onBlur="if(this.value=='') this.value='Enter City'"
									onFocus="if(this.value =='Enter City' ) this.value=''"
									name="source" />
							</div>
						</div>
						<div class="wrapper">
							Going To:
							<div class="bg">
								<input id="dest" autocomplete="off" type="text" class="input input1"
									value="Enter City"
									onBlur="if(this.value=='') this.value='Enter City'"
									onFocus="if(this.value =='Enter City' ) this.value=''"
									name="destination">
							</div>
						</div>
						<div class="wrapper">
							Departure Date and Time:
							<div class="wrapper">
								<div class="bg left">
									<input type="text" autocomplete="off" class="input input2" value="mm/dd/yyyy"
										onBlur="if(this.value=='') this.value='mm/dd/yyyy'"
										onFocus="if(this.value =='mm/dd/yyyy' ) this.value=''"
										name="departureDate" id="departureDate">
								</div>
								<div class="bg right">
									<input type="text" autocomplete="off" class="input input2 form_time" value="hh:mm"
										onBlur="if(this.value=='') this.value='hh:mm'"
										onFocus="if(this.value =='hh:mm' ) this.value=''"
										name="departureTime" id="departureTime">
								</div>
							</div>
						</div>
						<div class="wrapper">
							Return Date and Time:
							<div class="wrapper">
								<div class="bg left">
									<input type="text" autocomplete="off" class="input input2" value="mm/dd/yyyy"
										onBlur="if(this.value=='') this.value='mm/dd/yyyy'"
										onFocus="if(this.value =='mm/dd/yyyy' ) this.value=''"
										name="returnDate" id="returnDate" />
								</div>
								<div class="bg right">
									<input type="text" autocomplete="off" class="input input2 form_time" value="hh:mm"
										onBlur="if(this.value=='') this.value='hh:mm'"
										onFocus="if(this.value =='hh:mm' ) this.value=''"
										name="returnTime" id="returnTime" />
								</div>
							</div>
						</div>
						<div class="wrapper">
							<p>Passenger(s):</p>
							<div class="bg left">
								<input type="text" autocomplete="off" class="input input2" value="#passengers"
									onBlur="if(this.value=='') this.value='#passengers'"
									onFocus="if(this.value =='#passengers' ) this.value=''"
									name="passCount" />
							</div>
							<a href="#" class="button2" onClick="validate()">go!</a>
						</div>
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
		function validate() {

			
			var ErrorText = "";
			var travelmodes = document.getElementsByName("travelmode");
		
			if ((travelmodes[0].checked == false)
					&& (travelmodes[1].checked == false)
					&& (travelmodes[2].checked == false)
					&& (travelmodes[3].checked == false)) {
				ErrorText += " travel mode not selected\n";
				
			}

			var travelTypes = document.getElementsByName("travel_type");
			if ((travelTypes[0].checked == false)
					&& (travelTypes[1].checked == false)) {
				ErrorText += " travel type not selected\n";

			}

			var a = document.getElementById("source").value;
			if (a=="Enter City") {

				ErrorText += " source not entered\n";
			}
			var b = document.getElementById("dest").value;
			if (b=="Enter City") {

				ErrorText += " destination not entered\n";

			}
			var c = document.getElementById("departureDate").value;
			if (c=="mm/dd/yyyy") {

				ErrorText += " journey date not entered\n";

			}
			var d = document.getElementById("departureTime").value;
			if (d=="hh:mm") {

				ErrorText += " journey time  not entered\n";

			}
			var e = document.getElementById("returnDate").value;
			if ((travelTypes[0].checked == true) && e=="mm/dd/yyyy") {

				ErrorText += " return date not entered\n";

			}
			var f = document.getElementById("returnTime").value;
			if ((travelTypes[0].checked == true) && f=="hh:mm") {

				ErrorText += " return time is  not entered\n";

			}

			var g = document.getElementsByName("passCount")[0].value;

			if (g=="#passengers") {

				ErrorText += " #passengers is not entered\n";

			}
		
			if (ErrorText.length > 0) {	
				alert(ErrorText);
				return false;
			} else {
				document.getElementById('form_1').submit();
			}
			return false;
		};
	</script>
	<script type="text/javascript">
		Cufon.now();
	</script>
</body>
</html>