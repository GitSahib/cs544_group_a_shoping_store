<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE HTML>
<html>
<head>
    <title>FF Glasses Shop Checkout</title>
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
            <a class="ffglassesshop" href="/">FF Glasses<strong>SHOP</strong></a>
          </div>
        </div>
      </div>
    </div>
    <div class="notice-wrapper">
      <div class="show notice error notice-error" th:if="${errorDetails}">
        <span class="notice-message" th:text="${errorDetails}"></span>
      </div>
    </div>
  </header>

  <div class="wrapper">
    <div class="checkout container">
      <header>
        <p>
          Make a payment with Braintree using PayPal or a card
        </p>
      </header>
	  <form:form method="POST" action="/gateway/checkoutorder/${order.id}" modelAttribute="checkoutForm" class="form-signin">
       <section>
          <div class="bt-drop-in-wrapper">
            <div id="bt-dropin"></div>
          </div>

            <label for="amount">
              <span class="input-label">Amount</span>
              <div class="input-wrapper amount-wrapper">
                <input id="amount" name="amount" readonly type="tel" min="1" 
                placeholder="Amount" value="<%=request.getAttribute("amount") %>" />
              </div>
            </label>
          </section>

        <button class="button" type="submit"><span>Confirm Transaction</span></button>
      </form:form>
    </div>
  </div>

  <script src="https://js.braintreegateway.com/js/braintree-2.27.0.min.js"></script>
  <script>
    /*<![CDATA[*/
    var checkout = new Demo({
      formID: 'payment-form'
    })

    var client_token = "${clientToken}";
    braintree.setup(client_token, "dropin", {
      container: "bt-dropin"
    });
    /*]]>*/
  </script>
</body>
</html>