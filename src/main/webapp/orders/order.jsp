<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${contextPath}/resources/js/jquery1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		getCountryList();
		$("#country").change(onCountryChange);
		$("#state").change(onStateChange);

		$('#state').trigger('change');

	});

	function getCountryList() {
 		$('#country').empty();
 		$.get( "address/countries", function( data ) {
	 			$.each(data, function (i, item) {
	 			    $('#country').append($('<option>', { 
	 			        value: item.id,
	 			        text : item.name 
	 			    }));
	 			});
	 			$('#country').trigger('change');
 			}, "json" );
	}
 
	function onCountryChange() {
	
 		var selected = $("#country option:selected");
 		
 		$('#state').empty();
 		$.get( "address/states/" + selected.val(), function( data ) {
	 			$.each(data, function (i, item) {
	 			    $('#state').append($('<option>', { 
	 			        value: item.id,
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
</head>
<body>
	
	<h1>New Order</h1>
	<div>
		<table border="1">
			<tr>
					<th>Name</th>
					<th>Category</th>
					<th>Price</th>
					<th>Image</th>
					<th>Quantity</th>
					<th>Subtotal</th>
			</tr>
			<c:forEach var="item" items="${cart.items}">
				<tr>
					<td>${item.product.name}</td>
					<td>${item.product.category.name}</td>
					<td>$${item.product.price}</td>
					<td><c:if test="${not empty item.product.imageUrl}"><img src="${item.product.imageUrl}"/></c:if></td>
					<td>${item.quantity}</td>
					<td>$${item.subTotal}</td>
				</tr>
			</c:forEach>
		</table>
		<br/>
		Total: $${cart.totalPrice}
	</div>
	<div>
		<form:form action="/order" method="POST" modelAttribute="order">
			<h3>Shipping address</h3>
			Street: <form:input path="shippingAddress.street"/> <br/>
			Country: <form:select id="country" path="empty">
				<form:options items="${countries}" itemValue="id" itemLabel="name"/>
			</form:select> <br/>
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
			<input type="submit" value="Submit" onclick="updateHiddenFields(); return true;"/>
			
		</form:form>
	</div>
	<br/>
</body>
</html>