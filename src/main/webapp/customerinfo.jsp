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
            <h4 class="title">Customer Information</h4>
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
                        <form:input type="hidden" placeholder="EMail" path="email" />
                    </div>            
               
                </div>
                <div class="col_1_of_2 span_1_of_2">
                    <div>
                        <form:input type="text" path="street" placeholder="Street Address with ZipCode" />
                        <div class="clear"></div><label class="error"><form:errors path="street"></form:errors></label>
                    </div>
                    <div>                   
                        <form:select id="state" path="state"   onchange="change_country(this.value)" class="frm-field required" >
                            <option value="IOWA">IOWA</option>
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
					</div>
                
                    </div>
               
                <div class="clear"></div>
            </form:form>
        </div>
    </div>
    <jsp:include page="partial/footer.jsp"></jsp:include>
</body>
</html>