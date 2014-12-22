<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets">

<h:head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="shortcut icon" href="images/bgr/favicon32.png" />
<title><ui:insert name="titre"></ui:insert></title>

<ui:insert name="scripts"></ui:insert>
<script type="text/javascript" src="web/js/jquery.min.js"></script>
<script type="text/javascript" src="web/js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>


<ui:insert name="css"></ui:insert>
<link href="web/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>	
<link href="web/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<link href="web/css/animations.css" rel="stylesheet" type="text/css" media="all" />
  
  
  
  
          <script type="text/javascript">
			$(document).ready(function() {
				
			
				var defaults = {
		  			containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
		 		};
				
				
				$().UItoTop({ easingType: 'easeOutQuart' });
				
			});
		</script>
</h:head>

<body>
	<f:view>

  <div class="header-top">
	 <div class="wrap"> 
		<div class="logo">
			<a href="index.jsf"><img src="web/img/logart.png" alt="" style="width: 100px;"/></a>
	    </div>
		    <div class="cssmenu">
		   <ul>
			 <li class="active"><a href="register.html">S'inscrire</a></li> 
			 <li><a href="checkout.html">Mon compte</a></li> 
		   </ul>
		   			<ul class="icon2 sub-icon2 profile_img">
			<li><a class="active-icon c2" href="#">
			<img alt="" src="web/img/cart.png">
			 </a>
				<ul class="sub-icon2 list">
					<li><h3>Products</h3><a href=""></a></li>

				</ul>
			</li>
		</ul>
	</div>
		
	

		<div class="clear"></div>
 	</div>
   </div>
   <div class="header-bottom">
   	<div class="wrap">
   		<!-- start header menu -->
		<ul class="megamenu skyblue">
		    <li><a class="color1" href="#">Accueil</a></li>
			<li class="grid"><a class="color2" href="#">Oeuvres</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>popular</h4>
								<ul>
									<li><a href="shop.html">new arrivals</a></li>
									<li><a href="shop.html">men</a></li>
								</ul>	
							</div>
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>style zone</h4>
								<ul>
									<li><a href="shop.html">men</a></li>
									<li><a href="shop.html">women</a></li>
								</ul>	
							</div>							
						</div>
						<div class="col1"></div>

						<img src="web/images/nav_img2.jpg" alt=""/>
					</div>
				</div>
				</li>
  			   <li class="active grid"><a class="color4" href="#">Artistes</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>shop</h4>
								<ul>
									<li><a href="shop.html">new arrivals</a></li>
									<li><a href="shop.html">men</a></li>
									<li><a href="shop.html">women</a></li>
								</ul>	
							</div>							
						</div>

						<div class="col1">
							<div class="h_nav">
								<h4>my company</h4>
								<ul>
									<li><a href="shop.html">trends</a></li>
									<li><a href="shop.html">sale</a></li>
									<li><a href="shop.html">style videos</a></li>
								</ul>	
							</div>												
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>account</h4>
								<ul>
									<li><a href="shop.html">login</a></li>
									<li><a href="shop.html">create an account</a></li>
									<li><a href="shop.html">create wishlist</a></li>
								</ul>	
							</div>						
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>popular</h4>
								<ul>
									<li><a href="shop.html">new arrivals</a></li>
									<li><a href="shop.html">men</a></li>
								</ul>	
							</div>
						</div>
						<div class="col1">
						 <div class="h_nav">
						   <img src="web/images/nav_img1.jpg" alt=""/>
						 </div>
						</div>
					</div>
					<div class="row">
						<div class="col2"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
						<div class="col1"></div>
					</div>
					</div>
    			</li>				
				<li><a class="color5" href="#">Expositions</a>
				<div class="megapanel">
					<div class="row">
						<div class="col1">
							<div class="h_nav">
								<h4>popular</h4>
								<ul>
									<li><a href="shop.html">new arrivals</a></li>
									<li><a href="shop.html">men</a></li>
								</ul>	
							</div>
						</div>
						<div class="col1">
							<div class="h_nav">
								<h4>style zone</h4>
								<ul>
									<li><a href="shop.html">men</a></li>
									<li><a href="shop.html">women</a></li>
								</ul>	
							</div>							
						</div>
						<div class="col1"></div>

						<img src="web/images/nav_img2.jpg" alt=""/>
					</div>
				</div>
				</li>
		
		   </ul>
		   <div class="clear"></div>
     	</div>
       </div>
   
       

       
       
   

   </f:view>
</body>
</html>