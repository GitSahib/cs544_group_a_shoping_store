<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/partial/taglib.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<h3 class="panel-title">My Orders</h3>
			</div>
			<div class="panel-body">
				<table class="table" width="100%">
					<tr>
						<th>ID</th>
						<th>Items</th>
						<th>Total Price</th>
						<th>Url</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
					<c:forEach var="order" items="${orders}">
						<tr>
							<td>${order.id}</td>
							<td>${order.productSummary}</td>
							<td>$${order.total}</td>
							
							<td><a href="/orderDetail/${order.id}">Details</a></td>
							<td>${not order.paid?"Not Paid":"Paid"}</td>
							<td><c:if test="${not order.paid}">
									<a class="btn btn-warning" href="/gateway/checkout/${order.id}">Pay
										Now </a>
								</c:if> <a class="btn btn-info" href="/orders/edit/${order.id}">Edit
							</a> <a class="btn btn-danger" href="/orders/cancel/${order.id}">Cancel
							</a></td>

						</tr>
					</c:forEach>
				</table>
				<a href="/" class="btn btn-primary">Back to Home Page</a>
			</div>
		</div>
	</div>
	
	<div class="clear"></div>
	<jsp:include page="/partial/footer.jsp"></jsp:include>
</body>
</html>