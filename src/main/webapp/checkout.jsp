<jsp:include page="partial/taglib.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="mum.edu.webstore.model.Cart"%>
<%@ page import="mum.edu.webstore.model.CartItem"%>
<!DOCTYPE HTML>
<html>

<jsp:include page="partial/head.jsp"></jsp:include>
<link href="${contextPath}/resources/css/table.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="${contextPath}/resources/css/grid.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="${contextPath}/resources/css/input.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="${contextPath}/resources/css/panel.css" rel="stylesheet"
	type="text/css" media="all" />
	<style>
		.form-control,select
		{
			height:34px;
			padding:0px;
			padding-left:2px;
			
			margin:0px;
			width:89%;
			
		}
		.btn
		{
			width:90%;
		}
		.col-md-6
		{
			padding:0px;
			margin:0px;
		}
	</style>
<body>
	<jsp:include page="partial/topbar.jsp"></jsp:include>
	<jsp:include page="partial/topmenu.jsp"></jsp:include>
	
	<div class="container">
		<h4 class="title">Checkout:</h4>
		<%
			if (request.getAttribute("cart") == null
					|| ((Cart) request.getAttribute("cart")).getCartItems().size() == 0) {
		%>
		<h4 class="title">Shopping cart is empty</h4>
		<p class="cart">
			You have no items in your shopping cart.<br>Click<a
				href="/index"> here</a> to continue shopping
		</p>
		<%
			} else {
		%>
		<div class="top-box">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-warning">
						<div class="panel-heading">
							<h1 class="panel-title">Cart Items</h1>
						</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<tr>
										<th>Product</th>
										<th>Name</th>
										<th>Price</th>
										<th>Quantity</th>
										<th>Total</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${cart.cartItems}" var="item">
										<tr>
											<td>${item.product.imageUrl}</td>
											<td>${item.product.name}</td>
											<td>${item.product.price}</td>
											<td>${item.quantity}</td>
											<td>${item.totalPrice}</td>
										</tr>
									</c:forEach>

								</tbody>

							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h1 class="panel-title">Enter Shipment Address and place and
								Order</h1>
						</div>
						<div class="panel-body">
							
							<form:form action="/order" method="POST" modelAttribute="order">
								
								<div class="col-md-6">
									<label>Street: </label>
									<form:input path="shippingAddress.street" class="form-control" />
									<form:errors path="shippingAddress.street" style="color:red"></form:errors>
								</div>
								<div class="col-md-6">
									<label>State: </label>
									<form:select id="state" path="empty" class="form-control">
									</form:select>
								</div>
								<div class="clear"></div>
								<div class="col-md-6">
									<label>City:</label>
									<form:select id="city" path="empty" class="form-control">
									</form:select>
								</div>
								<div class="col-md-6">
									<form:hidden id="hiddenCountry" path="shippingAddress.country" />
									<form:hidden id="hiddenState" path="shippingAddress.state" />
									<form:hidden id="hiddenCity" path="shippingAddress.city" />
									<label>Zip: </label>
									<form:input path="shippingAddress.zip" class="form-control" />
									<form:errors path="shippingAddress.zip" style="color:red"></form:errors>
								</div>
								<div class="clear"></div>
								<div class="col-md-6">
									<label>PaymentType: </label>
									<form:select path="paymentType" class="form-control">
										<form:options items="${paymentTypes}" />
									</form:select>
								</div>
								<div class="col-md-6" style="margin-top:20px">
									<input type="submit" class="btn btn-primary"
										value="Place Order"
										onclick="updateHiddenFields(); return true;" />
								</div>
							</form:form>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<%
			}
		%>
	</div>

	<div class="clear"></div>
	<jsp:include page="partial/footer.jsp"></jsp:include>
</body>

<script type="text/javascript">
	$(document).ready(function() {

		$("#state").change(onStateChange);
		getStateList();
	});

	function getStateList() {
		$('#state').empty();
		$.get("address/allstates", function(data) {
			$.each(data, function(i, item) {
				$('#state').append($('<option>', {
					value : item.code,
					text : item.name
				}));
			});
			$('#state').trigger('change');
		}, "json");
	}

	function onStateChange() {

		var selected = $("#state option:selected");
		$('#city').empty();
		$.get("address/cities/" + selected.val(), function(data) {
			$.each(data, function(i, item) {
				$('#city').append($('<option>', {
					value : item.id,
					text : item.name
				}));
			});
			$('#city').trigger('change');
		}, "json");
	}

	function updateHiddenFields() {
		var selectedCountry = $("#country option:selected");
		var selectedState = $("#state option:selected");
		var selectedCity = $("#city option:selected");

		$('#hiddenCountry').val(selectedCountry.text());
		$('#hiddenState').val(selectedState.text());
		$('#hiddenCity').val(selectedCity.text());

	}
</script>
</html>
