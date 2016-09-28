<jsp:include page="partial/taglib.jsp"></jsp:include>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE HTML>
<html>
<jsp:include page="partial/head.jsp"></jsp:include>
<body>
    <jsp:include page="partial/topbar.jsp"></jsp:include>
    <jsp:include page="partial/topmenu.jsp"></jsp:include>
    <div class="register_account">
        <div class="wrap">
            <h4 class="title">Create an Account</h4>
            <form:form method="POST" modelAttribute="customerForm" class="form-signin">
            <div class="col_1_of_2 span_1_of_2">
                    <div>
                        <form:input type="text" placeholder="First Name" path="firstName" />
                        <div class="clear"></div><label class="error"><form:errors path="firstName"></form:errors></label>
                    </div>
                    <div>
                        <form:input type="text" placeholder="Last Name" path="lastName" />
                        <div class="clear"></div><label class="error"><form:errors path="lastName"></form:errors></label>
                    </div>                  
                    <div>
                        <form:input type="text" onblur="$('#username').val(this.value);" onchange="$('#username').val(this.value);" placeholder="EMail" path="email" />
                        <form:input type="hidden" id="username" path="username" />
                        <div class="clear"></div><label class="error"><form:errors path="email"></form:errors></label>
                    </div>
                    
                    <div>
                        <form:input type="password" placeholder="password" path="password" />
                        <div class="clear"></div><label class="error"><form:errors path="password"></form:errors></label>
                    </div>
                    <div>
                        <form:input type="password" placeholder="Confirm Password" path="passwordConfirm" />
                        <div class="clear"></div><label class="error"><form:errors path="passwordConfirm"></form:errors></label>
                    </div>
                </div>
                <div class="col_1_of_2 span_1_of_2">
                    <div>
                        <form:input type="text" path="street" placeholder="Street Address with ZipCode" />
                        <div class="clear"></div><label class="error"><form:errors path="street"></form:errors></label>
                    </div>
                    <div>                   
                       <form:select path="state">
						  <c:forEach items="${states}" var="state">
						    <option value="${state.code}">
						        ${state.name}
						    </option>
						  </c:forEach>
						</form:select>
                        <div class="clear"></div><label class="error"><form:errors path="state"></form:errors></label>
                    </div>
                    <div>
                        <form:input type="text" path="city" placeholder="City" />
                        
                        <div class="clear"></div><label class="error"><form:errors path="city"></form:errors></label>
                    </div>
                    <div>
                    	 <form:input type="text" path="phoneNumber" placeholder="Phone Number" />
                    	 <div class="clear"></div><label class="error"><form:errors path="phoneNumber"></form:errors></label>
                
                    </div>
                    <div>
	                    <button class="grey">Submit</button>
						<p class="terms">
							By clicking 'Create Account' you agree to the <a href="#">Terms
								&amp; Conditions</a>.
						</p>
					</div>
                
                    </div>
               
                <div class="clear"></div>
            </form:form>
        </div>
    </div>
    <jsp:include page="partial/footer.jsp"></jsp:include>
</body>
</html>