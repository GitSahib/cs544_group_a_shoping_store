<jsp:include page="partial/taglib.jsp"></jsp:include>
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
						
					</div>


					<%
						}
					%>
				</div>

			</div>
			<div class="rsidebar span_1_of_left">
				<a class="btn btn-block btn-warning" href="/gateway/">Proceed to Checkout</a>
				<a class="btn btn-block btn-success"">Grand Total: ${cart.grandTotal}</a>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<jsp:include page="partial/footer.jsp"></jsp:include>
</body>
</html>