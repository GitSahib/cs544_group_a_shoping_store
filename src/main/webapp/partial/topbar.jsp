<%@ page import="mum.edu.webstore.WebStoreAppCtxHolder" %>
<%@ page import="mum.edu.webstore.service.UserService" %>
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
				<li class="active"><a href="login">Account</a></li> |
				<li><a href="wishlist">Wishlist</a></li> |
				<li><a href="checkout">Checkout</a></li> |
				<% String name = request.getUserPrincipal() != null ? request.getUserPrincipal().getName():"";
				   if(name != ""){
					   UserService userService = WebStoreAppCtxHolder.getApplicationContext().getBean(UserService.class);
					   name = userService.findByUsername(name).getCustomer().getFirstName();
				%>
				<li><a href="profile"><%=name %></a></li> |
				<% } else { %>
				<li><a href="login">Log In</a></li> | 
				<% } %>
				<li><a href="registration">Sign Up</a></li>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
</div>