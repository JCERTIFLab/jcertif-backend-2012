<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>


<jsp:include page="header.jsp" />
<script type="text/javascript">
         $(document).ready(function()
        {
           JCERTIF.menu.initAnim();
        });
	
    </script>

<div class="green_box">
	
	<div>
		<table width="100%" border="0">
			<tr>
				<td width="45%">
					<div class="text_content">
						<h1><%=session.getAttribute("headertemplate.jsp.title") %></h1>
						<p class="green"><%=session.getAttribute("headertemplate.jsp.summary") %></p>
						
					</div>
				</td>
				<td>
				    <a href="<%=request.getContextPath()%>/pages/formations.jsp" title="Ateliers de formation gratuite"><img width="170px"height="180px" src="images/jcertif_university_with_border_orange.gif" alt="Logo JCertif 2011" title="" border="0" align="left"/></a>
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
	</div>
