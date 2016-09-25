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
</head>
<body>
	<h1>Edit Product</h1>
	
	<form:form action="/admin/products/${product.id}" method="POST" modelAttribute="product">
		ID: <form:input path="id" placeholder="ID" disabled="true"/> <br/>
		Name: <form:input path="name" placeholder="Name"/> <br/>
		Category: <form:select path="category">
			<form:options items="${productCategories}" itemValue="id" itemLabel="name"/>
		</form:select> <br/>
		Description: <form:input path="description" placeholder="Description"/> <br/>
		Price: <form:input path="price" placeholder="Price"/> <br/>
		
		<br/>
		Stock: <form:input path="stockNumber" placeholder="Stock"/> <br/>
		
		
		<br/>
		<input type="submit" value="Submit"/>
	</form:form>
	
	<a href="/admin/products">Back To Product List</a>
</body>
</html>