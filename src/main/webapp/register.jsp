<jsp:include page="partial/taglib.jsp"></jsp:include>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE HTML>
<html>
<jsp:include page="partial/head.jsp"></jsp:include>
<body>
    <jsp:include page="partial/topbar.jsp"></jsp:include>
    <jsp:include page="partial/topmenu.jsp"></jsp:include>
    <div class="register_account">
        <div class="wrap">
            <h4 class="title">Create an Account</h4>
            <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <div class="col_1_of_2 span_1_of_2">
                                    
                    <div>
                        <form:input type="email" id="username" path="username" placeholder="User Name" />
                        <div class="clear"></div>
                        <label class="error">
                        	<form:errors path="username"></form:errors>
                        </label>
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