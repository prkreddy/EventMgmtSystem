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
	<script>
		// When the document is ready
		$(document).ready(function() {

			$('#eventstartdate').datepicker({
				format : "yyyy-mm-dd"
			});

		});

		$(document).ready(function() {

			$('#eventenddate').datepicker({
				format : "yyyy-mm-dd"
			});

		});
	</script>
	<!-- COPY AND PASTE YOUR CODE BELOW!!! -->
	<div class="container">
		<!--  <div class="row">
      <div class="span12">
        <h1 style="text-align:center;">Forms</h1>
      </div>
  </div> -->
		<!-- .row -->

		<div class="row">
			<!--       <div class="span6">
        <h2>Default Form Style</h2>
            <form>
              <fieldset>
                <legend>Legend</legend>
                  <label for="name">Label name</label>
                    <input type="text" id="name" placeholder="This is Your Paceholder!">
                      <span class="help-block">You can place helpers here in the 'help-block'!.</span>
                        <label class="checkbox" for="checkbox">
                          <input type="checkbox" id="checkbox">
                          Tick Me!
                        </label>
                      <button type="submit" class="btn">Send</button>
              </fieldset>
            </form>
      </div> -->
			<div class="span6">

				<form class="form-horizontal" action="eventAction" method="post">
					<h2 style="text-align: left;">Create Event</h2>
					<hr>
					<div class="control-group">
						<label class="control-label" for="eventname">Event Name</label>
						<div class="controls">
							<input type="text" id="eventname" name="eventname"
								placeholder="Event Name">
						</div>
					</div>


					<div class="control-group">
						<label class="control-label" for="eventstartdate">Event
							StartDate</label>
						<div class="controls">
							<!-- 							<input type="text" id="eventstartdate"
								placeholder="eventstartdate"> -->
							<input type="text" placeholder="event startdate"
								name="eventstartdate" id="eventstartdate">
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="eventenddate">Event
							EndDate</label>
						<div class="controls">
							<!-- <input type="text" id="eventenddate" placeholder="event enddate"> -->

							<input type="text" placeholder="event enddate" id="eventenddate"
								name="eventenddate">
						</div>
					</div>

					<div class="control-group">

						<label class="control-label" for="eventDescription">Event
							Description</label>

						<div class="controls">
							<textarea rows="3" placeholder="This is for EventDescription!"
								name="eventDescription"></textarea>
						</div>

					</div>

					<div class="control-group">
						<label class="control-label" for="eventduration">Event
							Duration</label>
						<div class="controls">
							<input type="text" id="eventduration" placeholder="eventduration"
								name="eventduration">
						</div>
					</div>


					<div class="control-group">
						<label class="control-label" for="eventType">Event type</label>
						<div class="controls">
							<input type="text" id="eventType" placeholder="event Type"
								name="eventType">
						</div>
					</div>

					<div class="control-group">
						<label for="dtp_input3" class="col-md-2 control-label">Event
							Time</label>
						<div class="input-group date form_time col-md-5" data-date=""
							data-date-format="hh:ii" data-link-field="dtp_input3"
							data-link-format="hh:ii">

							<div class="controls">
								<input size="16" type="text" name="eventtime" readonly
									placeholder="event Time"> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-remove"></span></span> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-time"></span></span>

							</div>
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
		</script>

		<!-- <div class="container">
			<div class="hero-unit">
				<input type="text" placeholder="click to show datepicker"
					id="example1">
			</div>
		</div> -->

		<!-- .row -->
		<hr>
		<!--  <div class="row">
    <div class="span4">
      <h2>Input</h2>
      <input type="text" placeholder="This is an input!">
    </div>
    <div class="span4">
      <h2>Textarea</h2>
      <textarea rows="3" placeholder="This is a textarea!"></textarea>
    </div>
    <div class="span4">
      <h2>Checkbox &amp; Radio</h2>
      <label class="checkbox">
          <input type="checkbox" value="">
            Check this out!
      </label>
      <label class="radio">
          <input type="radio" name"optionsRadios" id="optionsRadios2" value="option2">
            Radio Button!
      </label>
    </div>
  </div>.row
  <hr>
  <div class="row">
    <div class="span4">
      <h2>Inline Boxes &amp; Radios</h2>
      <label for="option1" class="checkbox inline">
        <input id="option1" type="checkbox" id="inlineCheckbox1" value="option1"> 1
      </label>
      <label for="option2" class="checkbox inline">
        <input id="option2" type="checkbox" id="inlineCheckbox2" value="option2"> 2
      </label>
        <label for="option3" class="checkbox inline">
      <input id="option3" type="checkbox" id="inlineCheckbox3" value="option3"> 3
      </label>
      <label for="option1" class="checkbox inline">
        <input id="option1" type="radio" id="inlineCheckbox1" value="option1"> 1
      </label>
      <label for="option2" class="checkbox inline">
        <input id="option2" type="radio" id="inlineCheckbox2" value="option2"> 2
      </label>
        <label for="option3" class="checkbox inline">
      <input id="option3" type="radio" id="inlineCheckbox3" value="option3"> 3
      </label>
    </div>
    <div class="span4">
      <h2>Selects</h2>
      <select>
        <option>United States</option>
        <option>United Kingdom</option>
        <option>Bolivia</option>
        <option>Argentina</option>
        <option>New Zealand</option>
        </select>
        <select multiple="multiple">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </select>
    </div>
    <div class="span4">
      <h2>Prepend &amp; Append</h2>
      <div class="input-prepend">
        <span class="add-on">@</span>
          <input class="span2" id="prependedInput" type="text" placeholder="Username">
      </div>
      <div class="input-append">
        <input class="span2" id="appendedInput" type="text">
        <span class="add-on">.00</span>
      </div>
    </div>
  </div>.row
  <hr>
  <div class="row">
    <div class="span4">
      <h2>Prepend &amp; Append</h2>
      <div class="input-prepend input-append">
        <span class="add-on">&euro;</span>
        <input class="span2" id="appendedPrependedInput" type="text">
        <span class="add-on">.00</span>
      </div>
    </div>
    <div class="span4">
      <h2>Append &amp; Prepend</h2>
      <div class="input-append">
        <input class="span2" id="appendedInputButtons" type="text">
          <button class="btn" type="button">Search</button>
          <button class="btn" type="button">Options</button>
      </div>
    </div>
    <div class="span4">
      <h2>Append to Search</h2>
      <form class="form-search">
        <div class="input-append">
          <input type="text" class="span2 search-query">
          <button type="submit" class="btn">Search</button>
        </div>
        <div class="input-prepend">
          <button type="submit" class="btn">Search</button>
          <input type="text" class="span2 search-query">
        </div>
      </form>
    </div>
  </div>.row
  <hr>
  <div class="row">
    <div class="span6">
      <h2>Relative Input Controls</h2>
      <input class="input-mini" type="text" placeholder=".input-mini">
      <input class="input-small" type="text" placeholder=".input-small">
      <input class="input-medium" type="text" placeholder=".input-medium">
      <input class="input-large" type="text" placeholder=".input-large">
      <input class="input-xlarge" type="text" placeholder=".input-xlarge">
      <input class="input-xxlarge" type="text" placeholder=".input-xxlarge">
    </div>
    <div class="span6">
      <h2>Grid Size</h2>
      <input class="span1" type="text" placeholder=".span1">
      <input class="span2" type="text" placeholder=".span2">
      <input class="span3" type="text" placeholder=".span3">
      <select class="span1">
        <option>1</option>
        <option>2</option>
        <option>3</option>
      </select>
      <select class="span2">
        <option>1</option>
        <option>2</option>
        <option>3</option>
      </select>
      <select class="span3">
        <option>1</option>
        <option>2</option>
        <option>3</option>
      </select>
    </div>
  </div>.row
  <hr>
  <div class="row">
    <div class="span4">
      <h2>Span Sized Inputs</h2>
      <div class="controls">
        <input class="span4" type="text" placeholder=".span4">
      </div>
      <div class="controls controls-row">
        <input class="span3" type="text" placeholder=".span3">
        <input class="span1" type="text" placeholder=".span1">
      </div>
    </div>
    <div class="span4">
      <h2>Uneditable Text</h2>
      <span class="input-xlarge uneditable-input">You cannot edit this!</span>
      <hr>
    </div>
    <div class="span4">
      <h2>Form Actions</h2>
      <div class="form-actions">
        <button type="submit" class="btn btn-primary">Save changes</button>
        <button type="button" class="btn">Cancel</button>
      </div>
    </div>
  </div>.row
  <hr>
  <div class="row">
    <div class="span4">
      <h2>Help Text</h2>
      <input type="text"><span class="help-inline">I hope this Helps?</span>
    </div>
    <div class="span4">
      <h2>Help Block</h2>
      <input type="text"><span class="help-block">Just in case you need a whole lotta help!</span>
    </div>
    <div class="span4">
      <h2>Input Focus</h2>
      <input class="input-xlarge" id="focusedInput" type="text" value="This is focused...">
    </div>
  </div>.row
  <hr>
  <div class="row">
    <div class="span4">
      <h2>Disabled input</h2>
      <input class="input-xlarge" id="disabledInput" type="text" placeholder="Disabled text..." disabled>
    </div>
    <div class="span8">
      <h2>Validation States</h2>
      <div class="control-group warning">
        <label class="control-label" for="inputWarning">Warning Input</label>
        <div class="controls">
          <input type="text" id="inputWarning">
          <span class="help-inline">Warning somethings not right!</span>
        </div>
        </div>
        <div class="control-group error">
          <label class="control-label" for="inputError">Error Input</label>
        <div class="controls">
          <input type="text" id="inputError">
          <span class="help-inline">An error has been made in your favour!</span>
        </div>
        </div>
        <div class="control-group success">
          <label class="control-label" for="inputSuccess">It's been a success!</label>
        <div class="controls">
          <input type="text" id="inputSuccess">
        <span class="help-inline">Oh Yeah!</span>
        </div>
      </div>
    </div>
  </div>.row
  <hr>
  <div class="row">
    <div class="span12">
      <hr>
      <h1 style="text-align:center;">Tables</h1>
      <hr>
    </div>
  </div>.row
  <hr>
  <div class="row">
    <div class="span4">
      <h2>Basic Table</h2>
      <table class="table">
        <caption>This is a Caption!</caption>
      <thead>
      <tr>
      <th>Cars</th>
      <th>Trains</th>
      </tr>
      </thead>
      <tbody>
      <tr>
      <td>One</td>
      <td>Two</td>
      </tr>
      </tbody>
      </table>
    </div>
    <div class="span4">
      <h2>Striped Table</h2>
      <table class="table table-striped">
        <caption>This is a Caption!</caption>
      <thead>
      <tr>
      <th>Cars</th>
      <th>Trains</th>
      <th>Planes</th>
      </tr>
      </thead>
      <tbody>
      <tr>
      <td>One</td>
      <td>Two</td>
      <td>Three</td>
      </tr>
      <tr>
      <td>Four</td>
      <td>Five</td>
      <td>Six</td>
      </tr>
      <tr>
      <td>Seven</td>
      <td>Eight</td>
      <td>Nine</td>
      </tr>
      </tbody>
      </table>
    </div>
    <div class="span4">
      <h2>Hover Table</h2>
      <table class="table table-hover">
        <caption>This is a Caption!</caption>
      <thead>
      <tr>
      <th>Cars</th>
      <th>Trains</th>
      <th>Planes</th>
      </tr>
      </thead>
      <tbody>
      <tr>
      <td>One</td>
      <td>Two</td>
      <td>Three</td>
      </tr>
      <tr>
      <td>Four</td>
      <td>Five</td>
      <td>Six</td>
      </tr>
      <tr>
      <td>Seven</td>
      <td>Eight</td>
      <td>Nine</td>
      </tr>
      </tbody>
      </table>
    </div>
  </div> -->
		<!-- .row -->
		<hr>
		<!--  <div class="row">
    <div class="span2">
    </div>
    <div class="span8">
      <h2>Coloured Rows</h2>
      <table class="table table-hover">
        <caption>This is a Caption!</caption>
      <thead>
      <tr>
      <th>Cars</th>
      <th>Trains</th>
      <th>Planes</th>
      </tr>
      </thead>
      <tbody>
      <tr class="active">
      <td>One</td>
      <td>Two</td>
      <td>Three</td>
      </tr>
      <tr class="danger">
      <td >Four</td>
      <td>Five</td>
      <td>Six</td>
      </tr>
      <tr class="warning">
      <td>Seven</td>
      <td>Eight</td>
      <td>Nine</td>
      </tr>
      <tr class="success">
      <td>Ten</td>
      <td>Eleven</td>
      <td>Twelve</td>
      </tr>
      </tbody>
      </table>
    </div>
    <div class="span2">
    </div>
  </div> -->
	</div>
	<br>
	<br>
</body>
</html>