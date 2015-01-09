<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<ui:composition
   xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:p="http://primefaces.org/ui"
    template="/header.jsp">

<ui:define name="titre">Accueil</ui:define> 

<ui:define name="css">   
<link href="web/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>

	
</ui:define>

<ui:define name="scripts">   
	 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	 <script src="web/js/jquery.flexslider.js"></script>
 </ui:define>
    
<ui:define name="content">

<div class="flexslider">
  <ul class="slides">
    <li>
      <img src="web/bear/unicorn_1.gif" />
    </li>
    <li>
      <img src="web/bear/unicorn_1.gif" />
    </li>
    <li>
      <img src="web/bear/unicorn_1.gif" />
    </li>
    <li>
      <img src="web/bear/unicorn_1.gif" />
    </li>
  </ul>
</div>
<script type="text/javascript">
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide"
  });
});
</script>
 






<center><img alt="" src="web/images/giphy.gif">
</center>

  </ui:define>
</ui:composition>
