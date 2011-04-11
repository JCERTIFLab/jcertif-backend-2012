<%@page import="com.jcertif.presentation.ui.util.UIConst"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	ResourceBundle bundle = ResourceBundle.getBundle(UIConst.WEBAPP_PROPERTIES_FILE);
	String facadeURL = bundle.getString(UIConst.FACADE_URL_PROP);
%>

<div align="right">
	<img alt="" src="<%=facadeURL%>/sponsors/google.gif" width="200">
	<br/>
	<img alt="" src="<%=facadeURL%>/sponsors/objis.jpg" width="200">
	<br/>
	<img alt="" src="<%=facadeURL%>/sponsors/oraclent.png" width="200">
	<br/>
	<img alt="" src="<%=facadeURL%>/sponsors/warid.gif" width="100" >
	<br/>
	<br/>
	<img alt="" src="<%=facadeURL%>/sponsors/burotop.jpg" width="200" >
</div>