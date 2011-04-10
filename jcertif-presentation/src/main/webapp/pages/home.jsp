<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:useBean id="imageManager"
	class="com.jcertif.presentation.action.util.MainImageNameLoader"
	scope="page">
	<jsp:setProperty name="imageManager" property="applicationAbsolutePath"
		value="<%= application.getRealPath(\"/\")%>" />
</jsp:useBean>
<head>
<title>JCertif 2011</title>
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
<link type="text/css" href="css/bottom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.pikachoose.js"></script>
<script type="text/javascript" src="js/jquery.jcarousel.min.js"></script>
<script type="text/javascript">            $(document).ready(
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
		<%
			session.setAttribute("url", request.getContextPath() +"/pages/home.jsp");
		%>
		<jsp:include page="headertemplate.jsp" />

		<div id="main_content">
			<table border="0">
				<tr>
					<td>
						<div id="left_content">
							<h2>JCertif 2011</h2>
							<div class="pikachoose">
								<ul id="pikame" class="jcarousel-skin-pika">
									<c:forEach var="image" items="${imageManager.allImageName}">
										<li><a href=""><img alt=""
												src="mainslide_images/${image}" />
										</a><span></span>
										</li>
									</c:forEach>
								</ul>
							</div>
							<!--
                    <p class="clear">
                        <img src="images/pic1.jpg" alt="" title="" class="left_img" />
                    </p>
                    <div class="read_more_link"><a href="#">read more</a></div>

                -->
						</div>
						<!--end of left content-->
						<!--
				</td>
				<td align="left" valign="top">
                -->
						<div id="right_content">
							<!--
                    <div class="search_box">
                        <div class="search_title">Newsletter</div>
                        <input type="text" class="search_input" /><br />
                        <input type="image" src="images/news-subscribe2.png" class="submit" />
                        <div class="subsearch">
                            "Rester informer sur l'évolution des activités.
                        </div>

                    </div>
                    --><jsp:include page="sponsors.jsp" />
							
						</div>
						<!--end of right content-->
						<!--

                <div style=" clear:both;"></div>
                -->
					</td>
				</tr>
				
			</table>
			
		</div>
		<!--end of main content-->

		<jsp:include page="footer.jsp" />

	</div>
	<!--end of main container-->
</body>
</html>
