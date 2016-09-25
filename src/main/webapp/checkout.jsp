<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<jsp:include page="partial/head.jsp"></jsp:include>
<body>
	<jsp:include page="partial/topbar.jsp"></jsp:include>
	<jsp:include page="partial/topmenu.jsp"></jsp:include>
	<div class="register_account">
		<div class="wrap">
		<c:if test="${cart.isEmpty}">
			<h4 class="title">Shopping cart is empty</h4>
			<p class="cart">
				You have no items in your shopping cart.<br>Click<a
					href="index"> here</a> to continue shopping
			</p>
		</c:if>
		
		<table border="1">
			<tr>
				<th>Product</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${cart.items}" var="item">
				<tr>
					<td>${item.product.name}</td>
					<td>${item.product.price}</td>
					<td>${item.quantity}</td>
				</tr>
			</c:forEach>
		</table>

		<div>
		Total Price: $${cart.totalPrice}
		</div>
		
		<form action="/order">
			<input type="submit" value="Place Order" title="">
		</form>
							
		</div>
	</div>
	<jsp:include page="partial/footer.jsp"></jsp:include>
</body>
</html>