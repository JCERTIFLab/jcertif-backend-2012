<%@page import="com.jcertif.presentation.ui.util.JCertifProps"%>
<%@page import="com.jcertif.presentation.ui.util.UIConst"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	
	String picsURL = JCertifProps.getInstance().getPicsUrl();
	String partenaire = UIConst.URL_PARTNER_IMG;
%>

<div align="right">
	<img alt="" src="<%=picsURL + partenaire%>google.gif" width="200">
	<br/>
	<img alt="" src="<%=picsURL + partenaire%>burotop.jpg" width="200" >
	<br/>
	<img alt="" src="<%=picsURL + partenaire%>oraclent.png" width="200">
	<br/>
	<img alt="" src="<%=picsURL + partenaire%>objis.jpg" width="200">
	<br/>
	<img alt="" src="<%=picsURL + partenaire%>warid.gif" width="100" >
	<br/>
</div>