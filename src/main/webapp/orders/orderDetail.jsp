
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
					<th>Line Price</th>
			</tr>
			<c:forEach var="item" items="${order.orderItems}">
				<tr>
					<td>${item.product.name}</td>
					<td>${item.product.category.name}</td>
					<td>$${item.product.price}</td>
					<td><img src="${item.product.imageUrl}" /></td>
					<td>${item.quantity}</td>
					<td>$${item.total}</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
	
	<h3>Total Price: $${order.total}</h3>
	
	<h2>Shipping Address</h2>
	<div>
		<b>Street:</b> ${order.shippingAddress.street} <br/>
		<b>City:</b> ${order.shippingAddress.city} <br/>
		<b>State:</b> ${order.shippingAddress.state} <br/>
		<b>Zip:</b> ${order.shippingAddress.zip} <br/>
	
	</div>
	
	<h2>Payment</h2>
	<div>
		Payment type: ${order.paymentType} <br/>

	</div>
	
	<h2>Pay</h2>
	<c:if test="${not order.paid}">
		<div>
			<a href="/gateway/checkout/${order.id}">Pay Now</a>
		</div>
	</c:if>
	<c:if test="${order.paid}">
		<div>
			<h3 style="color:green">You have already paid for this order. thank you.</h3>
		</div>
	</c:if>
	
	<br/>
	<a href="/orderList">Return to order list</a>
</body>
</html>