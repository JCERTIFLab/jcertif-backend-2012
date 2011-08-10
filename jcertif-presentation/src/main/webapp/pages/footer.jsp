<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<div id="footer">
	<div class="copyright">
		<a href="home.jsp"> </a>
	</div>
	<div class="footer_links">
		<a class="current" href="<%=request.getContextPath()%>/pages/home.jsp" title=""><%=session.getAttribute("footer.jsp.accueil")%></a>
		<a href="<%=request.getContextPath()%>/pages/apropos.jsp"><%=session.getAttribute("footer.jsp.apropos")%></a> <a href="contact.jsp"><%=session.getAttribute("footer.jsp.contact")%></a>
		<a href="issues.jsp"><%=session.getAttribute("footer.jsp.issues")%></a>
	</div>

</div>