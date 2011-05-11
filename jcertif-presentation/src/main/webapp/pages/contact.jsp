<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page="i18n.jsp" />
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<link type="text/css" href="css/bottom.css" rel="stylesheet" />
<link type="text/css" href="../VAADIN/themes/jcertifruno/styles.css"
	rel="stylesheet" />
	
	<script type="text/javascript"
    src="http://maps.google.com/maps/api/js?sensor=true">
</script>
 <script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
  function init() {
    var latlng = new google.maps.LatLng(-4.28030000, 15.258900);
    var myOptions = {
      zoom: 12,
      center: latlng,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById("map_canvas"),
        myOptions);
    var myMarker = new google.maps.Marker({
    	// Coordonnées du cinéma
    	position: latlng,
    	map: map,
    	title: "JCERTIF 2011"
    });
  }
  
  $(document).ready(function()
	        {
	        	init();
	    
	        });

</script>

</head>
<body>
	<%
		session.setAttribute("url", request.getContextPath() + "/pages/contact.jsp");
	%>
	<div id="main_container">
		<jsp:include page="headertemplate.jsp" />
		<br />


		<div class="contact_information">
			<h4><%=session.getAttribute("contact.jsp.title")%></h4>
			<p>
				<img src="images/phone_icon.gif" alt="" title="" class="box_img" />
				<%=session.getAttribute("contact.jsp.congo")%><br />
				<%=session.getAttribute("contact.jsp.france")%><br />
				<%=session.getAttribute("contact.jsp.canada")%>
			</p>
			<br /> <br />
			<p>
				<img src="images/contact_icon.gif" alt="" title="" class="box_img" />
				<%=session.getAttribute("contact.jsp.email")%><br />
			</p>

			<br /> <br />

		</div>
		
		
		<div id="map_canvas" style="float:right; width:550px; height:350px"></div>
		
		<jsp:include page="footer.jsp" /> 
	</div>
	
		
	
</body>
</html>