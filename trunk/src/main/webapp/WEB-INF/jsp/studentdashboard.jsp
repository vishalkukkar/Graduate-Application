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

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Student Dashboard</h1>
				</div>

				<div class="scp-breadcrumb">
					<ul class="breadcrumb">
						<li class="active">Applications</li>

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
				
				<i class="fa fa-bar-chart-o fa-fw"></i> Applications 
				
				 <a href="<c:url value="addapplication.html?id=${userid}" />"
						class="btn btn-primary pull-right control-group" class="icon-bar">Add
						Application</a>
					
				</div>



				<table class="table table-striped">
					<thead>
						<tr>

							<th>Department Name</th>
							<th>Programs name</th>
							<th>Date</th>
							<th>Term</th>
							<th>Current Status</th>
							<th>Operations</th>

						</tr>
					</thead>
					<c:forEach var="app" items="${applications}">
						<tbody>
							<tr>

								<td>${app.program.department.name}</td>
								<td>${app.program.name}</td>
								<td>${app.date}</td>
								<td>${app.termStatus.term} - ${app.termStatus.year}</td>
								<c:forEach var="stat" items="${app.applicationStatus}"
									varStatus="loop">

									<c:if test="${loop.first}">									
													
													<c:if test="${stat.status.id==1}">
          											<td>New</td>
          											</c:if>
          											
          											<c:if test="${stat.status.id==2}">
          											<td>Pending Review</td>
          											</c:if>
          											
          											<c:if test="${stat.status.id==3}">
          											<td>Denied</td>
          											</c:if>
          											
          											<c:if test="${stat.status.id==4}">
          											<td>Rejected</td>
          											</c:if>
          											
          											<c:if test="${stat.status.id==5}">
          											<td>Recommended Admit</td>
          											</c:if>
          											
          											<c:if test="${stat.status.id==6}">
          											<td>Recommended Admit (with condition)</td>
          											</c:if>
          											
          											<c:if test="${stat.status.id==7}">
          											<td>Not Submitted</td>
          											</c:if>
          											
          											<c:if test="${stat.status.id==8}">
          											<td>Submitted</td>
          											</c:if>
      								 </c:if>
									
								</c:forEach>
								<td><a
									href="<c:url value="viewapplication.html?id=${userid}&appId=${app.id}&deptid=${app.program.department.id}&progid=${app.program.id}" />"
									class="btn btn-primary " class="icon-bar"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>&nbspView </a></td>


								<%-- Display edit button --%>
								<c:forEach var="stat" items="${app.applicationStatus}"
									varStatus="loop">

									<c:if test="${loop.first}">									
													
													
          											
          											<c:if test="${stat.status.id==7}">
          											
          											
          											<td><a
									href="<c:url value="Editapplication.html?id=${userid}&deptid=${app.program.department.id}&progid=${app.program.id}&appId=${app.id}&termname=${app.termStatus.term}
									" />"
									class="btn btn-primary " class="icon-bar"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>&nbspEdit </a></td>

          											
          											
          											</c:if>
          											
      								 </c:if>
									
								</c:forEach>
								
								
								<td>
								
							</tr>

						</tbody>
					</c:forEach>

				</table>

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
