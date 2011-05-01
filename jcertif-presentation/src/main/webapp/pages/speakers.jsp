<%@page import="com.jcertif.presentation.wsClient.ParticipantClient"%>
<%@page
	import="com.jcertif.presentation.data.bo.participant.Participant"%>
<%@page import="java.util.List"%>
<%@page import="com.jcertif.presentation.ui.util.JCertifProps"%>
<%@page import="com.jcertif.presentation.ui.util.UIConst"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div>
	<table>
		<tr>
	<%
		String picsURL = JCertifProps.getInstance().getPicsUrl();
		String speaker = UIConst.URL_SPEAKER_IMG;
		List<Participant> validSpeakers = ParticipantClient.getInstance()
				.getSpeakersValid();
		for (Participant participant : validSpeakers) {
	%>
	<td><a href="presentateurs.jsp"><img alt="<%=participant.getDetails() %>" src="<%=picsURL + speaker + participant.getProfilUtilisateur().getPhoto()%>" width="100" height="100"></a></td>
	<%
		}
		%>
		</tr>
		<tr>
		<%
		for (Participant participant : validSpeakers) {
		
	%>
		<td align="center"><%=participant.getNom() + " " + participant.getPrenom() %></td>
	<%
		}
	%>
	</tr>
	</table>
</div>