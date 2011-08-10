<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>


<jsp:include page="header.jsp" />
<script type="text/javascript">
         $(document).ready(function()
        {
           JCERTIF.menu.initAnim();
        });
	
	function goToFormations(){
	    window.location = "<%=request.getContextPath()%>/pages/formations.jsp";
	}
    </script>

<div class="green_box">
	
	<div>
		<table width="100%" border="0">
			<tr>
				<td width="70%">
					<div class="text_content">
						<h1><%=session.getAttribute("headertemplate.jsp.title") %></h1>
						<p class="green"><%=session.getAttribute("headertemplate.jsp.summary") %></p>
						<%
							if (session.getAttribute("connected") == null
									|| session.getAttribute("connected").equals(Boolean.FALSE)) {
						%>
						<div class="read_more">
							<a href="login.jsp"><%=session.getAttribute("headertemplate.jsp.connection") %></a>
						</div>
						<%
							}
						%>
					</div>
				</td>
				<td>
				    <img src="images/JCertif_University2011.jpg" onclick="goToFormations();" alt="Logo JCertif 2011" title="" border="0" align="left"/>
				</td>
				<td>
					<div id="right_nav">
						<ul>
							<li><a class="current" href="<%=request.getContextPath()%>/pages/partenaires.jsp" title=""><%=session.getAttribute("headertemplate.jsp.sponsors") %></a></li>
							<li><a href="infosutiles.jsp" title=""><%=session.getAttribute("headertemplate.jsp.infos") %></a></li>
							<li><a href="organisateurs.jsp" title=""><%=session.getAttribute("headertemplate.jsp.organisateur") %></a></li>
							<li><a href="communities.jsp" title=""><%=session.getAttribute("headertemplate.jsp.community") %></a></li>
							<li><a href="contact.jsp" title=""><b><%=session.getAttribute("headertemplate.jsp.contact") %></b> </a></li>

						</ul>
					</div>
				</td>
			</tr>
		</table>
                                                        </div>
   <ul id="msg_animation">
    <li><a href="<%=request.getContextPath()%>/pages/inscription.jsp">Inscrivez-vous!</a></li>
    <li><a href="<%=request.getContextPath()%>/pages/faq.jsp">Trouvez dans la FAQ l'ensemble des collecteurs pour vous acquitter de vos frais de participations</a></li>
    <li><a href="<%=request.getContextPath()%>/pages/calendrier.jsp">Créer votre agenda personnalisé grâce au calendrier interactif</a></li>
    <li><a href="https://www.facebook.com/event.php?eid=191343324246785" target="_blank">Parlez de cet évènement autour de vous</a></li>
</ul>
	</div>
