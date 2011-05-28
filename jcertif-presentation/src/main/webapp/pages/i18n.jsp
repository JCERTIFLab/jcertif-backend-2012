<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="com.jcertif.presentation.internationalisation.Msg"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>

<%
	if(session.getAttribute("i18n.init") == null){
		Msg.initI18n(session,request.getHeader("Accept-Language"));
		session.setAttribute("i18n.init",true);
	}
%>