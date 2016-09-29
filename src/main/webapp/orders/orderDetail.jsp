
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/partial/head.jsp"></jsp:include>
<link href="${contextPath}/resources/css/table.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="${contextPath}/resources/css/panel.css" rel="stylesheet"
	type="text/css" media="all" />

<body>
	<jsp:include page="/partial/topbar.jsp"></jsp:include>
	<jsp:include page="/partial/topmenu.jsp"></jsp:include>

	<div class="container">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Order Details Order ID: ${order.id} , <c:choose>
								<c:when test="${not order.paid}">
										<label class="label label-danger">Not Paid</label>
										<a class="btn btn-warning" href="/gateway/checkout/${order.id}">Pay Now</a>
									
								</c:when>
								<c:otherwise>
									
										<span class="btn btn-success">Paid</span>
									
								</c:otherwise>
							</c:choose></h3>
			</div>
		</div>
		<div class="clear"></div>

		<div class="clear"></div>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3 class="panel-title">Items:</h3>
			</div>
			<div class="panel-body">
				<table class="table" valign="center">
					<tr>
						<th>Product</th>
						<th>Name</th>
						<th>Category</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Line Price</th>
					</tr>
					<c:forEach var="item" items="${order.orderItems}">
						<tr>
							<td><img width="80" src="${item.product.imageUrl}" /></td>
							<td>${item.product.name}</td>
							<td>${item.product.category.name}</td>
							<td>$${item.product.price}</td>

							<td>${item.quantity}</td>
							<td>$${item.total}</td>
						</tr>
					</c:forEach>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>Grand Total:</td>
						<td>$${order.total}</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3 class="panel-title">Shipping Address</h3>
			</div>
			<div class="panel-body">
				<table class="table" valign="center">
					<tr>
						<th>Street</th>
						<th>City</th>
						<th>State</th>
						<th>Zip</th>
					</tr>
					<tr>
						<td>${order.shippingAddress.street}</td>
						<td>${order.shippingAddress.city}</td>
						<td>${order.shippingAddress.state}</td>
						<td>${order.shippingAddress.zip}</td>
					</tr>
				</table>
				
				<a class="btn btn-success" href="/orderList">Return to order
					list</a>
			</div>
		</div>
	</div>


	<div class="clear"></div>
	<jsp:include page="/partial/footer.jsp"></jsp:include>
</body>
</html>