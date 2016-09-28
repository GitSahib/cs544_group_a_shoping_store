<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-spring4-4.dtd">
<html >
<%@ page import="java.lang.StackTraceElement"%>
<head></head>

<body>
	<h1>Support Friendly Error Page</h1>
    <% if (request.getAttribute("url")!=null) { %>
		<b>Page:</b> Page Url ${url} </span>
	<% } %>
	 <% if (request.getAttribute("timestamp")!=null) { %>
		<b>Page:</b> <b>Occurred:</b> <span>${timestamp}</span>
	 <% } %>
	 <% if (request.getAttribute("status")!=null) { %>
		<b>Page:</b> <b>Status:</b> <span>${status}</span><span>code:${error}</span>
	 <% } %>
	<p>Application has encountered an error. Please contact support on
		...</p>

	<p>Support may ask you to right click to view page source.</p>
    </div>
	<div>${url}</div>
	<ul>
	
	</ul>
</body>
</html>