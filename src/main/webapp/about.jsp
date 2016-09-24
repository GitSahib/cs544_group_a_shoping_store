<jsp:include page="partial/taglib.jsp"></jsp:include>
<!DOCTYPE HTML>
<html>
<jsp:include page="partial/head.jsp"></jsp:include>
<body>
	<jsp:include page="partial/topbar.jsp"></jsp:include>
	<jsp:include page="partial/topmenu.jsp"></jsp:include>
	<div class="login">
		<div class="wrap">
			<ul class="breadcrumb breadcrumb__t">
				<a class="home" href="#">Home</a> / About
			</ul>
			<div class="section group">
				<div class="labout span_1_of_about">
					<h3>Testimonials</h3>
					<div class="testimonials ">
						<div class="testi-item">
							<blockquote class="testi-item_blockquote">
								<a href="#">Lorem ipsum dolor sit amet, consectetuer
									adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
									laoreet dolore magna aliquam erat volutpat. </a>
								<div class="clear"></div>
							</blockquote>
							<small class="testi-meta"><span class="user">Lorem
									ipsum dolor </span>, <span class="info">sit amet</span><br>
							<a href="#">http://demolink.org</a></small>
						</div>
					</div>
					<div class="testimonials ">
						<div class="testi-item">
							<blockquote class="testi-item_blockquote">
								<a href="#">Lorem ipsum dolor sit amet, consectetuer
									adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
									laoreet dolore magna aliquam erat volutpat. </a>
								<div class="clear"></div>
							</blockquote>
							<small class="testi-meta"><span class="user">Lorem
									ipsum dolor</span>, <span class="info">sit amet</span><br>
							<a href="#">http://demolink.org</a></small>
						</div>
					</div>
				</div>
				<div class="cont span_2_of_about">
					<h3>Our Mission</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
						Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse cillum dolore eu fugiat
						nulla pariatur.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
						Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse cillum dolore eu fugiat
						nulla pariatur.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
						Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse cillum dolore eu fugiat
						nulla pariatur.</p>
					<h5 class="m_6">Meet Our Team</h5>
					<div class="section group">
						<div class="col_1_of_about-box span_1_of_about-box">
							<a class="popup-with-zoom-anim" href="#small-dialog3"> <span
								class="rollover"></span><img
								src="${contextPath}/resources/images/a-img.jpg" title="continue"
								alt="" /></a>
							<div id="small-dialog3" class="mfp-hide">
								<div class="pop_up2">
									<h2>Lorem ipsum</h2>
									<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
										elit, sed diam nonummy nibh euismod tincidunt ut laoreet
										dolore magna aliquam erat volutpat. Ut wisi enim ad minim
										veniam, quis nostrud exerci tation ullamcorper suscipit
										lobortis nisl ut aliquip ex ea commodo consequat. Duis autem
										vel eum iriure dolor in hendrerit in vulputate velit esse
										molestie.</p>
									<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
										elit, sed diam nonummy nibh euismod tincidunt ut laoreet
										dolore magna aliquam erat volutpat. Ut wisi enim ad minim
										veniam, quis nostrud exerci tation ullamcorper suscipit
										lobortis nisl ut aliquip ex ea commodo consequat. Duis autem
										vel eum iriure dolor in hendrerit in vulputate velit esse
										molestie.</p>
								</div>
							</div>
							<h4 class="m_7">
								<a href="#">consectetuer adipiscing</a>
							</h4>
							<p>Lorem ipsum dolor consectetur adipisicing elit, sed do
								eiusmod.</p>
						</div>
						<div class="col_1_of_about-box span_1_of_about-box">
							<a class="popup-with-zoom-anim" href="#small-dialog3"> <span
								class="rollover"></span><img
								src="${contextPath}/resources/images/a-img1.jpg"
								title="continue" alt="" /></a>
							<h4 class="m_7">
								<a href="#">consectetuer adipiscing</a>
							</h4>
							<p>Lorem ipsum dolor consectetur adipisicing elit, sed do
								eiusmod.</p>
						</div>
						<div class="col_1_of_about-box span_1_of_about-box">
							<a class="popup-with-zoom-anim" href="#small-dialog3"> <span
								class="rollover"></span><img
								src="${contextPath}/resources/images/a-img2.jpg"
								title="continue" alt="" /></a>
							<h4 class="m_7">
								<a href="#">consectetuer adipiscing</a>
							</h4>
							<p>Lorem ipsum dolor consectetur adipisicing elit, sed do
								eiusmod.</p>
						</div>
						<div class="clear"></div>

					</div>
					<!-- Add fancyBox main JS and CSS files -->
					<script src="${contextPath}/resources/js/jquery.magnific-popup.js"
						type="text/javascript"></script>
					<link href="${contextPath}/resources/css/magnific-popup.css"
						rel="stylesheet" type="text/css">
					<script>
						$(document).ready(function() {
							$('.popup-with-zoom-anim').magnificPopup({
								type : 'inline',
								fixedContentPos : false,
								fixedBgPos : true,
								overflowY : 'auto',
								closeBtnInside : true,
								preloader : false,
								midClick : true,
								removalDelay : 300,
								mainClass : 'my-mfp-zoom-in'
							});
						});
					</script>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="footer-top">
			<div class="wrap">
				<div class="section group example">
					<div class="col_1_of_2 span_1_of_2">
						<ul class="f-list">
							<li><img src="${contextPath}/resources/images/2.png"><span
								class="f-text">Free Shipping on orders over $ 100</span>
							<div class="clear"></div></li>
						</ul>
					</div>
					<div class="col_1_of_2 span_1_of_2">
						<ul class="f-list">
							<li><img src="${contextPath}/resources/images/3.png"><span
								class="f-text">Call us! toll free-222-555-6666 </span>
							<div class="clear"></div></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		<div class="footer-middle">
			<div class="wrap">
				<div class="section group example">
					<div class="col_1_of_f_1 span_1_of_f_1">
						<div class="section group example">
							<div class="col_1_of_f_2 span_1_of_f_2">
								<h3>Facebook</h3>
								<script>
									(function(d, s, id) {
										var js, fjs = d.getElementsByTagName(s)[0];
										if (d.getElementById(id))
											return;
										js = d.createElement(s);
										js.id = id;
										js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
										fjs.parentNode.insertBefore(js, fjs);
									}(document, 'script', 'facebook-jssdk'));
								</script>
								<div class="like_box">
									<div class="fb-like-box"
										data-href="http://www.facebook.com/w3layouts"
										data-colorscheme="light" data-show-faces="true"
										data-header="true" data-stream="false" data-show-border="true"></div>
								</div>
							</div>
							<div class="col_1_of_f_2 span_1_of_f_2">
								<h3>From Twitter</h3>
								<div class="recent-tweet">
									<div class="recent-tweet-icon">
										<span> </span>
									</div>
									<div class="recent-tweet-info">
										<p>
											Ds which don't look even slightly believable. If you are <a
												href="#">going to use nibh euismod</a> tincidunt ut laoreet
											adipisicing
										</p>
									</div>
									<div class="clear"></div>
								</div>
								<div class="recent-tweet">
									<div class="recent-tweet-icon">
										<span> </span>
									</div>
									<div class="recent-tweet-info">
										<p>
											Ds which don't look even slightly believable. If you are <a
												href="#">going to use nibh euismod</a> tincidunt ut laoreet
											adipisicing
										</p>
									</div>
									<div class="clear"></div>
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="col_1_of_f_1 span_1_of_f_1">
						<div class="section group example">
							<div class="col_1_of_f_2 span_1_of_f_2">
								<h3>Information</h3>
								<ul class="f-list1">
									<li><a href="#">Duis autem vel eum iriure </a></li>
									<li><a href="#">anteposuerit litterarum formas </a></li>
									<li><a href="#">Tduis dolore te feugait nulla</a></li>
									<li><a href="#">Duis autem vel eum iriure </a></li>
									<li><a href="#">anteposuerit litterarum formas </a></li>
									<li><a href="#">Tduis dolore te feugait nulla</a></li>
								</ul>
							</div>
							<div class="col_1_of_f_2 span_1_of_f_2">
								<h3>Contact us</h3>
								<div class="company_address">
									<p>500 Lorem Ipsum Dolor Sit,</p>
									<p>22-56-2-9 Sit Amet, Lorem,</p>
									<p>USA</p>
									<p>Phone:(00) 222 666 444</p>
									<p>Fax: (000) 000 00 00 0</p>
									<p>
										Email: <span>mail[at]leoshop.com</span>
									</p>

								</div>
								<div class="social-media">
									<ul>
										<li><span class="simptip-position-bottom simptip-movable"
											data-tooltip="Google"><a href="#" target="_blank">
											</a></span></li>
										<li><span class="simptip-position-bottom simptip-movable"
											data-tooltip="Linked in"><a href="#" target="_blank">
											</a> </span></li>
										<li><span class="simptip-position-bottom simptip-movable"
											data-tooltip="Rss"><a href="#" target="_blank"> </a></span></li>
										<li><span class="simptip-position-bottom simptip-movable"
											data-tooltip="Facebook"><a href="#" target="_blank">
											</a></span></li>
									</ul>
								</div>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="footer-bottom">
				<div class="wrap">
					<div class="copy">
						<p>
							© 2014 Template by <a href="http://w3layouts.com"
								target="_blank">w3layouts</a>
						</p>
					</div>
					<div class="f-list2">
						<ul>
							<li class="active"><a href="about">About Us</a></li> |
							<li><a href="delivery">Delivery & Returns</a></li> |
							<li><a href="delivery">Terms & Conditions</a></li> |
							<li><a href="contact">Contact Us</a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
</body>
</html>