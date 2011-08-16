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
	 $("#mc_embed_signup").css('height', '800px');
	 $("#subscribe_part").css('visibility', 'visible');
	 
	 $("#subscribe").css('visibility', 'hidden');
	 
	 
     }
     
     function retour(){
	 $("#formations_details").css('visibility', 'visible');
	 $("#formations_details").css('height', 'auto');
	 $("#mc_embed_signup").css('height', '0px');
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
	<a style="color: red;" href="<%=request.getContextPath()%>/pages/login.jsp">Veuillez vous connecter pour vous inscrire aux formations.</a>
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
    
    
    
<!-- Begin MailChimp Signup Form -->
<!--[if IE]>
<style type="text/css" media="screen">
    #mc_embed_signup fieldset {position: relative;}
    #mc_embed_signup legend {position: absolute; top: -1em; left: .2em;}
</style>
<![endif]--> 
<!--[if IE 7]>
<style type="text/css" media="screen">
    .mc-field-group {overflow:visible;}
</style>
<![endif]-->

<div id="mc_embed_signup" style="height: 0px">
<form action="http://jcertif.us1.list-manage1.com/subscribe/post?u=2e4415df25cb501b5213a89c9&amp;id=29acc2a055" method="post" id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form" class="validate" target="_blank" style="font: normal 100% Arial, sans-serif;font-size: 10px;">
    <fieldset style="-moz-border-radius: 4px;border-radius: 4px;-webkit-border-radius: 4px;border: 1px solid #ccc;padding-top: 1.5em;margin: .5em 0;background-color: #FFFFFF;color: #000;text-align: left;">
    <legend style="white-space: normal;text-transform: capitalize;font-weight: bold;color: #000;background: #fff;padding: .5em 1em;border: 1px solid #ccc;-moz-border-radius: 4px;border-radius: 4px;-webkit-border-radius: 4px;font-size: 1.2em;"><span>Inscription</span></legend>
<div class="indicate-required" style="text-align: right;font-style: italic;overflow: hidden;color: #000;margin: 0 9% 0 0;">* indicates required</div>
<div class="mc-field-group" style="margin: 1.3em 5%;clear: both;overflow: hidden;">
<label for="mce-EMAIL" style="display: block;margin: .3em 0;line-height: 1em;font-weight: bold;">Email Address <strong class="note-required">*</strong>
</label>
<input type="text" value="" name="EMAIL" class="required email" id="mce-EMAIL" style="margin-right: 1.5em;padding: .2em .3em;width: 90%;float: left;z-index: 999;"/>
</div>
<div class="mc-field-group" style="margin: 1.3em 5%;clear: both;overflow: hidden;">
<label for="mce-MMERGE1" style="display: block;margin: .3em 0;line-height: 1em;font-weight: bold;">Choix 1 <strong class="note-required">*</strong>
</label>
<select name="MMERGE1" class="required" id="mce-MMERGE1" style="margin-right: 1.5em;padding: .2em .3em;width: 90%;float: left;z-index: 999;">
<option value=""></option>
<option value="Jour 1 (niveau débutant)">Jour 1 (niveau débutant)</option>
<option value="Jour 2 (niveau intermédiaire)">Jour 2 (niveau intermédiaire)</option>
<option value="Jour 3 (niveau avancé)">Jour 3 (niveau avancé)</option>

</select>
</div>
<div class="mc-field-group" style="margin: 1.3em 5%;clear: both;overflow: hidden;">
<label for="mce-MMERGE2" style="display: block;margin: .3em 0;line-height: 1em;font-weight: bold;">Choix 2 </label>
<select name="MMERGE2" class="" id="mce-MMERGE2" style="margin-right: 1.5em;padding: .2em .3em;width: 90%;float: left;z-index: 999;">
<option value=""></option>
<option value=""></option>
<option value="Jour 1 (niveau débutant)">Jour 1 (niveau débutant)</option>
<option value="Jour 2 (niveau intermédiaire)">Jour 2 (niveau intermédiaire)</option>
<option value="Jour 3 (niveau avancé)">Jour 3 (niveau avancé)</option>

</select>
</div>
<div class="mc-field-group" style="margin: 1.3em 5%;clear: both;overflow: hidden;">
<label for="mce-MMERGE3" style="display: block;margin: .3em 0;line-height: 1em;font-weight: bold;">Choix 3 </label>
<select name="MMERGE3" class="" id="mce-MMERGE3" style="margin-right: 1.5em;padding: .2em .3em;width: 90%;float: left;z-index: 999;">
<option value=""></option>
<option value=""></option>
<option value="Jour 1 (niveau débutant)">Jour 1 (niveau débutant)</option>
<option value="Jour 2 (niveau intermédiaire)">Jour 2 (niveau intermédiaire)</option>
<option value="Jour 3 (niveau avancé)">Jour 3 (niveau avancé)</option>

</select>
</div>
        <div id="mce-responses" style="float: left;top: -1.4em;padding: 0em .5em 0em .5em;overflow: hidden;width: 90%;margin: 0 5%;clear: both;">
            <div class="response" id="mce-error-response" style="display: none;margin: 1em 0;padding: 1em .5em .5em 0;font-weight: bold;float: left;top: -1.5em;z-index: 1;width: 80%;background: FBE3E4;color: #D12F19;"></div>
            <div class="response" id="mce-success-response" style="display: none;margin: 1em 0;padding: 1em .5em .5em 0;font-weight: bold;float: left;top: -1.5em;z-index: 1;width: 80%;background: #E3FBE4;color: #529214;"></div>
        </div>
        <div><input type="submit" value="<%=session.getAttribute("formations.jsp.subscribe")%>" name="subscribe" id="mc-embedded-subscribe" class="btn" style="clear: both;width: auto;display: block;margin: 1em 0 1em 5%;"/></div>
    </fieldset>    
    <a href="#" id="mc_embed_close" class="mc_embed_close" style="display: none;">Close</a>
</form>
</div>
<script type="text/javascript">
var fnames = new Array();var ftypes = new Array();fnames[0]='EMAIL';ftypes[0]='email';fnames[1]='MMERGE1';ftypes[1]='dropdown';fnames[2]='MMERGE2';ftypes[2]='dropdown';fnames[3]='MMERGE3';ftypes[3]='dropdown';
try {
    var jqueryLoaded=jQuery;
    jqueryLoaded=true;
} catch(err) {
    var jqueryLoaded=false;
}
var head= document.getElementsByTagName('head')[0];
if (!jqueryLoaded) {
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = 'http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js';
    head.appendChild(script);
    if (script.readyState && script.onload!==null){
        script.onreadystatechange= function () {
              if (this.readyState == 'complete') mce_preload_check();
        }    
    }
}
var script = document.createElement('script');
script.type = 'text/javascript';
script.src = 'http://downloads.mailchimp.com/js/jquery.form-n-validate.js';
head.appendChild(script);
var err_style = '';
try{
    err_style = mc_custom_error_style;
} catch(e){
    err_style = 'margin: 1em 0 0 0; padding: 1em 0.5em 0.5em 0.5em; background: FFEEEE none repeat scroll 0% 0%; font-weight: bold; float: left; z-index: 1; width: 80%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial; color: FF0000;';
}
var head= document.getElementsByTagName('head')[0];
var style= document.createElement('style');
style.type= 'text/css';
if (style.styleSheet) {
  style.styleSheet.cssText = '.mce_inline_error {' + err_style + '}';
} else {
  style.appendChild(document.createTextNode('.mce_inline_error {' + err_style + '}'));
}
head.appendChild(style);
setTimeout('mce_preload_check();', 250);

var mce_preload_checks = 0;
function mce_preload_check(){
    if (mce_preload_checks>40) return;
    mce_preload_checks++;
    try {
        var jqueryLoaded=jQuery;
    } catch(err) {
        setTimeout('mce_preload_check();', 250);
        return;
    }
    try {
        var validatorLoaded=jQuery("#fake-form").validate({});
    } catch(err) {
        setTimeout('mce_preload_check();', 250);
        return;
    }
    mce_init_form();
}
function mce_init_form(){
    jQuery(document).ready( function($) {
      var options = { errorClass: 'mce_inline_error', errorElement: 'div', onkeyup: function(){}, onfocusout:function(){}, onblur:function(){}  };
      var mce_validator = $("#mc-embedded-subscribe-form").validate(options);
      $("#mc-embedded-subscribe-form").unbind('submit');//remove the validator so we can get into beforeSubmit on the ajaxform, which then calls the validator
      options = { url: 'http://jcertif.us1.list-manage.com/subscribe/post-json?u=2e4415df25cb501b5213a89c9&id=29acc2a055&c=?', type: 'GET', dataType: 'json', contentType: "application/json; charset=utf-8",
                    beforeSubmit: function(){
                        $('#mce_tmp_error_msg').remove();
                        $('.datefield','#mc_embed_signup').each(
                            function(){
                                var txt = 'filled';
                                var fields = new Array();
                                var i = 0;
                                $(':text', this).each(
                                    function(){
                                        fields[i] = this;
                                        i++;
                                    });
                                $(':hidden', this).each(
                                    function(){
                                        var bday = false;
                                        if (fields.length == 2){
                                            bday = true;
                                            fields[2] = {'value':1970};//trick birthdays into having years
                                        }
                                        if ( fields[0].value=='MM' && fields[1].value=='DD' && (fields[2].value=='YYYY' || (bday && fields[2].value==1970) ) ){
                                            this.value = '';
                                        } else if ( fields[0].value=='' && fields[1].value=='' && (fields[2].value=='' || (bday && fields[2].value==1970) ) ){
                                            this.value = '';
                                        } else {
                                            this.value = fields[0].value+'/'+fields[1].value+'/'+fields[2].value;
                                        }
                                    });
                            });
                        return mce_validator.form();
                    }, 
                    success: mce_success_cb
                };
      $('#mc-embedded-subscribe-form').ajaxForm(options);      
      
    });
}
function mce_success_cb(resp){
    $('#mce-success-response').hide();
    $('#mce-error-response').hide();
    if (resp.result=="success"){
        $('#mce-'+resp.result+'-response').show();
        $('#mce-'+resp.result+'-response').html(resp.msg);
        $('#mc-embedded-subscribe-form').each(function(){
            this.reset();
        });
    } else {
        var index = -1;
        var msg;
        try {
            var parts = resp.msg.split(' - ',2);
            if (parts[1]==undefined){
                msg = resp.msg;
            } else {
                i = parseInt(parts[0]);
                if (i.toString() == parts[0]){
                    index = parts[0];
                    msg = parts[1];
                } else {
                    index = -1;
                    msg = resp.msg;
                }
            }
        } catch(e){
            index = -1;
            msg = resp.msg;
        }
        try{
            if (index== -1){
                $('#mce-'+resp.result+'-response').show();
                $('#mce-'+resp.result+'-response').html(msg);            
            } else {
                err_id = 'mce_tmp_error_msg';
                html = '<div id="'+err_id+'" style="'+err_style+'"> '+msg+'</div>';
                
                var input_id = '#mc_embed_signup';
                var f = $(input_id);
                if (ftypes[index]=='address'){
                    input_id = '#mce-'+fnames[index]+'-addr1';
                    f = $(input_id).parent().parent().get(0);
                } else if (ftypes[index]=='date'){
                    input_id = '#mce-'+fnames[index]+'-month';
                    f = $(input_id).parent().parent().get(0);
                } else {
                    input_id = '#mce-'+fnames[index];
                    f = $().parent(input_id).get(0);
                }
                if (f){
                    $(f).append(html);
                    $(input_id).focus();
                } else {
                    $('#mce-'+resp.result+'-response').show();
                    $('#mce-'+resp.result+'-response').html(msg);
                }
            }
        } catch(e){
            $('#mce-'+resp.result+'-response').show();
            $('#mce-'+resp.result+'-response').html(msg);
        }
    }
}

</script>
<!--End mc_embed_signup-->

  
    </div>
		 </div>
    <jsp:include page="footer.jsp" />
    </div>
</body>
</html>