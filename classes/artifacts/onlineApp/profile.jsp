<%@page import="onlinebanking.model.AccountModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${userDetails.first_name} {userDetails.last_name }</title>
<link rel="shortcut icon" type="image/png" href="image/favicon.png" />
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/profile.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/updateAmount.js"></script>
</head>
<body>
	<div class="row">
		<jsp:include page="header.jsp" />
	</div>

	<div class="container-fullwidth">
		<div class="jumbotron col-md-6 col-md-offset-3"
			style="margin-top: 50px">
			<div class="row">
				<div class="profile-head col-md-10 col-md-offset-1">
					<div class="col-md-4 ">
						<img class="img-circle img-responsive" alt="" src="image/user.png">
					</div>


					<div class="col-md-6 ">
						<h2>${userDetails.first_name} ${userDetails.last_name}</h2>
						<ul>
							<li class="navli"><span
								class="glyphicon glyphicon-map-marker"></span>
								${userDetails.branch}</li>
							<li class="navli"><span class="glyphicon glyphicon-home"></span>
								${userDetails.address}</li>
							<li class="navli"><span class="glyphicon glyphicon-phone"></span>${userDetails.phone_number}</li>
							<li class="navli"><span class="glyphicon glyphicon-envelope"></span>${userDetails.email}</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="account_details col-md-10 col-md-offset-1"
					style="margin-top: 30px;">
					<h2>Account Details</h2>
					<hr class="divider">
					<table class="table table-user-information col-md-6">
						<tbody>
							<tr>
								<td><b>First Name:</b></td>
								<td>${userDetails.first_name}</td>
							</tr>
							<tr>
								<td><b>Last Name:</b></td>
								<td>${userDetails.last_name}</td>
							</tr>
							<tr>
								<td><b>Account Number:</b></td>
								<td>${userDetails.account_no}</td>
							</tr>
							<tr>
								<td><b>City</b></td>
								<td>${userDetails.city}</td>
							</tr>
							<tr>
								<td><b>Branch Name</b></td>
								<td>${userDetails.branch}</td>
							</tr>
							<tr>
								<td><b>Zip</b></td>
								<td>${userDetails.zip}</td>
							</tr>
							<tr>
								<td><b>UserName</b></td>
								<td>${userDetails.username}</td>
							</tr>
							<tr>
								<td><b>Phone Number</b></td>
								<td>${userDetails.phone_number}</td>
							</tr>
							<tr>
								<td><b>Email</b></td>
								<td><a href="mailto:" ${userDetails.email}>${userDetails.email}</a></td>
							</tr>
							<tr>
								<td><b>Account Type</b></td>
								<td>${userDetails.account_type}</td>
							</tr>
							<tr>
								<td><b>Registration Date</b></td>
								<td>${userDetails.reg_date}</td>
							</tr>
							<tr>
								<td><b>Amount</b></td>
								<td><label id="amount">${userDetails.amount}</label>&#36;</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<div class="row"></div>

		<!-- Footer start here -->
		<div class="row" style="margin-top: 50px;">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>