<jsp:include page="partial/taglib.jsp"></jsp:include>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="mum.edu.webstore.model.Cart"%>
<%@ page import="mum.edu.webstore.model.CartItem"%>
<!DOCTYPE HTML>
<html>
<jsp:include page="partial/head.jsp"></jsp:include>
<link href="${contextPath}/resources/css/table.css" rel="stylesheet"
	type="text/css" media="all" />
<body>
	<jsp:include page="partial/topbar.jsp"></jsp:include>
	<jsp:include page="partial/topmenu.jsp"></jsp:include>
	<div class="main">
		<div class="wrap">
			<div class="section group">
				<div class="cont span_2_of_3">
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

					<h2 class="head">Your Cart</h2>
					<div class="top-box">
						<%
							for (CartItem item : ((Cart) request.getAttribute("cart")).getCartItems()) {
						%>
						<div class="col_1_of_3 span_1_of_3">
							<a href="/single">
								<div class="inner_content clearfix">
									<div class="product_image">
										<img src="${contextPath}/resources/images/products/pic.jpg"
											alt="" />
									</div>
								</div>
							</a>
							<div class="sale-box">
								<span class="on_sale title_shop">$<%=item.getProduct().getPrice()%></span>
							</div>
							<div class="price">
								<div>
									<p class="title">
										Product Name:<%=item.getProduct().getName()%></p>
									<div class="price1">
										<span class="actual">Quantity:<%=item.getQuantity()%></span>
										<a class="btn btn-sm btn-danger pull-right"
										href="/customer/cart/removeItem/<%=item.getId()%>"><i class="fa fa-times"></i></a>
									</div>
									<div class="price1">
										<span class="actual">Total:<%=item.getTotalPrice()%>
										</span>
									</div>
									
								</div>

								<div class="clear"></div>
							</div>
						</div>

						<%
							}
						%>
						
						<div class="clear"></div>
					<hr/>
				<div class="col_3_of_3 span_3_of_3">
		<form:form action="/order" method="POST" modelAttribute="order">
			<h1>Shipping address</h1>
			Street: <form:input path="shippingAddress.street"/>  <form:errors path="shippingAddress.street" style="color:red"></form:errors> <br/>
			State: <form:select id="state" path="empty">
			</form:select> <br/>
			City: <form:select id="city" path="empty">
			</form:select> <br/>
			
			<form:hidden id="hiddenCountry" path="shippingAddress.country" />
			<form:hidden id="hiddenState" path="shippingAddress.state" />
			<form:hidden id="hiddenCity" path="shippingAddress.city" />
			
			
			Zip: <form:input path="shippingAddress.zip"/> <form:errors path="shippingAddress.zip" style="color:red"></form:errors> <br/>
			<h3>Payment</h3>
 			PaymentType: <form:select path="paymentType">
 				<form:options items="${paymentTypes}"/>
 			</form:select> <br/>
<hr/>
			<input type="submit" value="Place Order" onclick="updateHiddenFields(); return true;"/>
			
		</form:form>
	</div>
	
					</div>


					<%
						}
					%>
				</div>

			</div>
			
			
<!-- 			<div class="rsidebar span_1_of_left"> -->
<!-- 				<a class="btn btn-block btn-warning" href="/gateway/">Proceed to Checkout</a> -->
<%-- 				<a class="btn btn-block btn-success"">Grand Total: ${cart.grandTotal}</a> --%>
<!-- 			</div> -->
		</div>
	</div>
	<div class="clear"></div>
	<jsp:include page="partial/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="${contextPath}/resources/js/jquery1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#state").change(onStateChange);
		getStateList();
	});

	function getStateList() {
 		$('#state').empty();
 		$.get( "address/allstates", function( data ) {
	 			$.each(data, function (i, item) {
	 			    $('#state').append($('<option>', { 
	 			        value: item.code,
	 			        text : item.name 
	 			    }));
	 			});
	 			$('#state').trigger('change');
 			}, "json" );
	}

	function onStateChange() {
		
			var selected = $("#state option:selected");
			$('#city').empty();
			$.get( "address/cities/" + selected.val(), function( data ) {
	 			$.each(data, function (i, item) {
	 			    $('#city').append($('<option>', { 
	 			        value: item.id,
	 			        text : item.name 
	 			    }));
	 			});
	 			$('#city').trigger('change');
				}, "json" );
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
