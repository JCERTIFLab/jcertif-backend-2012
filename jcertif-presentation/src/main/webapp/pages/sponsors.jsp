<%@page import="java.util.Set"%>
<%@page import="com.jcertif.presentation.data.bo.participant.Participant"%>
<%@page import="java.util.List"%>
<%@page import="com.jcertif.presentation.wsClient.ParticipantClient"%>
<%@page import="com.jcertif.presentation.ui.util.JCertifProps"%>
<%@page import="com.jcertif.presentation.ui.util.UIConst"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div align="right">
<table>

<%
	
	String picsURL = JCertifProps.getInstance().getPicsUrl();
	String partenaire = UIConst.URL_PARTNER_IMG;
	List<Participant> participants = ParticipantClient.getInstance().getSponsorsSortedByNiveauForHomePage();
	int i = 1;
	double s = participants.size()/2;
	for(Participant participant:participants){
		
	if(participant.getNiveauPartenariat() != null){
		
		if(i%2==0){
%>

	<td>
	<a href="<%= participant.getWebsite() %>"  target="_blank"><img alt="" src="<%=picsURL + partenaire + participant.getProfilUtilisateur().getPhoto()%>" width="125" border="0"></a>
	<br/>
	</td>
	</tr>
	<tr>
	<%
		} else {
	
	%>
	<tr>
	<td>
	<a href="<%= participant.getWebsite() %>"  target="_blank"><img alt="" src="<%=picsURL + partenaire + participant.getProfilUtilisateur().getPhoto()%>" width="125" border="0"></a>
	</td>
	<%} 
	i++;	
		%>
	
<%}
	}
%>
</tr>
</table>
</div>