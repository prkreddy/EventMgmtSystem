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
<!--[if lt IE 9]>
	<script type="text/javascript" src="http://info.template-help.com/files/ie6_warning/ie6_script_other.js"></script>
	<script type="text/javascript" src="js/html5.js"></script>
<![endif]-->
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
								<input type="text" class="input input1" value="Enter City"
									onBlur="if(this.value=='') this.value='Enter City'"
									onFocus="if(this.value =='Enter City' ) this.value=''"
									name="source" />
							</div>
						</div>
						<div class="wrapper">
							Going To:
							<div class="bg">
								<input type="text" class="input input1" value="Enter City"
									onBlur="if(this.value=='') this.value='Enter City'"
									onFocus="if(this.value =='Enter City' ) this.value=''"
									name="destination">
							</div>
						</div>
						<div class="wrapper">
							Departure Date and Time:
							<div class="wrapper">
								<div class="bg left">
									<input type="text" class="input input2" value="mm/dd/yyyy "
										onBlur="if(this.value=='') this.value='mm/dd/yyyy '"
										onFocus="if(this.value =='mm/dd/yyyy ' ) this.value=''"
										name="departureDate" id="departureDate">
								</div>
								<div class="bg right">
									<input type="text" class="input input2 form_time" value="hh:mm"
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
									<input type="text" class="input input2" value="mm/dd/yyyy "
										onBlur="if(this.value=='') this.value='mm/dd/yyyy '"
										onFocus="if(this.value =='mm/dd/yyyy ' ) this.value=''"
										name="returnDate" id="returnDate" />
								</div>
								<div class="bg right">
									<input type="text" class="input input2 form_time" value="hh:mm"
										onBlur="if(this.value=='') this.value='hh:mm'"
										onFocus="if(this.value =='hh:mm' ) this.value=''"
										name="returnTime" id="returnTime" />
								</div>
							</div>
						</div>
						<div class="wrapper">
							<p>Passenger(s):</p>
							<div class="bg left">
								<input type="text" class="input input2" value="#passengers"
									onBlur="if(this.value=='') this.value='#passengers'"
									onFocus="if(this.value =='#passengers' ) this.value=''"
									name="passCount" />
							</div>
							<a href="#" class="button2"
								onClick="document.getElementById('form_1').submit()">go!</a>
						</div>
					</form>
					<!-- 	<h2>Did You Know?</h2>
				<p><strong>Lorem ipsum dolor</strong> sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo. </p> -->
					<!-- <div class="wrapper pad_bot2"><a href="#" class="button2">Read More</a></div> -->
				</div>
			</article>
			<!-- 	<article class="col2 pad_left1">
			<h2>Aircraft Sales</h2>
			<div class="wrapper">
				<figure class="left marg_right1"><img src="images/page2_img1.jpg" alt=""></figure>
				<p><strong>Sed ut perspiciatis</strong> unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae.</p>
			</div>
			<p>Vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem:</p>
			<div class="wrapper pad_bot1">
				<ul class="list1 cols marg_right1">
					<li><a href="#">Lipsum quia dolor amet consectetur</a></li>
					<li><a href="#">Vdipisci velit, sed quia non numquam</a></li>
					<li><a href="#">Dius modi tempora incidunt</a></li>
					<li><a href="#">Uliquam quaerat voluptatem enim</a></li>
				</ul>
				<ul class="list1 cols">
					<li><a href="#">Quis nostrum exercitationem</a></li>
					<li><a href="#">Quis autem vel eum iure reprehender</a></li>
					<li><a href="#">Ullam corporis suscipit laboriosam</a></li>
					<li><a href="#">Nisi ut aliquid ex commodi</a></li>
				</ul>
			</div>
			<div class="wrapper"><a href="#" class="button1">Read More</a></div>
			<h2>Aircraft Management</h2>
			<div class="wrapper">
				<figure class="right marg_left1"><img src="images/page2_img2.jpg" alt=""></figure>
				<p><strong>At vero eos et accusamus</strong> et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excep- turi sint occaecati cupiditate.</p>
				<p><strong>Non provident</strong>, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus omnis.</p>
			</div>
		</article> -->
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