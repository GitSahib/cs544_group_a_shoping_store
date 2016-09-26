<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order List</title>
</head>
<body>
	
	
	<h1>My Orders</h1>
	<div>
		<table border="1">
			<tr>
					<th>ID</th>
					<th>Items</th>
					<th>Total Price</th>
					<th>Details</th>
			</tr>
			<c:forEach var="order" items="${orders}">
				<tr>
					<td>${order.id}</td>
					<td>${order.productSummary}</td>
					<td>$${order.total}</td>
					<td><a href="/orderDetail/${order.id}">Details</a></td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
	
</body>
</html>