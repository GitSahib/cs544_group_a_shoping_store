<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
  <title>FF Glasses Shop Checkout Transaction</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
   <link href="${contextPath}/resources/css/app.css" rel="stylesheet"
	type="text/css" media="all" />
	<link rel="icon" type="image/png" href="${contextPath}/resources/images/favicon.png" rel="stylesheet"
	type="text/css" media="all" />	
	<script type="text/javascript"
	src="${contextPath}/resources/javascript/vendor/jquery-2.1.4.min.js"></script>
	<script type="text/javascript"
	src="${contextPath}/resources/javascript/vendor/jquery.lettering-0.6.1.min.js"></script>
	<script type="text/javascript"
	src="${contextPath}/resources//javascript/demo.js"></script>
</head>
<body>
  <header class="main">
    <div class="container wide">
      <div class="content slim">
        <div class="set">
          <div class="fill">
            <a class="ffglassesshop" href="/">FF Glassess<strong>SHOP</strong></a>
          </div>

        </div>
      </div>
    </div>
  </header>

  <div class="wrapper">
    <div class="response container">
      <div class="content">
        <div class="icon">
        <% if( (boolean)request.getAttribute("isSuccess")) { %>
          <img th:if="${isSuccess}" src="/resources/images/success.svg" th:src="@{/images/success.svg}" alt="" />
        <%} else { %>
          <img th:if="${!isSuccess}" src="/resources/images/fail.svg" th:src="@{/images/fail.svg}" alt="" />
        <% } %>
        </div>
		<% if( (boolean)request.getAttribute("isSuccess")) { %>
        <div th:if="${isSuccess}">
          <h1>Sweet Success!</h1>
          <section>Your transaction has been successfully processed. See the Braintree API response and try again.</section>
        </div>
        <% } else { %>
        <div th:if="${isSuccess}">
          <h1>Transaction Failed</h1>
          <section>Your transaction has a status of <span>${transaction.getStatus()}"/>. See the Braintree API response and try again.</section>
        </div>
		<% } %>
        <section>
          <a class="button primary back" href="/index">
            <span>Order other Items</span>
          </a>
        </section>
      </div>
    </div>
  </div>

  <aside class="drawer dark">
    <article class="content compact">
    <section>
      <h5>Transaction</h5>
        <table cellpadding="0" cellspacing="0">
          <tbody>
            <tr>
              <td>id</td>
              <td>${transaction.getId()}</td>
            </tr>
            <tr>
              <td>type</td>
              <td>${transaction.getType()}</td>
            </tr>
            <tr>
              <td>amount</td>
              <td>${transaction.getAmount()}</td>
            </tr>
            <tr>
              <td>status</td>
              <td>${transaction.getStatus()}</td>
            </tr>
            
          </tbody>
        </table>
      </section>

      <section>
        <h5>Payment</h5>

        <table cellpadding="0" cellspacing="0">
          <tbody>
            <tr>
              <td>token</td>
              <td>${creditCard.getToken()}</td>
            </tr>
            <tr>
              <td>bin</td>
              <td>${creditCard.getBin()}</td>
            </tr>
            <tr>
              <td>last_4</td>
              <td>${creditCard.getLast4()}</td>
            </tr>
            <tr>
              <td>card_type</td>
              <td>${creditCard.getCardType()}</td>
            </tr>
            <tr>
              <td>expiration_date</td>
              <td>${creditCard.getExpirationDate()}</td>
            </tr>
            <tr>
              <td>cardholder_name</td>
              <td>${creditCard.getCardholderName()}</td>
            </tr>
            <tr>
              <td>customer_location</td>
              <td>${creditCard.getCustomerLocation()}</td>
            </tr>
          </tbody>
        </table>
      </section>

      <section th:if="${customer.getId()}" >
        <h5>Customer Details</h5>

        <table cellpadding="0" cellspacing="0">
          <tbody>
            <tr>
              <td>id</td>
              <td>${customer.getId()}</td>
            </tr>
            <tr>
              <td>first_name</td>
              <td>${customer.getFirstName()}</td>
            </tr>
            <tr>
              <td>last_name</td>
              <td>${customer.getLastName()}</td>
            </tr>
            <tr>
              <td>email</td>
              <td>${customer.getEmail()}</td>
            </tr>
            <tr>
              <td>company</td>
              <td>${customer.getCompany()}</td>
            </tr>
            <tr>
              <td>website</td>
              <td>${customer.getWebsite()}</td>
            </tr>
            <tr>
              <td>phone</td>
              <td>${customer.getPhone()}</td>
            </tr>
            <tr>
              <td>fax</td>
              <td>${customer.getFax()}</td>
            </tr>
          </tbody>
        </table>
      </section>

      <section>
        <p class="center small">Integrate with the Braintree a secure and seamless checkout</p>
      </section>
    </article>
  </aside>
</body>
</html>