<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<div id="header">
    <div id="logo">
        <a href="<%=request.getContextPath()%>/pages/home.jsp">
            <img src="images/JCertif_Conf2011.jpg" alt="" title="" border="0" />
        </a>
    </div>
    <div id="menu">
        <ul>
            <li><a class="current" href="<%=request.getContextPath()%>/pages/home.jsp" title="">Acceuil</a></li>
            <li><a href="<%=request.getContextPath()%>/pages/calendrier.jsp" title="">Calendrier</a></li>
            <li><a href="<%=request.getContextPath()%>/pages/presentateurs.jsp" title="">Presentateurs</a></li>
            <li><a href="<%=request.getContextPath()%>/pages/faq.jsp" title="">Foire aux questions</a></li>
            <li><a href="<%=request.getContextPath()%>/pages/contact.jsp" title="">Nous contacter</a></li>
        </ul>
    </div>
</div>