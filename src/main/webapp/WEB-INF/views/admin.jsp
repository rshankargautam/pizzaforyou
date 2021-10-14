<!doctype html>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
  <head>
  <style>
table, th, td {
	border: 1px solid black;
	padding: 5px;
}

table {
	border-spacing: 15px;
}
</style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
    <div class="container">
		<div class="card mx-auto mt-5 bg-primary" style="width: 70%;">
			<div class="card-body">
				<form	action="search" class="m-4">
					<div class="container text-center mb-3" >
						<input type="button" class="btn btn-outline-light"
						 onclick="location.href='pizza'" value="Pizza" >
					</div>
					<div class="container text-center mb-3">
						<input type="button" class="btn btn-outline-light"
						 onclick="location.href='topping'" value="Topping" >
					</div>
					<div class="container text-center mb-3">
						<input type="button" class="btn btn-outline-light"
						 onclick="location.href='listpizza'" value="List Pizza" >
					</div>
					<div class="container text-center mb-3">
						<input type="button" class="btn btn-outline-light"
						 onclick="location.href='listtopping'" value="List Topping" >
					</div>
					<div class="container text-center mb-3">
						<input type="button" class="btn btn-outline-light"
						 onclick="location.href='listorder'" value="List Orders" >
					</div>
				</form>
			</div>
		</div>
		<br>
		<hr>
		<div class="showlist">
			<table class="pizzaTable">
				<thead>
					<tr>
						<th scope="col">Pizza Id</th>
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
							<td><label for="name"> ${p.name}</label></td>
							<td><label for="small"> ${p.small}</label></td>
							<td><label for="medium"> ${p.medium}</label></td>
							<td><label for="large"> ${p.large}</label></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<hr>
			<table class="toppingTable">
				<thead>
					<tr>
						<th scope="col">Topping Id</th>
						<th scope="col">Topping</th>
						<th scope="col">Price</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${topping}" var="t">
						<tr>
							<th scope="row">${t.id}</th>
							<td><label for="name"> ${t.name}</label></td>
							<td><label for="price">${t.price}</label></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<hr>
			<table class="orderTable">
				<thead>
					<tr>
						<th scope="col">Order Id</th>
						<th scope="col">Payee Name</th>
						<th scope="col">Bill Amount</th>
						<th scope="col">Pizza Name</th>
						<th scope="col">Pizza Price</th>
						<th scope="col">Topping Price</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${order}" var="o">
						<tr>
							<td><label for="orderId">${o.orderId}</label></td>
							<td><label for="payeeName">${o.payeeName}</label></td>
							<td><label for="billAmount">${o.billAmount}</label></td>
							<td><label for="pizzaName">${o.pizzaName}</label></td>
							<td><label for="pizzaPrice">${o.pizzaPrice}</label></td>
							<td><label for="toppingPrice">${o.toppingPrice}</label></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
	</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>