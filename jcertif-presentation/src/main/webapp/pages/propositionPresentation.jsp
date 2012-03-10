<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page="i18n.jsp" />
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<script type="text/javascript" src="js/jcertif.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<link type="text/css" href="css/bottom.css" rel="stylesheet" />
<link type="text/css" href="css/li-scroller.css" rel="stylesheet" />

<script type="text/javascript" src="js/jcertif.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.li-scroller.1.0.js"></script>
<link type="text/css" href="../VAADIN/themes/jcertifruno/styles.css"
	rel="stylesheet" />
<script type="text/javascript">
	var vaadin = {
		vaadinConfigurations : {
			'vaadin_div' : {
				appUri : '<%=request.getContextPath()%>/vaadin/propositionPresentation',
				pathInfo : '/',
				themeUri : '',
				versionInfo : {
					vaadinVersion : "6.2.0-INTERNAL-NONVERSIONED-DEBUG-BUILD",
					applicationVersion : "NONVERSIONED"
				}
			}
		}
	};
	$(document).ready(function()
	{
	    JCERTIF.menu.init("#menu_proposition");
	});
</script>
<script type="text/javascript"
	src='../VAADIN/widgetsets/com.jcertif.presentation.gwt.MyWidgetSet/com.jcertif.presentation.gwt.MyWidgetSet.nocache.js'></script>
<title><%=session.getAttribute("propositionPresentation.jsp.title")%></title>
</head>
<body>
	<%
	session.setAttribute("url", request.getContextPath() +"/pages/propositionPresentation.jsp");
		if(session.getAttribute("connected") == null || session.getAttribute("connected").equals(Boolean.FALSE)) {
        			session.setAttribute("login.propositionsujet",true);
        			response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
        	%>
            <%
        		} else {
        			session.setAttribute("login.propositionsujet",false);
        		}
            %>  
	<div id="main_container">
		<jsp:include page="headertemplate.jsp" />

		<div id="vaadin_div"></div>
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>