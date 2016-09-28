<jsp:include page="partial/taglib.jsp"></jsp:include>
<!DOCTYPE HTML>
<html>
<jsp:include page="partial/head.jsp"></jsp:include>
<body>
	<jsp:include page="partial/topbar.jsp"></jsp:include>
	<jsp:include page="partial/topmenu.jsp"></jsp:include>
    <div class="login">
       <div class="wrap">
	    <ul class="breadcrumb breadcrumb__t"><li><a class="home" href="#">Home</a>  / Contact</li></ul>
		   <div class="content-top">
			   <form:form method="post" action="/contact" modelAttribute="contactForm">
					<div class="to">
                     	<input type="text" class="text" name="name" placeholder="Name">
                     
                        <label class="error">
                        	<form:errors path="name"></form:errors>
                        </label>
					 	<input type="text" class="text" name="email" placeholder="Email"  style="margin-left: 10px">
                        <label class="error">
                        	<form:errors path="email"></form:errors>
                        </label>
					</div>
					<div class="to">
                     	<input type="text" class="text" name="subject" placeholder="Subject:">
                     	 <div class="clear"></div>
                        <label class="error">
                        	<form:errors path="subject"></form:errors>
                        </label>
					</div>
					<div class="text">
	                   <textarea name="message" placehoder="Message:">Message:</textarea>
	                    <div class="clear"></div>
                        <label class="error">
                        	<form:errors path="message"></form:errors>
                        </label>
	                </div>
	                 <button class="grey">Submit</button>
               </form:form>
                <div class="map">
					<div style="width:100%;overflow:hidden;height:500px;max-width:100%;"><div id="embedded-map-display" style="height:100%; width:100%;max-width:100%;"><iframe style="height:100%;width:100%;border:0;" frameborder="0" src="https://www.google.com/maps/embed/v1/place?q=Fairfield&key=AIzaSyAN0om9mFmy1QN6Wf54tXAowK4eT0ZUPrU"></iframe></div><style>#embedded-map-display .text-marker{max-width:none!important;background:none!important;}img{max-width:none}</style></div><script src="https://www.interserver-coupons.com/google-maps-authorization.js?id=b90fa378-5805-cce6-79c8-92060aeb9681&c=embedded-map-html&u=1475034355" defer="defer" async="async"></script>View Larger Map</a></small>
				</div>
            </div>
       </div> 
    </div>
    <jsp:include page="partial/footer.jsp"></jsp:include>
</body>
</html>