<%@ page import="mum.edu.webstore.WebStoreAppCtxHolder" %>
<%@ page import="mum.edu.webstore.service.UserService" %>
<%@ page import="mum.edu.webstore.service.CustomerService" %>
<%@ page import="mum.edu.webstore.model.Customer" %>
<%@ page import="mum.edu.webstore.model.Cart" %>
<%@ page import="mum.edu.webstore.model.User" %>
<% 
CustomerService customerService = WebStoreAppCtxHolder.getApplicationContext().getBean(CustomerService.class);
String name = request.getUserPrincipal() != null ? request.getUserPrincipal().getName() : "";
Customer customer = customerService.getByEmail(name.toString());
if(customer != null)
{
	Cart cart = customer.getCart();
	session.setAttribute("cartItems", cart.getCartItems().size());
	request.setAttribute("cart", cart);
	session.setAttribute("cartsession",cart);
}


%>
<div class="header-top">
	<div class="wrap">
		<div class="header-top-left">
			<div class="box">
				<select tabindex="4" id="language" class="dropdown">
					<option value="" class="label" value="">Language :</option>
					<option value="en">English</option>
					<option value="fr">French</option>
					<option value="ur">Urdu</option>
				</select>
			</div>
			<div class="box1">
				<select id="currency" tabindex="4" class="dropdown">
					<option value="" class="label" value="">Currency :</option>
					<option value="1">$ Dollar</option>
					<option value="2">€ Euro</option>
				</select>
			</div>
			<div class="clear"></div>
		</div>
		<div class="cssmenu">
			<ul>
				<li class="active"><a href="/login">Account</a></li> |
				<li><a href="/wishlist">Wishlist</a></li> |
				<% if(customer!=null && customer.getCart().getCartItems().size() > 0){ %>
				<li><a href="/checkout">Checkout</a></li> |
				<% } %>
				<%   if(name != ""){
					   UserService userService = WebStoreAppCtxHolder.getApplicationContext().getBean(UserService.class);
					   User user = userService.findByUsername(name);
					   if(user != null)
					   name = user.getCustomer().getFirstName();
				%>
				<li><a href="/profile"><%=name %><%request.setAttribute("name",name); %></a></li> |
				<li>
			       
<form action="/logout"
	method="post">
<input type="submit"
	value="Log out" />
<input type="hidden"
	name="${_csrf.parameterName}"
	value="${_csrf.token}"/>
</form></li> |
				<% } else { %>
				<li><a href="/login">Log In</a></li> | 
				<% } %>
				<li><a href="/registration">Sign Up</a></li>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
</div>