<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page="i18n.jsp" />
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en" >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="style.css" media="screen" />
    <link type="text/css" href="css/bottom.css" rel="stylesheet" />
    <link type="text/css" href="css/li-scroller.css" rel="stylesheet" />

<script type="text/javascript" src="js/jcertif.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.li-scroller.1.0.js"></script>
 <link type="text/css" href="../VAADIN/themes/jcertifruno/styles.css" rel="stylesheet" />
 
 <script language="javascript">
     
     function subscribe(){
	 $("#subscribe_form").css('visibility', 'visible');
	
	 
     }
     
 </script>
 
 <title><%=session.getAttribute("formations.jsp.title")%></title>
</head>
<body>

<div id="main_container">
    <jsp:include page="headertemplate.jsp"/>
     <%
     session.setAttribute("url", request.getContextPath() +"/pages/formations.jsp");
     %>
     <div style="font-size: 12px">
     <p>
    <br/>
	 
	 JCertif University vous propose 3 jours de formations JAVA qui se dérouleront <b>du 31/08/2011 au 02/09/2011</b>. 
	 
	 <br/>
	 <br/>
	 <div style="color: red; font-size: 12px">Ces formations sont gratuites, les inscrits à la conférence sont prioritaires.</div>
	 
	 <br/>
	 
	 
	 Voici le planning prévisionnel :
	 <br/>
	 <br/>
	 
	 <table>
	     <thead align="center">
		 <tr>
		     <td><b>Jour 1</b></td>
		     <td><b>Jour 2</b></td>
		     <td><b>Jour 3</b></td>
		 </tr>
		 
	     </thead>
	     <tbody>
		 <tr align="center">
		     <td>Introduction au la langage Java<br/>(niveau débutant)</td>
		     <td>Développement Web avec Java<br/>(niveau intermédiaire)</td>
		     <td>Architectue Java EE<br/>(niveau avancé)</td>
		 </tr>
		 <tr valign="top">
		     <td><ul><li>Types primitifs</li><li>Classes, interfaces</li><li>Héritage, polymorphisme</li><li>Thread, Runnable</li><li>Réalisation d'un mini-projet</li><li>...</li></ul></td>
		     <td><ul><li>Servlets</li><li>JSP</li><li>Expression language</li><li>Java Server Face</li><li>Réalisation d'un mini-projet</li><li>...</li></ul></td>
		     <td><ul><li>Architecture d'un projet Java EE</li><li>Serveur d'application(GlassFish)</li><li>Entreprise JavaBeans</li><li>Clustering sous GlassFish</li><li>Réalisation d'un mini-projet</li><li>...</li></ul></td>
		 </tr>
	     </tbody>
	     
	 </table>
	 
	<%
	if (session.getAttribute("connected") == null || session.getAttribute("connected").equals(Boolean.FALSE)) {
	%>
	Veuillez vous connecter pour vous inscrire aux formations.
	<%
	} else {
	 
	
	%>
	    <button id="subscribe" onclick="subscribe()"><%=session.getAttribute("formations.jsp.subscribe")%></button>
	<%
	}
	%>
	<br/>
	<iframe src="http://www.google.fr" id="subscribe_form" width="890" style="visibility: hidden">
	    
	</iframe>
   
     </p>
	 
   </div>
    
    <jsp:include page="footer.jsp" />
    </div>
</body>
</html>