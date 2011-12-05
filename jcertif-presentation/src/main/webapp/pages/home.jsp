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
				<tr id="left_content">
					<td>
						<div>
							<h2>JCertif Conférence 2011</h2>
							<embed type="application/x-shockwave-flash" src="https://picasaweb.google.com/s/c/bin/slideshow.swf" width="455" height="350" flashvars="host=picasaweb.google.com&hl=en_US&feat=flashalbum&RGB=0x000000&feed=https%3A%2F%2Fpicasaweb.google.com%2Fdata%2Ffeed%2Fapi%2Fuser%2Fbonbhel%2Falbumid%2F5652497525273051649%3Falt%3Drss%26kind%3Dphoto%26hl%3Den_US" pluginspage="http://www.macromedia.com/go/getflashplayer"></embed>
						</div>
					</td>
				    
				    <td class="stat_content">
					JCertif is the biggest Java Community Conference in Central Africa. JCertif allows attendees to collaborate and share the latest news and best practices in the fields of Java technology, Web 2.0 and Mobile Apps.
					<br/>
					JCertif en chiffres 
					<ul>
					    <li>400 participants</li>
					    <li>15 sessions</li>
					    <li>2 robotcodes (Max et Stan)</li>
					</ul>
					
					
					
				    </td>
					
					
							
						
						<!--end of right content-->
						<!--

                <div style=" clear:both;"></div>
                -->
					
				</tr>
			    <tr  id="left_content">
				<td>
						<div>
							<h2>JCertif University 2011</h2>
							<embed type="application/x-shockwave-flash" src="https://picasaweb.google.com/s/c/bin/slideshow.swf" width="455" height="350" flashvars="host=picasaweb.google.com&hl=en_US&feat=flashalbum&RGB=0x000000&feed=https%3A%2F%2Fpicasaweb.google.com%2Fdata%2Ffeed%2Fapi%2Fuser%2Fbonbhel%2Falbumid%2F5653206719099806001%3Falt%3Drss%26kind%3Dphoto%26hl%3Den_US" pluginspage="http://www.macromedia.com/go/getflashplayer"></embed>
							</div>
					</td>
				<td class="stat_content">
					Plusieurs cours ont été dispensés :
					<ul>
					    <li>Des cours d'initiation à Java <a style="color:red" href="kit_java_debutant_jcertif_2011.zip">télécharger</a></li>
					    <li>Des cours d'initiation à Android <a style="color:red" href="kit_java_debutant_jcertif_2011.zip">télécharger</a></li>
					</ul>
				  
				    </td>
			    </tr>
				<tr>
					<td colspan="2"><jsp:include page="sponsors.jsp" /></td>
				</tr>
				
			</table>
			
		</div>
		<!--end of main content-->

		<jsp:include page="footer.jsp" />

	</div>
	<!--end of main container-->
</body>
</html>
