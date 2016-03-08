<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	
	<li><a href="Studentdashboard.html?id=${userid}"><i class="fa fa-edit fa-fw"></i>Applications</a>
						</li>
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
						<li class="active">View</li>

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
							<h1 >
								Application Form</h1>
							<div></div>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table class="table table-striped table-bordered table-condensed" >
								<thead>
									<tr>
										<%-- 	<th>Student First Name</th>  --%>


									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">First Name</th>
										<td >${application.firstName}</td>

									</tr>
									<tr>
										<th scope="row">Last Name</th>
										<td>${application.lastName}</td>

									</tr>
									<tr>
										<th scope="row">Email</th>
										<td>${application.email}</td>

									</tr>
									<tr>
										<th scope="row">CIN</th>
										<td>${application.cin}</td>

									</tr>
									<tr>
										<th scope="row">Gender</th>
										<td>${application.gender}</td>

									</tr>
									<tr>
										<th scope="row">Date</th>
										<td>${application.date}</td>

									</tr>
									<tr>
										<th scope="row">Citizenship</th>
										<td>${application.citizenship}</td>

									</tr>
										<tr>
										<th scope="row">Phone Number</th>
										<td>${application.phoneNumber}</td>

									</tr>
									
									</tr>
										<tr>
										<th scope="row">Department</th>
										<td>${application.program.department.name}</td>

									</tr>
									
									</tr>
										<tr>
										<th scope="row">Program</th>
										<td>${application.program.name}</td>

									</tr>
									
									<tr>
										<th scope="row">Term</th>
										<td>${application.termStatus.term}-
											${application.termStatus.year}</td>

									</tr>

	
									<tr>
										<th scope="row">Educational Background</th>
										<td>
										<c:forEach items="${educationalBackground}" var="educationalbackground" varStatus="loop">
										
										
										<div class="well">
										<strong>Educational Background #${loop.count } </strong><br/><br/>
										<b>University</b>:${educationalbackground.universityname}<br/>
										
										<b>Degree Earned</b>:${educationalbackground.degreeEarned}<br/>
										<b>Major</b>:${educationalbackground.major}<br/>
										<b>Start Date</b>: ${educationalbackground.startDate} <br/>
										<b>End Date</b>: ${educationalbackground.endDate} <br/>
										</div>
										</c:forEach>
										</td>

									</tr>
									
									<tr>
										<th scope="row">Academic Records</th>
										<td>
										<b>GPA</b>:${application.gpa} <br/>
										<b>TOEFL</b>:${application.toefl} <br/>
										<b>Transcript</b>:
										<c:if test="${not empty application.transcript}">
										<a href="download.html?filename=${application.transcript}">:Download  </a><br/>
										</c:if>
										<c:if test="${empty application.transcript}">
										Not Uploaded<br/>
										</c:if>
										<b>GRE</b>:${application.gre}<br/>
										
										
										
										
										
										</td>
										

									</tr>
									
									<tr>
										<th scope="row">Additional Field</th>
										
										<td>
									
										<c:forEach items="${department.additionalFields}" var="applicationField" varStatus="status">
										
										<div class="well">
										<strong >Field #<c:out value="${status.count}" /></strong>
										
										
										<c:if test="${applicationField.isRequired == true}">
																			
																<span class='pull-right control-group' style="color:red;">Required</span>
										</c:if>
										<br/>
										<br/> 
										
										
											
											<b>Name:</b>${applicationField.fieldName} <br/>
											<b>Type:</b>${applicationField.fieldType}<br/>
											
											<c:forEach items="${application.additionalFieldsvalueStores}" var="additionalFieldsvalueStore">
												<c:if test="${additionalFieldsvalueStore.additionalFields.id eq applicationField.id}">
												
													<c:if test="${applicationField.fieldType == File}">
														<b>Value:</b>
														<c:if test="${not empty additionalFieldsvalueStore.value}">
															<a href="download.html?filename=${additionalFieldsvalueStore.value}">:Download  </a><br/>
														</c:if>
														<c:if test="${empty additionalFieldsvalueStore.value}">
															<span style="color:red;">No File Exist</span>
															<br/>
														</c:if>
													</c:if>
													<c:if test="${applicationField.fieldType ne File}">
														<b>Value:</b>
														
														<c:if test="${empty additionalFieldsvalueStore.value}">
															<span style="color:red;">Empty</span>
															<br/>
														</c:if>
														
														<c:if test="${not empty additionalFieldsvalueStore.value}">
															${additionalFieldsvalueStore.value} 
															<br/>
														</c:if>
														
													</c:if>
												</c:if>
												
											</c:forEach>
											<br/><br/>
											</div>
										</c:forEach>	
										<div>
										</td>
										
									</tr>


								</tbody>
							</table>
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

	<jsp:include page="includes/footer.jsp" />
</body>

</html>
