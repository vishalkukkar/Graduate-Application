<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Graduate Applications</title>

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

		<jsp:include page="includes/header.jsp" />

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Dashboard</h1>
				</div>

				<div class="scp-breadcrumb">
					<ul class="breadcrumb">
						<li class="active">Departments</li>

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
					<i class="fa fa-bar-chart-o fa-fw"></i> All Departments  &nbsp &nbsp
					&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
					&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
					&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
					&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
					&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
						&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
					&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
					&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
					&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
						&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
					&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
					&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
					&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
						&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
					&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
					&nbsp &nbsp&nbsp &nbsp&nbsp 
					 <a href="<c:url value="adddepartment.html" />"
				class="btn btn-primary square-btn-adjust"
				class="nav navbar-top-links navbar-right" class="icon-bar">Add
				Department</a>
				</div>


				
				<table class="table table-striped">
					<thead>
						<tr>

							<th>Department Name</th>
							<th>Programs Offered</th>
							<th>Details</th>
							<th>Operations</th>

						</tr>
					</thead>
					<c:forEach var="department" items="${departments}">
						<tbody>
							<tr>

								<td>${department.name}</td>
								<td>${department.programs.size()}</td>
								<%-- 	<td><a href="viewDepartment.html?id=${department.id}">View
										Details</a>
							--%>
								<td><a
									href="<c:url value="viewDepartment.html?id=${department.id}" />"
									class="btn btn-primary " class="icon-bar">View Details</a></td>

								<td><a
									href="<c:url value="addprograms.html?id=${department.id}" />"
									class="btn btn-primary " class="icon-bar">Add Program</a> &nbsp

									<a href="<c:url value="addfield.html?id=${department.id}" />"
									class="btn btn-primary " class="icon-bar">Add Field</a> &nbsp <a
									href="<c:url value="editDepartment.html?id=${department.id}" />"
									class="btn btn-primary " class="icon-bar">Edit</a></td>


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
