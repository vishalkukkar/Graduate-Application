<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Graduate Applications</title>
<jsp:include page="includes/styles.jsp" />
</head>

<body>
	<div id="wrapper">

		<jsp:include page="includes/header.jsp" />

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Dashboard</h1>
				</div>
				<!-- /.col-lg-12 -->

				<div class="scp-breadcrumb">
					<ul class="breadcrumb">
						<li><a href="departments.html">Departments</a></li>
						<li class="active">Add Department</li>

					</ul>
				</div>
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





			<form:form modelAttribute="department">
Department Name : <form:input path="name" />
				
				&nbsp

				<input type="submit" class="btn btn-primary" name="add" value="Add" />

			</form:form>












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
</body>

</html>
