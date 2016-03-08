<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-default navbar-static-top" role="navigation"
	style="margin-bottom: 0">

<div class="navbar-header">
			<a class="navbar-brand"> 
			
					Welcome   ${loggedInUser.first_name} </a>
			</div>
  <div>
    <p></p>
  </div>
	<ul class="nav navbar-top-links navbar-right">
		<p style="margin-top: 4px; margin-right: 1cm;">
			
					<a href="<c:url value="logout.html" />"
				class="btn btn-danger square-btn-adjust" class="icon-bar">Logout</a>
		</p>
		
			</ul>

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">


						
						<!-- /.nav-second-level -->
						</li>
						<img border="0" src="assets/img/eagle.jpg"
					width="250" height="200" />
						<li><a href="<c:url value="#"/>"><i
						class="fa fa-table fa-fw"></i>Departments</a></li>
						<li><a href="Studentdashboard.html?id=${userid}"><i class="fa fa-edit fa-fw"></i>Applications</a>
						</li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>