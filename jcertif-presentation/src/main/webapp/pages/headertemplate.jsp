<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>

<jsp:include page="header.jsp" />

<div class="green_box">
	<!--
        	<div class="clock">
				<img src="images/clock2.png" alt="" title="" />
            </div>
            <div class="text_content">
            	<h1>Bienvenue a JCertif 2011</h1>
                <p class="green">
                        "JCertif est le premier événement d'envergure organisé par la communauté des informaticiens du Congo et de l'Afrique Centrale. JCertif offre un espace d'échange et de collaboration sur les dernieres nouveautés et les meilleures pratiques en ce qui concerne les technologies Java, le Web 2.0 et les applications mobiles pour les téléphones portables."
                </p>
				<div class="read_more"><a href="#">Se loguer</a></div>
            </div>
            <div id="right_nav">
            	<ul>
                	<li><a href="inscription.jsp" title="">Inscrivez-vous</a></li>
                    <li><a href="propositionPresentation.jsp" title="">Proposer un sujet</a></li>
                    <li><a class="current" href="#" title="">Sponsorship et Partenariat</a></li>
                    <li><a href="#" title="">Demande d'invitation Officielle</a></li>
                    <li><a href="contact.html" title="">Hotels et voyages</a></li>
				</ul>
			</div>
			
			-->
	<div>
		<table width="100%">
			<tr>
				<td>
					<div class="text_content">
						<h1>Bienvenue a JCertif 2011</h1>
						<p class="green">"JCertif est le premier événement d'envergure
							organisé par la communauté des informaticiens du Congo et de
							l'Afrique Centrale. JCertif offre un espace d'échange et de
							collaboration sur les dernieres nouveautés et les meilleures
							pratiques en ce qui concerne les technologies Java, le Web 2.0 et
							les applications mobiles pour les téléphones portables."</p>
						<%
							if (session.getAttribute("connected") == null
									|| session.getAttribute("connected").equals(Boolean.FALSE)) {
						%>
						<div class="read_more">
							<a href="login.jsp">Se connecter</a>
						</div>
						<%
							}
						%>
					</div>
				</td>
				<td align="right">
					<div id="right_nav">
						<ul>
							<li><a class="current" href="<%=request.getContextPath()%>/pages/partenaires.jsp" title="">Sponsorship et
									Partenariat</a></li>
							<li><a href="infoUtile.html" title="">Informations
									utiles</a></li>
							<li><a href="contact.jsp" title=""><b>Nous
										contacter</b> </a></li>

						</ul>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>
