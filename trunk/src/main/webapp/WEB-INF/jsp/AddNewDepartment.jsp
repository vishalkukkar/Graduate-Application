<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Graduate Applications</title>
<jsp:include page="includes/styles.jsp" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.3.2.min.js"></script>

</head>

<body>


	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							var counter = 2;

							$("#addButton")
									.click(
											function() {

												if (counter > 10) {
													alert("Only 10 textboxes allow");
													return false;
												}

												var newTextBoxDiv = $(
														document
																.createElement('div'))
														.attr(
																"id",
																'TextBoxDiv'
																		+ counter);

												newTextBoxDiv
														.after()
														.html(
																'<label>Textbox #'
																		+ counter
																		+ ' : </label>'
																		+ '<input type="text" name="textbox' + counter + 
	      '" id="textbox' + counter + '" value="" >');

												newTextBoxDiv
														.appendTo("#TextBoxesGroup");

												counter++;
											});

							$("#removeButton").click(function() {
								if (counter == 1) {
									alert("No more textbox to remove");
									return false;
								}

								counter--;

								$("#TextBoxDiv" + counter).remove();

							});

							$("#getButtonValue").click(
									function() {

										var msg = '';
										for (i = 1; i < counter; i++) {
											msg += "\n Textbox #" + i + " : "
													+ $('#textbox' + i).val();
										}
										alert(msg);
									});
						});
	</script>

	<div id="wrapper">

		<jsp:include page="includes/header.jsp" />

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Dashboard</h1>
				</div>


				<div class="scp-breadcrumb">
					<ul class="breadcrumb">
						<li><a href="departments.html">Departments</a></li>
						<li class="active">Edit</li>
					</ul>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-users fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${users.size()}</div>
									<div>Users</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-tasks fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${applications.size()}</div>
									<div>Applications</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>


				<div class="col-lg-3 col-md-6">
					<div class="panel panel-yellow">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-building-o fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${departments.size()}</div>
									<div>Departments</div>
								</div>
							</div>
						</div>
						<a href="departments.html">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>



				<div class="col-lg-3 col-md-6">
					<div class="panel panel-red">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-building fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge">${programs.size()}</div>
									<div>Programs!</div>
								</div>
							</div>
						</div>
						<a href="#">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
			</div>









			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-bar-chart-o fa-fw"></i>


					<form:form modelAttribute="department">
Department Name : <form:input path="name" />
				
				&nbsp
				<input type="submit" class="btn btn-primary" name="add" value="Add" />
					</form:form>
					
					
					
					
					<div id='TextBoxesGroup'>
						<div id="TextBoxDiv1">
							<label>Textbox #1 : </label><input type='textbox' id='textbox1' name = 'textbox1'>
					</div>
					</div>
					<input type='button' value='Add Button' id='addButton'> <input
						type='button' value='Remove Button' id='removeButton'> <input
						type='button' value='Get TextBox Value' id='getButtonValue'>
			
					
					
					
				</div>

					

				<table class="table table-striped">
					<thead>
						<tr>

							<th>Programs offered &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp <a
								href="<c:url value="addProgramsForAddPage.html?id=${department.id}" />"
								class="btn btn-primary " class="icon-bar">Add Program</a>



							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:forEach var="program" items="${program}">
									<ul>
										<li>${program.name}<a
											href="RemoveProgram.html?id=${program.id}&departmentId=${department.id}">

												<span class="glyphicon glyphicon-remove" rel="tooltip"
												title="Delete ${program.name}" id="blah" aria-hidden="true"></span>
										</a></li>


									</ul>
								</c:forEach></td>
						</tr>
						<tr>
							<th>Additional Requirment &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
								&nbsp <a
								href="<c:url value="addFieldForEditPage.html?id=${department.id}" />"
								class="btn btn-primary " class="icon-bar">Add Field</a>
							</th>
						</tr>
						<tr>
							<td><c:forEach var="field" items="${additionalfield}">



									<ul>
										<li>${field.fieldName}-${field.fieldType}<a
											href="RemoveField.html?id=${field.id}&departmentId=${department.id}">

												<span class="glyphicon glyphicon-remove" rel="tooltip"
												title="Delete ${field.fieldName}" id="blah"
												aria-hidden="true"></span>
										</a></li>


									</ul>

								</c:forEach></td>
						</tr>
					</tbody>
				</table>
				
				
				



			</div>
			
			
			

			<a href="<c:url value="departments.html" />" class="btn btn-primary "
				class="icon-bar">Save All changes</a>






			<!-- Custom Theme JavaScript -->
			<script src="<c:url value="dashboardassets/dist/js/sb-admin-2.js" />"></script>

			<script src="<c:url value="dashboardassets/js/morris-data.js" />"></script>

			<script
				src="<c:url value="dashboardassets/bower_components/morrisjs/morris.min.js"/>"></script>

			<script
				src="<c:url value="dashboardassets/bower_components/raphael/raphael-min.js" />"></script>

			<script
				src="<c:url value="dashboardassets/bower_components/metisMenu/dist/metisMenu.min.js" />"></script>

			<script
				src="<c:url value="dashboardassets/bower_components/bootstrap/dist/js/bootstrap.min.js" />"></script>


			<script
				src="<c:url value="dashboardassets/bower_components/jquery/dist/jquery.min.js" />"></script>

			<script
				src="<c:url value="assets/jquery-1.3.2.min.js" />"></script>
			
			</body>

</html>
