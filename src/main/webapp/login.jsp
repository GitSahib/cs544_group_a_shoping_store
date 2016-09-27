<jsp:include page="partial/taglib.jsp"></jsp:include>
<!DOCTYPE HTML>
<html>
<jsp:include page="partial/head.jsp"></jsp:include>
<body>
	<jsp:include page="partial/topbar.jsp"></jsp:include>
	<jsp:include page="partial/topmenu.jsp"></jsp:include>
	<div class="login">
		<div class="wrap">
			<div class="col_1_of_login span_1_of_login">
				<h4 class="title">New Customers</h4>
				<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed
					diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam
					erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci
					tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
					consequat. Duis autem vel eum iriure dolor in hendrerit in
					vulputate velit esse molestie consequat, vel illum dolore eu
					feugiat nulla facilisis at vero eros et accumsan</p>
				<div class="button1">
					<a href="registration"><input type="submit" name="Submit"
						value="Create an Account"></a>
				</div>
				<div class="clear"></div>
			</div>
			<div class="col_1_of_login span_1_of_login">
				<div class="login-title">
					<h4 class="title">Registered Customers</h4>
					<div id="loginbox" class="register_account">
						<form method="POST" action="${contextPath}/login"
							class="form-signin">
							<h2 class="form-heading">Log in</h2>

							<div class="form-group ${error != null ? 'has-error' : ''}">
								<div><span class="text-success">${message}</span></div>
								<div>
									 <input name="username" type="text"
										class="form-control" placeholder="Username" autofocus="true" />
									<input name="password" type="password" class="form-control"
										placeholder="Password" />
										<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</div>
							</div>
							<div>
								<span class="text-danger">${error}</span>
							</div>
							<div class="form-group">
								<button class="btn btn-success" type="submit">Log
									In</button>
								<h4 class="text-center">
									<a href="${contextPath}/registration">Create an account</a>
								</h4>
							</div>

						</form>

					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<jsp:include page="partial/footer.jsp"></jsp:include>
</body>
</html>