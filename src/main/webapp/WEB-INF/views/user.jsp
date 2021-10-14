<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
table, th, td {
	border: 1px solid black;
	padding: 5px;
}
.error{color:red}
table {
	border-spacing: 15px;
}
</style>
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
	<h1>User</h1>
	<div class="container">
		<form:form action="orderstatus" method="post" modelAttribute="order">
			<table class="pizzaTable">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Pizza</th>
						<th scope="col">Small</th>
						<th scope="col">Medium</th>
						<th scope="col">Large</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pizza}" var="p">
						<tr>
							<th scope="row">${p.pizzaId}</th>
							<td><input type="radio" name="pizzaName" value="${p.name}">
								${p.name}</td>
								<td><form:errors path="pizzaName" cssClass="error"/></td>
								
							<td><input type="radio" name="pizzaPrice" value="${p.small}">
								${p.small}</td>
							<td><input type="radio" name="pizzaPrice" value="${p.medium}">
								${p.medium}</td>
							<td><input type="radio" name="pizzaPrice" value="${p.large}">
								${p.large}</td>
								<td><form:errors path="pizzaPrice" cssClass="error" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<table class="toppingTable">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Topping</th>
						<th scope="col">Price</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${topping}" var="t">
						<tr>
							<th scope="row">${t.id}</th>
							<td><input type="radio" name="toppingPrice"
								value="${t.price}"> ${t.name}</td>
								<td><form:errors path="toppingPrice" cssClass="error" /></td>
							
							<td><label for="price">${t.price}</label></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br> Enter name: <input type="text" name="payeeName"
				placeholder="enter name"><br>
			<form:errors path="payeeName" cssClass="error"/>
				
				  Your bill(INR): <input
				type="text" id="billAmount" name="billAmount" readonly="readonly"
				value="">
			<div class="btn-group p-5 ">
				<div>
					<input type="submit" value="Pay Bill">
				</div>
				<div style="margin-left: 10px;">
					<button type="button" onclick="checkButton()">Calculate
						Bill</button>
				</div>
			</div>
		</form:form>
	</div>
	<script>
		function checkButton() {
			var pizzaPrice = document
					.querySelector('input[name="pizzaPrice"]:checked');
			var toppingPrice = document
					.querySelector('input[name="toppingPrice"]:checked');

			const num1 = parseInt(pizzaPrice.value, 10)
					+ parseInt(toppingPrice.value, 10);

			if (pizzaPrice != null) {
				//document.getElementById("billAmount").innerHTML   
				//   =  num1 + " Rupee is your bill.";  
				document.getElementById("billAmount").value = document
						.getElementById("billAmount").value
						+ num1;
			} else {
				document.getElementById("billAmount").innerHTML = "*You have not selected any season";
			}
		}
	</script>
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