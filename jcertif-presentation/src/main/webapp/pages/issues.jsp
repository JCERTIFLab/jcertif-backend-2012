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
 
 <title><%=session.getAttribute("issues.jsp.title")%></title>
</head>
<body>

<div id="main_container">
    <jsp:include page="headertemplate.jsp"/>
     <%
     session.setAttribute("url", request.getContextPath() +"/pages/issues.jsp");
     %>
     <div style="font-size: 14px; padding-left: 5px">
     <p>
    <br/>
	 <%=session.getAttribute("issues.jsp.content")%>
	
     </p>
	 
   </div>
    
    <jsp:include page="footer.jsp" />
    </div>
</body>
</html>