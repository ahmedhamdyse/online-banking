<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw</title>
<link rel="shortcut icon" type="image/png" href="image/favicon.png" />
<link rel="stylesheet" type="text/css" href="css/deposit.css">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row">
		<jsp:include page="header.jsp" />
	</div>
	<div class="container-fullwidth">
		<c:choose>
			<c:when test="${userDetails != null}">
				<div class="row" style="margin-top: 50px;">
					<div class="col-md-4 col-md-offset-4">
						<form role="form" method="post" action="WithdrawServlet">
							<h2>Withdraw Form</h2>
							<div class="col-md-12">
								<hr class="colorgraph">
							</div>
							<label class="col-md-4 control-label">Account No</label>
							<div class="col-sm-8 form-group">
								<input type="text" required placeholder="Enter Account No.."
									name="account_no" class="form-control"
									value="${userDetails.account_no}"
									readonly="readonly">
							</div>
							<label class="col-md-4 control-label">User Name</label>
							<div class="col-sm-8 form-group">
								<input type="text" required placeholder="Enter User Name.."
									name="username" class="form-control"
									value="${userDetails.username}"
									readonly="readonly">
							</div>

							<label class="col-md-4 control-label">Password</label>
							<div class="col-sm-8 form-group">
								<input type="password" required placeholder="Enter Password.."
									name="password" class="form-control">
							</div>

							<label class="col-md-4 control-label">Amount</label>
							<div class="col-sm-8 form-group">
								<input type="number" required placeholder="Enter Amount.."
									class="form-control" name="amount">
							</div>
							<div class="col-md-12">
								<hr class="colorgraph">
							</div>

							<c:if test="${notEnoughMoney}">
								<div class="col-md-12">
									<div class="alert alert-danger" role="alert">
										<strong>Sorry!</strong> You do not have enough money.
									</div>
								</div>
							</c:if>
							<!-- If password is wrong -->
							<c:if test="${notPassed}">
								<div class="col-md-12">
									<div class="alert alert-danger" role="alert">
										<strong>Sorry!</strong> Password incorrect.
									</div>
								</div>
							</c:if>
							<div class="row col-md-10 col-md-offset-1">
								<div class="col-xs-6 col-md-6">
									<input type="submit" value="Submit"
										class="btn btn-success btn-block btn-md" tabindex="7">
								</div>
								<div class="col-xs-6 col-md-6">
									<input class="btn btn-danger btn-block btn-md" type="reset"
										value="Reset">
								</div>
							</div>
						</form>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="row" style="margin-top: 150px;">
					<div class="alert alert-warning col-md-4 col-md-offset-4"
						role="alert">
						<strong>Warning!</strong> You have to login first.
					</div>
				</div>
			</c:otherwise>
		</c:choose>
		<!-- Footer start here -->
		<div class="row" style="margin-top: 50px;">
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>