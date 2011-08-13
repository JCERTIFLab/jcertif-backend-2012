<%@page import="com.jcertif.presentation.ui.util.UIConst"%>
<%@page import="com.jcertif.presentation.ui.util.JCertifProps"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page="i18n.jsp" />
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en" >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="style.css" media="screen" />
    <link type="text/css" href="css/bottom.css" rel="stylesheet" />
    <link type="text/css" href="css/li-scroller.css" rel="stylesheet" />

<script type="text/javascript" src="js/jcertif.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.li-scroller.1.0.js"></script>
 <link type="text/css" href="../VAADIN/themes/jcertifruno/styles.css" rel="stylesheet" />
 
 <script language="javascript">
     
     function subscribe(){
	 $("#formations_details").css('visibility', 'hidden');
	  $("#formations_details").css('height', '0px');
	 $("#subscribe_form").css('height', '800px');
	 $("#subscribe_part").css('visibility', 'visible');
	 
	 $("#subscribe").css('visibility', 'hidden');
	 
	 
     }
     
     function retour(){
	 $("#formations_details").css('visibility', 'visible');
	 $("#formations_details").css('height', 'auto');
	 $("#subscribe_form").css('height', '0px');
	 $("#subscribe_part").css('visibility', 'hidden');
	 
	 $("#subscribe").css('visibility', 'visible');
	
	 
     }
     
 </script>
 
 <title><%=session.getAttribute("formations.jsp.title")%></title>
</head>
<body>

<div id="main_container">
    <jsp:include page="headertemplate.jsp"/>
     <%
	session.setAttribute("url", request.getContextPath() +"/pages/formations.jsp");
	String picsURL = JCertifProps.getInstance().getPicsUrl();
	String partenaire = UIConst.URL_PARTNER_IMG;
	String speaker = UIConst.URL_SPEAKER_IMG;
     %>
     <div  style="font-size: 14px; padding-left: 50px;padding-right: 100px">
     <div id="formations_details">
     <p>
    <br/>
	 
    JCertif University vous propose 3 jours de formations JAVA qui se dérouleront <b>du 31/08/2011 au 02/09/2011</b>.
	 
	
	 <br/>
	 <br/>
	 
	 
	 <span style="font-size: 18px; font-weight: bold">PLANNING</span>
	 <br/>
	 <br/>
	 <center>
	     <table border="1" cellspacing="0" width="800px" style="border-color: darkorange">
	     <thead align="center" style="background-color: darkorange">
		 <tr>
		     <td><b>Jour 1</b></td>
		     <td><b>Jour 2</b></td>
		     <td><b>Jour 3</b></td>
		 </tr>
		 
	     </thead>
	     <tbody>
		 <tr align="center">
		     <td>Introduction au la langage Java<br/>(niveau débutant)</td>
		     <td>Développement Web avec Java<br/>(niveau intermédiaire)</td>
		     <td>Architectue Java EE<br/>(niveau avancé)</td>
		 </tr>
		 <tr valign="top">
		     <td><ul><li>Types primitifs</li><li>Classes, interfaces</li><li>Héritage, polymorphisme</li><li>Thread, Runnable</li><li>Réalisation d'un mini-projet</li><li>...</li></ul></td>
		     <td><ul><li>Servlets</li><li>JSP</li><li>Expression language</li><li>Java Server Face</li><li>Réalisation d'un mini-projet</li><li>...</li></ul></td>
		     <td><ul><li>Architecture d'un projet Java EE</li><li>Serveur d'application(GlassFish)</li><li>Entreprise JavaBeans</li><li>Clustering sous GlassFish</li><li>Réalisation d'un mini-projet</li><li>...</li></ul></td>
		 </tr>
	     </tbody>
	     
	 </table>
</center>
	  <br/>
	 <br/>
	 <div style="color: red; font-size: 14px">Ces formations sont gratuites, les inscrits à la conférence sont prioritaires.</div>
	 
	 <br/>
	 
	<%
	if (session.getAttribute("connected") == null || session.getAttribute("connected").equals(Boolean.FALSE)) {
	%>
	Veuillez vous connecter pour vous inscrire aux formations.
	<%
	} else {
	 
	
	%>
	    <button id="subscribe" onclick="subscribe()"><%=session.getAttribute("formations.jsp.subscribe")%></button>
	<%
	}
	%>
	
	 <br/>
	 <br/>
	 <span style="font-size: 18px;font-weight: bold">FORMATEURS</span>
	 <br/>
	 <br/>
	 <table style="font-size: 13px;" cellspacing="10" width="800px" border="0">
	     <tr valign="top" align="left">
		 <td><img  alt="" src="<%=picsURL + speaker %>arun.png" height="auto" width="100px" border="0"/></td>
		 <td><div style="font-size: 18px;font-weight: bold">Arun Gupta</div> est un évangéliste des technologies Java EE et GlassFish chez Oracle. Avec plus de 14 ans d'expérience dans l'industrie du logiciel, Arun a travaillé sur la Java (TM) et sur plusieurs autres technologies liées au Web. Son rôle est de créer et promouvoir une grande communauté autour de Java EE 6 et de GlassFish. Arun a travaillé dans l'équipe dédiée à la plateforme Java EE chez Sun Microsystems et a contribué à toutes les évolutions de Java EE jusqu'à ce jour. Arun parcourt le monde aujourd'hui pour présenter à des conférences et donner des formations en développement d'application avec Java EE 6. Avec plus de 1000 posts et 25.0000 visites par jour sur son blog, Arun est un blogueur prolifique et très influent : http://blogs.sun.com/arungupta. Vous pouvez le suivre via Twitter à : @ arungupta.</td>
	     </tr>
	     <tr valign="top">
		 <td><img src="<%=picsURL + partenaire %>stanyslas.jpg" height="auto" width="100px" border="0"/></td>
		 <td><div style="font-size: 18px;font-weight: bold">Stanyslas Matayo Bweta</div>a commencé à apprendre Java en 2004 de façon autodidacte dans le cadre de son travail de fin d'étude. Il a travaillé à la conception de plusieurs petites applications de calcul scientifique, particulièrement dans le domaine des méthodes de visualisation de mouvement et de calculs en génie civil. Après ses études, il a fait de la consultance pour quelques entreprises dans le développement des applications Web et Swing en Java. Il a été aussi Assistant a la faculté Polytechnique dans les cours de Physique et Génie Logiciel et Construction des programmes. Il porte un intérêt particulier pour l'Informatique Décisionnelle, le NoSQL, la gouvernance des systèmes informatiques et la formation. Actuellement, Stanyslas est Associé à l'informatique depuis 4 ans au bureau régional du HCR, où il a développé quelques applications d'appoint en Java, VBA, ASP.Net en plus de la gestion du réseau et des utilisateurs. Dans le cadre de JCertif, Il a participée au développement des couches BO, DAO, Services (JavaMail, StringTemplate, Web Service Rest), UI (JSP, JQuery, VAADIN) et a l'intégration de quelques patterns dans chacune de ces couches.</td>
	     </tr>
	<tr valign="top">
		 <td><img src="<%=picsURL + partenaire %>Max.png" height="auto" width="100px" border="0"/></td>
		 <td><div style="font-size: 18px;font-weight: bold">Max Bonbhel</div>Développeur expérimenté chez FUJITSU Canada, Max est certifié Java (SCJP) et possède une grande expérience comme consultant et formateur Java auprès de différents clients au Canada et parfois à l'étranger notamment en France. Comme membre du Centre d'expertise et de solution Oracle de FUJISTU Canada il se spécialise actuellement dans le développement des applications Web 2.0 avec la plate-forme Java JEE et l'architecture orienté services avec la Suite SOA d'Oracle. Max est le fondateur et le président en intérim de JUG-AFRICA le principal groupe d'utilisateur Java en AFRIQUE. JUG-AFRICA regroupe la majorité des JUGs (Java User Group) venant de plusieurs pays à travers le continent Africain de l'Égypte à l'Afrique du SUD en passant par le Mali, le Nigéria etc. Mais avant toute chose, sa première passion c'est le partage et l'échange de connaissances avec d'autres passionnées de partout ailleurs dans le monde.</td>
	     </tr>
	     <tr valign="top">
		 <td><img src="<%=picsURL + partenaire %>rossi.jpg" height="auto" width="100px" border="0"/></td>
		 <td><div style="font-size: 18px;font-weight: bold">Rossi Oddet</div>Principal Architecte de l'application JCertif App, l'outil d'inscription de JCertf 2011, Rossi travaille pour un centre de développement logiciel à Nantes (France) en tant que Team Lead. Evoluant depuis 5 ans sur la plateforme JavaEE, il aime mélanger motivation/code/stratégie/management pour réussir les projets pour lesquels il s'est engagé. Il a participé activement au développement de JCertif App, l'outil d'inscription de JCertf 2011. Il est intervenu au départ sur l'architecture Maven, la persistance de données (Hibernate), puis sur la couche WebService REST (Jersey) et enfin sur le développement des vues (Vaadin).</td>
	     </tr>
	 </table>

	
   
     </p>
	 
   </div> 
		 <div id="subscribe_part" style="visibility: hidden" height="0px">
		     <br/>
		     
    <button id="retour" onclick="retour()">Retour aux détails des formations</button>  <br/>  <br/>
    <iframe src="http://eepurl.com/fa4hg" id="subscribe_form" width="800" height="0px"></iframe>
  
    </div>
		 </div>
    <jsp:include page="footer.jsp" />
    </div>
</body>
</html>