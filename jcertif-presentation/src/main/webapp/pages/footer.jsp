<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<div id="footer">
	<div class="copyright">
		<a href="home.jsp"><img src="#" border="0" alt="" title="" />
		</a>
	</div>
	<div class="footer_links">
		<a class="current"
			href="<%= request.getContextPath()%>/pages/home.jsp" title="">Acceuil</a>
		<a href="#">A Propos de JCertif 2001</a> <a href="contact.jsp">Nous
			contacter</a>
	</div>

</div>