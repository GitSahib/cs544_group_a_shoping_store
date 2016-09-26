<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Detail</title>
</head>
<body>
	
	
	<h1>Order Details</h1>
	<h2>Order ID: ${order.id}</h2>
	<div>
		<h3>Items:</h3>
		<table border="1">
			<tr>
					<th>Name</th>
					<th>Category</th>
					<th>Price</th>
					<th>Image</th>
					<th>Quantity</th>
			</tr>
			<c:forEach var="item" items="${order.orderItems}">
				<tr>
					<td>${item.product.name}</td>
					<td>${item.product.category.name}</td>
					<td>$${item.product.price}</td>
					<td><img src="${item.product.imageUrl}"/></td>
					<td>${item.quantity}</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
	
	<h3>Total Price: $${order.total}</h3>
	
	<h2>Shipping Address</h2>
	<div>
		Street: ${order.shippingAddress.street} <br/>
		City: ${order.shippingAddress.city} <br/>
		State: ${order.shippingAddress.state} <br/>
		Country: ${order.shippingAddress.country} <br/>
	
	</div>
	
	<br/>
	<a href="/orderList">Return to order list</a>
</body>
</html>