<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Student</title>
<meta charset="utf-8">
<title>jQuery UI Datepicker - Default functionality</title>



<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

 

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

						<li><a href="Studentdashboard.html?id=${userid}">Applications</a></li>
						<li class="active">Add Application</li>

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
					<i class="fa fa-bar-chart-o fa-fw"></i> Applications &nbsp &nbsp
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
					&nbsp &nbsp&nbsp

					<%-- <a href="<c:url value="addapplication.html?id=${userid}" />"
						class="btn btn-primary square-btn-adjust"
						class="nav navbar-top-links navbar-right" class="icon-bar">Save</a>
						--%>
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
								<%--Application class model attribute --%>
								<form:form id="target" modelAttribute="application" enctype="multipart/form-data" onsubmit="myButton.disabled = true; return true;" name="form"
									 >
									<input type="hidden" name="userid" value="${userid}">
									<table
										class="table table-striped table-bordered table-condensed">
										<thead>
											<tr>
												<%-- 	<th>Student First Name</th>  --%>


											</tr>
										</thead>
										<tbody>
																	
											<tr>
												<th scope="row">First name</th>
												<td><form:input path="firstName" class="form-control"
														placeholder="First name..." /></td>

											</tr>
											<tr>
												<th scope="row">Last Name</th>
												<td><form:input path="lastName" class="form-control"
														placeholder="Last Name..." /></td>

											</tr>
											
											<tr>
												<th scope="row">Email</th>
												<td><form:input path="email" class="form-control"
														placeholder="Email..." /></td>

											</tr>
											<tr>
												<th scope="row">CIN</th>
												<td><form:input path="cin" class="form-control"
														placeholder="Cin..." /></td>

											</tr>
											<tr>
												<th scope="row">Gender</th>
												<%-- <td><form:input path="gender" placeholder="gender..."
														class="form-control" /></td> --%>
														<td>
												<form:select path="gender"
													class="form-control"
													data-toggle="dropdown">
													<form:option value="male">male</form:option>
													<form:option value="female">female</form:option>
												</form:select>

												</td>



											</tr>

											<tr>
												<th scope="row">Citizenship</th>
												<td><form:input path="citizenship"
														placeholder="Citizenship..." class="form-control" /></td>

											</tr>
											<tr>
												<th scope="row">Phone Number</th>
												<td><form:input path="phoneNumber"
														placeholder="Phone Number..." class="form-control" /></td>

											</tr>

											</tr>
											<tr>
												<th scope="row">Department</th>


												<td><select name="deptId" id="deptId"
													class="form-control" >
														<option value="0">--Select Department--</option>
														<c:forEach var="dept" items="${departments}">

															<option value=${dept.id }>${dept.name}</option>

														</c:forEach>
												</select></td>

											</tr>

											</tr>
											<tr>
											<%--  <c:if test="${empty programerror}">
												
												<span class="alert alert-danger">
  							<strong>Danger!</strong> Please Select a Program to submit application
													</span>
												
												</c:if>  --%>
												
												<th scope="row">Program</th>

													
												
												<td>
												
												<strong><font color="red">${programerror}</font><strong>
												
												<select name="progId" id="progId"
													class="form-control" required="required">
														
												</select></td>
											</tr>

											<tr>
												<th scope="row">Term</th>

												<td>
												
												
													<!-- <b>Term</b>: <input type="text"
													class="form-control" name="termname"
													placeholder="ex.fall..." >  -->
													
												<b>Term</b>:<select name="termname" id="termname"
													class="form-control" >
														
															
															<option value= "Fall">Fall</option>
															<option value= "Winter">Winter</option>
															<option value= "Spring">Spring</option>
															<option value= "Summer">Summer</option>

														
												</select>
													
													<b>Year</b>:<input
													type="text" class="form-control" name="termyear"
													placeholder="Year..."></td>

											</tr>
											
											<tr>
												<th scope="row">Educational Background
												
												<input type="button" value="Add New" class='btn btn-primary pull-right control-group' class="pull-right" onclick="getnew()" name="myButton">
												</th>
												<td>
												<div class='well'>
												<strong>Educational Background #1<strong><br/><br/>
												
												<b>University</b>:<input type="text"
													class="form-control" name="university[]"
													placeholder="Univerisity..."> <b>Degree </b>:<input
													type="text" class="form-control" name="degree[]"
													placeholder="Degree..."> <b>Major</b>:<input
													type="text" class="form-control" name="major[]"
													placeholder="Major..."> 
													
													
				<b>Start Date</b>:				 <input type="text" class="form-control"
													name="startDate[]" placeholder="m/d/yy..." id="datepicker1" class="datepick"> 
				
				
				<b>End	Date</b>:  <br /> <input
													type="text" class="form-control" name="endDate[]" id="datepicker2" class="datepick"
													placeholder="m/d/yy...">
													
													</div>
													</br>
											<span id="addnew"></span>
											<input type="hidden" value="1" id="addNewCount" name="educount"/>
													
													</td>
											
											</tr>
										
											
											
											<tr>
											
								

											<tr>
												<th scope="row">Academic Records</th>
												<td>
												
												<b>GPA</b>:<form:input path="gpa" placeholder="gpa.." class="form-control"/>
												
												 <b>TOEFL Score</b>:<form:input
													path="toefl" class="form-control" 
													placeholder="Toefl Score..."/> 
										
								 
		 										<span>${message}</span>
							
							
												<b>Transcript</b>:
												 <input 	type="file" name="file"/> 
												 	
													
													
												<b>GRE</b>:<form:input
													path="gre"  class="form-control" 
													placeholder="gre.."/><br /></td>


											</tr>
											<tr>
												<th scope="row">Additional Field</th>
												<td id="ajaxAdditionalFields">	</td>
											</tr> 
										</tbody>
									</table>


									
									<!-- <input type="submit" class="btn btn-primary" name="submit"
										value="Submit" />
									<input type="submit" class="btn btn-primary" name="save"
										value="save" /> -->
									<input type="hidden" name="dummy" value="dummy">
									<input class="btn btn-primary" class="button" type="submit" name="save" value="Save" />
									<input class="btn btn-danger" class="button" type="submit" name="submit" value="Submit" />

								</form:form>
							</div>

						</div>



					</div>
				</div>
			</div>

		</div>

	</div>



	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

   

	<script type="text/javascript">
	
		$(document).ready(function() {
		"use strict";
		$("#deptId").on('change',function() {
		var departmentId = $(this).val();
		if (departmentId == 0) {
		alert("Please select a valid department");
		return false;
		}
		$.ajax({
		type : 'GET',
		url : '/springmvc/getProgram.html',
		data : {
			departmentId : departmentId
				},
		cache : false,
		dataType : 'json',
		beforeSend : function() {	},
		success : function(	data) {
				$("#progId")
				.html("");
		var html = '<option value="0">--No Program available--</option>';
		if (data.programs[0].length > 0) {
		html = '<option value="0">--Select Program--</option>';
		var programs = data.programs[0];
		for (var i = 0; i < programs.length; i++) {
		html += '<option value="'+programs[i].progId+'">'
		+ programs[i].name
		+ '</option>';
			}
		}
		$("#progId")
		.html(html);},
		error : function(
		data) {
		alert("error");}
		});
		});

		});
	</script>

	
	<%--Additional Field Ajax --%>
	
	<script type="text/javascript">
		$(document).ready(function() {
		"use strict";
		$("#deptId").on('change',function() {
		var departmentId = $(this).val();
		if (departmentId == 0) {
		alert("Please select a valid department");
		return false;
		}
		$.ajax({
		type : 'GET',
		url : '/springmvc/getAdditionalField.html',
		data : {
			departmentId : departmentId
				},
		cache : false,
		dataType : 'json',
		beforeSend : function() {	},
		success : function(	data) {
			$("#ajaxAdditionalFields").html("");
			var html = "";
			if(data.additionalFieldsReposnse[0].length > 0){
				var additionalFields = data.additionalFieldsReposnse[0];
				
				for(var i = 0; i < additionalFields.length; i++){
					if((additionalFields[i].type).toLowerCase() == "file"){
				
					html += '<br/><label>'+additionalFields[i].name +':</label><br/><input name="uploadfile[]" type="'+additionalFields[i].type+'"/>';
					 html += '<input type="hidden" name="uploadFileFieldName[]" value='+additionalFields[i].name +'>'; 
					 html += '<input type="hidden" name="addfieldPair[]" value='+additionalFields[i].id+':'+additionalFields[i].type+' />'; 

					}
					else if((additionalFields[i].type).toLowerCase() == "text"){
					html += '<br/><label>'+additionalFields[i].name +':</label><br/><input name="textvalue[]" type="'+additionalFields[i].type+'" />';
					html += '<input type="hidden" name="TextFieldName[]" value='+additionalFields[i].name +'>'; 
					html += '<input type="hidden" name="addfieldPair[]" value='+additionalFields[i].id+':'+additionalFields[i].type+' />'; 

						
					}
					else if((additionalFields[i].type).toLowerCase() == "number"){
					html += '<br/><label>'+additionalFields[i].name +':</label><br/><input name="numbervalue[]" type="'+additionalFields[i].type+'" />';
					html += '<input type="hidden" name="NumberFieldName[]" value='+additionalFields[i].name +'>'; 
					html += '<input type="hidden" name="addfieldPair[]" value='+additionalFields[i].id+':'+additionalFields[i].type+' />'; 

						
					}
					
					
					
					
				}
				
				
			}	
			$("#ajaxAdditionalFields").html(html);
		},
		error : function(
		data) {
		alert("error");}
		});
		});

		});
	</script>
	
	
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

<script>
var counter = 1;
function getnew()
{
	//form.myButton.disabled = true;
var edu ="<div class='well'><strong>Educational Background #"+(counter+1)+"<strong>";
edu+="<br/><br/><b>University</b>:<input type='text' class='form-control' name='university[]' placeholder='Univerisity...'>";
edu+="<b>Degree </b>:<input type='text' class='form-control' name='degree[]' placeholder='Degree...'> ";

edu+= "<b>Major</b>:<input type='text' class='form-control' name='major[]'  placeholder='Major...' > ";
edu+="<b>Start Date</b>: <input type='text' class='form-control' name='startDate[]' placeholder='m/d/yy...' id='datepicker1'> ";
edu+= "<b>End	Date</b>: <input type='text' class='form-control' name='endDate[]' id='datepicker2' placeholder='m/d/yy...'></div>";

counter =counter + 1;
$("#addnew").append(edu);
$("#addNewCount").val(counter);
}
</script>

	<jsp:include page="includes/footer.jsp" />
</body>

</html>
