<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Graduate Application</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">



<script>
function validateForm() {
    var x = document.forms["myForm"]["email"].value;
    var temp2 = x.lastIndexOf(".");
    var temp1 = x.indexOf("@");
    if (temp1<1 || temp2<temp1+2 || temp2+2>=x.length) {
        alert("Not a valid e-mail address");
        return false;
    
    }
    
}
</script>

<script type="text/javascript">
 
if((document.getElementById('bereich').value).length==0)
	
</script>


</head>

<body>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>
							<strong>Graduate Application</strong> Registration
						</h1>
						<div class="description">
							<p></p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3>Register</h3>
								<p></p>
							</div>
							<div class="form-top-right">
								<i class="fa fa-lock"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form:form modelAttribute="registeruser" role="form"
								id="example-form" name="myForm"
								onsubmit="return validateForm();">

								<div class="form-group">
									<label class="sr-only" for="form-username">FirstName</label>

									<form:input path="first_name"
										data-validation="length alphanumeric"
										data-validation-length="min1" name="form-firstname"
										placeholder="first name..." class="form-username form-control" />

								</div>

								<div class="form-group">
									<label class="sr-only" for="form-username">LastName</label>

									<form:input path="last_name"
										data-validation="length alphanumeric"
										data-validation-length="min1" name="form-lastname"
										placeholder="last name..." class="form-username form-control" />
								</div>



								<div class="form-group">
									<label class="sr-only" for="form-username">Email</label>


									<form:input path="email" name="email" placeholder="Email..."
										class="form-username form-control" />
								</div>


									<c:if test="${not empty error}">
									<p>This Email id is already registered </p>
								</c:if>
						


								<div class="form-group">
									<label class="sr-only" for="form-password">Password</label>

									<form:password path="password" name="fname" id="inputExample"
										placeholder="Password..." class="form-password form-control" required = "required" />

									<br />
								</div>
								<button type="submit" id="check" class="btn">Sign in!</button>

								<br />
								<p>
									Already a member?<a href="login.html?id=0">Login here</a>
								</p>
							</form:form>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 social-login">
						<h3></h3>
						<div class="social-login-buttons"></div>
					</div>
				</div>
			</div>
		</div>

	</div>


	<!-- Javascript -->
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/scripts.js"></script>


	<script src="<c:url value="assets/js/jquery-1.11.1.min.js" />"></script>

	<script src="<c:url value="assets/bootstrap/js/bootstrap.min.js" />"></script>

	<script src="<c:url value="assets/js/jquery.backstretch.min.js"/>"></script>

	<script src="<c:url value="assets/js/scripts.js" />"></script>

	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/jquery.form-validator.min.js"></script>
	<script>
		$.validate();
	</script>
</body>

</html>