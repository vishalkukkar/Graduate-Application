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

<title>Student</title>

<jsp:include page="includes/styles.jsp" />

</head>

<body>
	<!-- <div class='container'>
		<div class='loader'>
			<div class='loader--dot'></div>
			<div class='loader--dot'></div>
			<div class='loader--dot'></div>
			<div class='loader--dot'></div>
			<div class='loader--dot'></div>
			<div class='loader--dot'></div>
			<div class='loader--text'></div>
		</div>
	</div> -->


	<div id="wrapper">

		<!-- Navigation -->

		<jsp:include page="includes/headerStudents.jsp" />

		<li><a href="Studentdashboard.html?id=${userid}"><i
				class="fa fa-edit fa-fw"></i>Applications</a></li>
		</ul>
	</div>
	<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
	</nav>
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Student Dashboard</h1>
			</div>

			<div class="scp-breadcrumb">
				<ul class="breadcrumb">
					<li><a href="Studentdashboard.html?id=${userid}">Applications</a></li>
					<li class="active">Edit</li>

				</ul>
			</div>


			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->

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
				<div class="panel panel-red">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-3">
								<i class="fa fa-building fa-5x"></i>
							</div>
							<div class="col-xs-9 text-right">
								<div class="huge">${programs.size()}</div>
								<div>Programs</div>
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



		<!-- /.panel -->

		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-bar-chart-o fa-fw"></i> View Application
			</div>
		</div>

		<div class="col-md-17 ">
			<div>
				<div class="panel panel-default">
					<div class="panel-heading text-center">
						<i></i>
						<h1>Application Form</h1>
						<div></div>
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">



						<form:form modelAttribute="application"
							enctype="multipart/form-data">

							<form:hidden path="id" value="${application.id}" />
							<input type="hidden" name="userId" value="${userid}">
							<input type="hidden" name="deptId"
								value="${application.program.department.id}" />

							<input type="hidden" name="termId"
								value="${application.termStatus.id}" />

							<table
								class="table table-striped table-bordered table-condensed my-table-class">
								<thead>
									<tr>
										<%-- 	<th>Student First Name</th>  --%>


									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">First name</th>
										<td><form:input path="firstName" class="form-control"
												value="${application.firstName}" placeholder="First name..." /></td>

									</tr>
									<tr>
										<th scope="row">Last Name</th>
										<td><form:input path="lastName" class="form-control"
												value="${application.lastName}" placeholder="Last Name..." /></td>

									</tr>

									<tr>
										<th scope="row">Email</th>
										<td><form:input path="email" class="form-control"
												value="${application.email}" placeholder="Email..." /></td>

									</tr>



									</tr>
									<tr>


										<th scope="row">CIN</th>
										<td><form:input path="cin" class="form-control"
												placeholder="cin" value="${application.cin}" /></td>
										<%-- <td>	<input type="text" class="form-control" placeholder="cin" value="${application.cin}"></td> --%>
									</tr>
									<tr>
										<th scope="row">Gender</th>


										<td><form:select path="gender" class="form-control"
												data-toggle="dropdown">
												<form:option value="male">male</form:option>
												<form:option value="female">female</form:option>
											</form:select></td>


									</tr>
									<%--  <tr>
										<th scope="row">Date</th>
										
										<td><form:input path="date" class="form-control" placeholder="application created on.."/></td>
										
									</tr>  --%>
									<tr>
										<th scope="row">Citizenship</th>
										<td><form:input path="citizenship" class="form-control"
												placeholder="citizenship" /></td>


									</tr>
									<tr>
										<th scope="row">Phone Number</th>
										<td><form:input path="phoneNumber" class="form-control"
												placeholder="phoneNumber" /></td>


									</tr>


									<tr>
										<th scope="row">Department</th>
										<td><strong>${application.program.department.name}</strong></td>

									</tr>


									<tr>

										<th scope="row">Program</th>

										<td><select class="form-control" name="progId">
												<c:forEach items="${allprograms}" var="prog">
													<c:if test="${selectedprog eq prog.id}">
														<option value="${prog.id}" selected>${prog.name}</option>
													</c:if>
													<c:if test="${selectedprog ne prog.id}">
														<option value="${prog.id}">${prog.name}</option>
													</c:if>

												</c:forEach>

										</select></td>




									</tr>

									<tr>
										<th scope="row">Term</th>

										<td>
										
									<%-- 	<input type="text"
											value="${application.termStatus.term}" name="termname"
											class="form-control"> --%>
											
											<select name="termname" id="termname"
													class="form-control" >
														
													<c:if test="${selectedterm eq 'Fall'}">
														<option value= "Fall" selected>Fall</option>
														<option value= "Winter">Winter</option>
														<option value= "Spring">Spring</option>
														<option value= "Summer">Summer</option>
													</c:if>
													
													<c:if test="${selectedterm eq 'Winter'}">
														<option value= "Fall" >Fall</option>
														<option value= "Winter" selected>Winter</option>
														<option value= "Spring">Spring</option>
														<option value= "Summer">Summer</option>
													</c:if>
													
													<c:if test="${selectedterm eq 'Spring'}">
														<option value= "Fall" >Fall</option>
														<option value= "Winter">Winter</option>
														<option value= "Spring" selected>Spring</option>
														<option value= "Summer">Summer</option>
													</c:if>
													
													<c:if test="${selectedterm eq 'Summer'}">
														<option value= "Fall" >Fall</option>
														<option value= "Winter">Winter</option>
														<option value= "Spring">Spring</option>
														<option value= "Summer" selected>Summer</option>
													</c:if>
													
												</select>
											
											
											
											 <input type="text"
											value="${application.termStatus.year}" name="termyear"
											class="form-control"></td>


									</tr>




									<tr>
										<th scope="row">Educational Background <!-- <button class='btn btn-primary pull-right control-group' onclick="getnew()" name="myButton">Add New</button>
												 --> <input type="button" id="addNewButton" name="addNew"
											value="Add New"
											class='btn btn-primary pull-right control-group' />
										</th>

										<td><c:set var="existingEBCount" value="0" scope="page" />
											<c:forEach items="${educationalBackground}"
												var="educationalbackground" varStatus="loop">
												<c:set var="existingEBCount" value="${existingEBCount + 1}"
													scope="page" />
												<div class="well" id="eb_${existingEBCount}">
													<strong># Educational Background </strong> <input
														type="button"
														class='btn btn-danger pull-right control-group removeEB'
														name="background" rel="#eb_${existingEBCount}"
														id="${educationalbackground.id}" value="Remove" /> <br />
													<br /> <b>University</b>:
													${educationalbackground.universityname} <br /> <b>Degree
													</b>:${educationalbackground.degreeEarned} <br /> <b>Major</b>:${educationalbackground.major}<br />
													<b>Start Date</b>:${educationalbackground.startDate} <br />
													<b>End Date</b>: <br /> ${educationalbackground.endDate}
												</div>

											</c:forEach> <input type="hidden" id="existingEBCount"
											value="${existingEBCount}" /> <span id="addnew"></span>
											 <input
											type="hidden" value="0" id="addNewCount" name="educount" /></td>

									</tr>


									<tr>
										<th scope="row">Academic Records</th>
										<td><b>GPA</b>: <input type="text" class="form-control"
											name="gpa" value="${application.gpa}" placeholder="GPA">


											<b>TOEFL</b>: <input type="text" class="form-control"
											name="toefl" value="${application.toefl}" placeholder="toefl">


											<b>Transcript</b>: <a
											href="download.html?filename=${application.transcript}">:${application.transcript}
										</a> <input type="file" name="uploadtrascript"> <b>GRE</b>:
											<input type="text" class="form-control" name="gre"
											value="${application.gre}" placeholder="gre"> <br />





										</td>


									</tr>

									<tr>
										<th scope="row">Additional Field</th>
										<td><c:forEach items="${department.additionalFields}"
												var="applicationField" varStatus="status">

												<div class="well">
												
												<strong> Field #<c:out value="${status.count}" /></strong> 
														
														<c:if test="${applicationField.isRequired == true}">
																			
																<span class='pull-right control-group' style="color:red;">Required</span>
														</c:if>
														<br/>
														
														<br />
														<b>Name:</b>${applicationField.fieldName} <br />
														<b>Type:</b>${applicationField.fieldType}<br />

												<c:forEach
													items="${application.additionalFieldsvalueStores}"
													var="additionalFieldsvalueStore">
													<c:if
														test="${additionalFieldsvalueStore.additionalFields.id eq applicationField.id}">


																			<c:if test="${applicationField.fieldType == File}">
														<b>Value:</b>												
																			<c:if test="${not empty additionalFieldsvalueStore.value}">
																			<a href="download.html?filename=${additionalFieldsvalueStore.value}">:Download</a>
																		
																		<strong><br/>	Add New: 	</strong>
																				<input type="file" name="uploadfile[]">
																			<input type="hidden" name="addfieldPair[]" value='${applicationField.id}:${applicationField.fieldType}:${additionalFieldsvalueStore.id}' />
																		
																			</c:if>
																			
																			<c:if test="${empty additionalFieldsvalueStore.value}"> 
																			
																			<input type="hidden" name="addfieldPair[]" value='${applicationField.id}:${applicationField.fieldType}:${additionalFieldsvalueStore.id}' />
																		
																			
																			(File does not exist)
																			<strong><br/>	Add New: 	</strong> 
																			<input type="file" name="uploadfile[]">
																			</c:if>
																			<br />
																			</c:if>

																	<c:if test="${applicationField.fieldType == Text}">
																		<input type="hidden" name="addfieldPair[]" value='${applicationField.id}:${applicationField.fieldType}:${additionalFieldsvalueStore.id}' />
																		
																		
																		<b>Value:</b>
																		
																	<input name="textvalue[]" type="text" value="${additionalFieldsvalueStore.value}" class="form-control" >
																	
																	</c:if>

																		<c:if test="${applicationField.fieldType == Number}">
																			
																			<b>Value:</b>
																<input name="numbervalue[]" type="Number" value="${additionalFieldsvalueStore.value}"  >
																<input type="hidden" name="addfieldPair[]" value='${applicationField.id}:${applicationField.fieldType}:${additionalFieldsvalueStore.id}' />
																		
																	
																		</c:if>

													</c:if>

												</c:forEach>
												<br />
												<br />
												</div>
											</c:forEach></td>
									</tr>


								</tbody>
							</table>

							<%-- <span>
							<input type="hidden" value="${deptId}" name="deptId"> 
							<input class="btn btn-primary" type="submit" name="save"
							value="Save" />
							</span>
							 --%>
							
								&nbsp &nbsp &nbsp
								<input type="hidden" value="dummy" name="dummy">
								<input class="btn btn-primary" type="submit" name="editsave"
								value="Save" />
								
							<input class="btn btn-danger" type="submit" name="editsubmit"
								value="Submit" />
								
						

						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>


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

	<link rel="stylesheet"
		href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#datepicker1").datepicker({
				dateFormat : 'm/d/yy'
			}).val();

		});
	</script>

	<script>
		$(function() {
			$("#datepicker2").datepicker({
				dateFormat : 'm/d/yy'
			}).val();

		});
	</script>

	<script type="text/javascript"
		src="<c:url value="assets/js/editapplication.js" />"></script>

	<jsp:include page="includes/footer.jsp" />
</body>

</html>
