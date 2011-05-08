<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page="i18n.jsp" />
<div id="header">
	<table border="0" width="100%">   
		<tr>
    		<td width="" align="left" >
        	    <div id="logo" align="left">
        			<a href="<%=request.getContextPath()%>/pages/home.jsp">
            			<img src="images/JCertif_Conf2011_2.png" alt="Logo JCertif 2011" title="" border="0" align="left"/>
        			</a>
        		</div>
        	</td>
        	<td width="">
					<div id="slogan" align="right">
        				<font class=greenColor><b><%=session.getAttribute("header.jsp.dates")%></b></font> <font class=redColor><b><%=session.getAttribute("header.jsp.lieu")%></b></font> 
        				<br/>
        				<br/>
        				<%
        					if(session.getAttribute("connected") != null && session.getAttribute("connected").equals(Boolean.TRUE)) {	
        				%>
        				<div id="profil" ><%=session.getAttribute("firstname")%> <%=session.getAttribute("lastname")%></div> <a id="logout" href="<%=request.getContextPath()%>/vaadin/logout" title=""><b>Déconnexion</b></a>
        				<%
        					}
        				%>
        			</div>
        	</td>
        </tr>
	</table>
    
    <div id="menu">
        <ul>
            <li><a class="current" href="<%=request.getContextPath()%>/pages/home.jsp" title=""><b><%=session.getAttribute("header.jsp.menu.home")%></b></a></li>
            <li><a href="<%=request.getContextPath()%>/pages/inscription.jsp" title=""><b><%=session.getAttribute("header.jsp.menu.inscription")%></b></a></li>
            <li><a href="<%=request.getContextPath()%>/pages/propositionPresentation.jsp" title=""><b><%=session.getAttribute("header.jsp.menu.proposition")%></b></a></li>
            <li><a href="<%=request.getContextPath()%>/pages/calendrier.jsp" title=""><b><%=session.getAttribute("header.jsp.menu.calendar")%></b></a></li>
            <li><a href="<%=request.getContextPath()%>/pages/presentateurs.jsp" title=""><b><%=session.getAttribute("header.jsp.menu.speakers")%></b></a></li>
            <li><a href="<%=request.getContextPath()%>/pages/apropos.jsp" title=""><b><%=session.getAttribute("header.jsp.menu.apropos")%></b></a></li>
            <li><a href="<%=request.getContextPath()%>/pages/faq.jsp" title=""><b><%=session.getAttribute("header.jsp.menu.faq")%></b></a></li>
        </ul>
    </div>
</div>