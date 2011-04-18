<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<link type="text/css" href="css/bottom.css" rel="stylesheet" />
<link type="text/css" href="../VAADIN/themes/jcertifruno/styles.css"
	rel="stylesheet" />

<script type="text/javascript"
	src='../VAADIN/widgetsets/com.jcertif.presentation.gwt.MyWidgetSet/com.jcertif.presentation.gwt.MyWidgetSet.nocache.js'></script>
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
				<%=session.getAttribute("contact.jsp.canada")%><br /><%=session.getAttribute("contact.jsp.congo")%>
			</p>
			<br /> <br />
			<p>
				<img src="images/contact_icon.gif" alt="" title="" class="box_img" />
				<%=session.getAttribute("contact.jsp.email")%><br />
			</p>

			<br /> <br />

		</div>

		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>