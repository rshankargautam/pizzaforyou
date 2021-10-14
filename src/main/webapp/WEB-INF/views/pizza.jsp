<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>
	<h1>In Pizza</h1>
	<div class="container">
		<div class="form-group">
			<form:form action="addpizza" method="post" modelAttribute="pizza">
				Pizza Name:		<input type="text" name="name" placeholder="enter Pizza name"> <br><br>
				<form:errors path="name" cssClass="error"/>
				
				Small Price: 	<input type="text" name="small" placeholder="enter small pizza price"><br><br>
				<form:errors path="small" cssClass="error"/>
				
				Medium Price: 	<input type="text" name="medium" placeholder="enter medium pizza price"> <br><br>
				<form:errors path="medium" cssClass="error"/>
				
				Large Price: 	<input type="text" name="large" placeholder="enter large pizza price"><br><br>
				<form:errors path="large" cssClass="error"/>
				
				<input type="submit" value="Add Pizza">
			</form:form>
		</div>
		<br>
		<hr>
		<div class="form-group">
			<form action="deletepizza" method="post">
				Pizza Name:		<input type="text" name="name" placeholder="enter Pizza name"> <br><br>
				<input type="submit" value="Delete Pizza">
			</form>
		</div>
		<br>
		<hr>
		<div class="form-group">
			<form action="updatepizza" method="post">
				Pizza Name:		<input type="text" name="name" placeholder="enter Pizza name"> <br><br>
				Small Price: 	<input type="text" name="small" placeholder="enter small pizza price"><br><br>
				Medium Price: 	<input type="text" name="medium" placeholder="enter medium pizza price"> <br><br>
				Large Price: 	<input type="text" name="large" placeholder="enter large pizza price"><br><br>
				<input type="submit" value="Update Pizza">
			</form>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>