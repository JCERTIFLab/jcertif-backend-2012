<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page="i18n.jsp" />
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:useBean id="imageManager"
	class="com.jcertif.presentation.action.util.MainImageNameLoader"
	scope="page">
	<jsp:setProperty name="imageManager" property="applicationAbsolutePath"
		value="<%= application.getRealPath(\"/\")%>" />
</jsp:useBean>
<head>
<title><%=session.getAttribute("home.jsp.title")%></title>
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<link type="text/css" href="css/simple.css" rel="stylesheet" />
<link type="text/css" href="css/li-scroller.css" rel="stylesheet" />

<script type="text/javascript" src="js/jcertif.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.li-scroller.1.0.js"></script>
<script type="text/javascript" src="js/jquery.pikachoose.js"></script>
<script type="text/javascript" src="js/jquery.jcarousel.min.js"></script>
<script type="text/javascript">            $(document).ready(
            function (){
                $("#pikame").PikaChoose({showCaption:false});
                JCERTIF.menu.init("#menu_home");
            }); 		
        </script>
</head>

<body>
	<div id="main_container">
		<%
			session.setAttribute("url", request.getContextPath() +"/pages/home.jsp");
		%>
		<jsp:include page="headertemplate.jsp" />

		<div id="main_content">
			<table border="0">
				<tr>
					<td>
						<div id="left_content">
							<h2>JCertif 2011</h2>
							<div class="pikachoose">
								<ul id="pikame" class="jcarousel-skin-pika">
									<c:forEach var="image" items="${imageManager.allImageName}">
										<li><a href="#"><img alt=""
												src="mainslide_images/${image}" />
										</a><span></span>
										</li>
									</c:forEach>
								</ul>
							</div>
                    </td>
                    <td rowspan="3">
                    <jsp:include page="sponsors.jsp" />
                    </td>
							
						</div>
						<!--end of right content-->
						<!--

                <div style=" clear:both;"></div>
                -->
					
				</tr>
				<tr>
					<td><jsp:include page="speakers.jsp" /></td>
				</tr>
				
			</table>
			
		</div>
		<!--end of main content-->

		<jsp:include page="footer.jsp" />

	</div>
	<!--end of main container-->
</body>
</html>
