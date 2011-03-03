<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <jsp:useBean id="imageManager" class="com.jcertif.presentation.action.util.MainImageNameLoader"scope="page">
        <jsp:setProperty name="imageManager" property="applicationAbsolutePath" value="<%= application.getRealPath("/")%>"/>
    </jsp:useBean>
     <head>
        <title>JCertif 2011</title>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen" />
        <link type="text/css" href="css/bottom.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery.pikachoose.js"></script>
        <script type="text/javascript" src="js/jquery.jcarousel.min.js"></script>
        <script type="text/javascript">
            <!--
            $(document).ready(
            function (){
                $("#pikame").PikaChoose();

                $("#pikame").jcarousel({
                    initCallback: function(carousel)
                    {
                        $(carousel.list).find('img').click(function() {
                            var clicked = parseInt($(this).parents('.jcarousel-item').attr('jcarouselindex'));
                            var last = ($(this).parents('ul').find('li:last').index() == clicked-1) ? true : false;
                            if(!last){
                                clicked = (clicked-2<=0) ? 0 : clicked-2;
                            }
                            clicked++;
                            carousel.scroll(clicked);
                        });
                    }
                });

            });		
            -->
        </script>
    </head>

    <body>
        <div id="main_container">
            <div id="header">
                <div id="logo"><a href="<%= request.getContextPath()%>/pages/home.jsp"><img src="images/logo.png" alt="" title="" border="0" /></a></div>
                <div id="menu">
                    <ul>
                        <li><a class="current" href="<%= request.getContextPath()%>/pages/home.jsp" title="">Acceuil</a></li>
                        <li><a href="<%= request.getContextPath()%>/pages/calendrier.jsp" title="">Calendrier</a></li>
                        <li><a href="<%= request.getContextPath()%>/pages/presentateurs.jsp" title="">Presentateurs</a></li>
                        <li><a href="<%= request.getContextPath()%>/pages/faq.jsp" title="">Foire aux questions</a></li>
                        <li><a href="<%= request.getContextPath()%>/pages/contact.jsp" title="">Nous contacter</a></li>
                    </ul>
                </div>
            </div>

            <div class="green_box">
                <div class="clock">
                    <img src="images/clock.png" alt="" title="" />
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
                        <li><a href="home.jsp" title="">Inscrivez-vous</a></li>
                        <li><a href="services.html" title="">Proposer un sujet</a></li>
                        <li><a class="current" href="#" title="">Sponsorship et Partenariat</a></li>
                        <li><a href="#" title="">Demande d'invitation Officielle</a></li>
                        <li><a href="contact.html" title="">Hotels et voyages</a></li>
                    </ul>
                </div>

            </div><!--end of green box-->

            <div id="main_content">
                <div id="left_content">
                    <h2>JCertif 2011</h2>
                    <div class="pikachoose">
                        <ul id="pikame" class="jcarousel-skin-pika">
                            <c:forEach var="image" items="${imageManager.allImageName}">
                                <li><a href=""><img alt=""  src="mainslide_images/${image}"/></a><span></span></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <p class="clear">
                        <img src="images/pic1.jpg" alt="" title="" class="left_img" />
                    </p>
                    <div class="read_more_link"><a href="#">read more</a></div>



                </div><!--end of left content-->

                <div id="right_content">
                    <div class="search_box">
                        <div class="search_title">Newsletter</div>
                        <input type="text" class="search_input" />
                        <input type="image" src="images/news-subscribe.png" class="submit" />
                        <div class="subsearch">
                            "Rester informer sur l'évolution des activités.
                        </div>

                    </div>
                    <br></br>

                    <div class="contact_information">
                        <h4>Contacts</h4>
                        <p>
                            <img src="images/phone_icon.gif" alt="" title="" class="box_img" />
                            0700 679 122 489<br />
                            0700 679 122 489
                        </p>
                        <br /><br />
                        <p>
                            <img src="images/contact_icon.gif" alt="" title="" class="box_img" />
                            info@jcertif.com<br />
                        </p>

                    </div>
                </div><!--end of right content-->

                <div style=" clear:both;"></div>
            </div><!--end of main content-->

            <div id="footer">
                <div class="copyright">
                    <a href="home.jsp"><img src="images/footer_logo.gif" border="0" alt="" title="" /></a>
                </div>
                <div class="footer_links">
                    <a class="current" href="<%= request.getContextPath()%>/pages/home.jsp" title="">Acceuil</a>
                    <a href="#">A Propos de JCertif 2001</a>
                    <a href="contact.jsp">Nous contacter</a>
                </div>

            </div>

        </div> <!--end of main container-->
    </body>
</html>
