<%@page import="java.util.ArrayList"%>
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
	
	<table width="auto">
		
	<%
		String picsURL = JCertifProps.getInstance().getPicsUrl();
		String speaker = UIConst.URL_SPEAKER_IMG;
		int tailleMax = 7;
		List<List<Participant>> list = new ArrayList<List<Participant>>();
		
		List<Participant> validSpeakers = ParticipantClient.getInstance()
		.getSpeakersValid();
		int index = 0;
		List<Participant> tempList=new ArrayList<Participant>();
		list.add(tempList);
		for (Participant participant : validSpeakers) {
			
			if(index%tailleMax==0){
				tempList = new ArrayList<Participant>();
				list.add(tempList);
				tempList.add(participant);
			} else {
				tempList.add(participant);
			}
			index++;
		}
		
		
		for(List<Participant> partList : list) {
			%>
			<tr>
			<%
			for (Participant participant : partList) {
	%>
	<td><a href="<%="presentateurs.jsp#" + participant.getId()%>" ><img alt="<%=participant.getDetails() %>" src="<%=picsURL + speaker + participant.getProfilUtilisateur().getPhoto()%>" height="75px" width="75px" border="0"></a></td>
	<%
		}
		%>
		</tr>
		<tr>
		<%
		for (Participant participant : partList) {
		
	%>
		<td align="center" width="75px"><%=participant.getPrenom() + " " + participant.getNom() + " (" + participant.getCompagnie() + ")" %></td>
	<%
		}
		%>
		</tr>
		<%
		
		}
	%>
	
	
	
	
	</table>
</div>