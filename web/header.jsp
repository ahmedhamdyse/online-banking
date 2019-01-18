<%@page import="onlinebanking.model.AccountModel"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/header_css.css">
</head>
<div class="container-fullwidth">
	<div class="row hidden-xs topper">
		<div class="col-xs-7 col-sm-7">
			<a href="index.jsp"><img am-TopLogo alt="SECUREVIEW"
				src="image/wapbank.png" class="img-responsive"></a>
		</div>
	</div>
	<!-- End Topper -->
	<!-- Navigation -->
	<div class="row">
		<nav class="navbar navbar-inverse" role="navigation" style="margin-bottom: 0px;">
		<div class="container">

			<%!AccountModel ac = null;%>

			<%
				ac = (AccountModel) session.getAttribute("userDetails");
			%>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav js-nav-add-active-class">
					<li><a href="index.jsp">Home</a></li>
					<%
						if (ac == null) {
					%>
					<li><a href="create_account.jsp">Create new account</a></li>
					<%
						}
					%>
					<li><a href="deposit.jsp">Deposit</a></li>
					<li><a href="withdraw.jsp">Withdraw</a></li>
					<li><a href="transfer.jsp">Transfer</a></li>
					<li><a href="about.jsp">About Us</a></li>
						</ul></li>
				</ul>

				<!-- If user is logged in this menu will be shown -->


				<%
					if (ac != null) {
				%>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> <span class="glyphicon glyphicon-user"></span>
							<strong><%=ac.getUsername()%></strong> <span
							class="glyphicon glyphicon-chevron-down"></span>
					</a>
						<ul class="dropdown-menu">
							<li>
								<div class="navbar-login">
									<div class="row">
										<div class="col-md-4">
											<p class="text-center">
												<span class="glyphicon glyphicon-user icon-size"></span>
											</p>
										</div>
										<div class="col-md-8">
											<p class="text-left">
												<strong><%=ac.getFirst_name() + " " + ac.getLast_name()%></strong>
											</p>
											<p class="text-left small"><%=ac.getEmail()%>
											</p>
											<p class="text-left">
												<a href="profile.jsp"
													class="btn btn-primary btn-block btn-sm">Profile</a>
											</p>
										</div>
									</div>
								</div>
							</li>
							<li><a href="logout.jsp">Sign Out<span
									class="glyphicon glyphicon-log-out pull-right"></span></a></li>
						</ul></li>
				</ul>
				<!-- End User menu -->
				<%
					} else {
				%>
				<ul class="nav navbar-nav navbar-right hidden-xs">
					<a type="button" class="navbar-btn btn btn-primary"
						am-latosans="bold" href="login.jsp">Login</a>
				</ul>
				<%
					}
				%>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		</nav>
	</div>
</div>
</html>