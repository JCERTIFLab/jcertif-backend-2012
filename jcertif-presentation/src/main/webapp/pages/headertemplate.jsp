<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>

<jsp:include page="header.jsp" />

<div class="green_box">
	
	<div>
		<table width="100%" border="0">
			<tr>
				<td>
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
					<div id="right_nav">
						<ul>
							<li><a class="current" href="<%=request.getContextPath()%>/pages/partenaires.jsp" title=""><%=session.getAttribute("headertemplate.jsp.sponsors") %></a></li>
							<li><a href="infoUtile.html" title=""><%=session.getAttribute("headertemplate.jsp.infos") %></a></li>
							<li><a href="contact.jsp" title=""><b><%=session.getAttribute("headertemplate.jsp.contact") %></b> </a></li>

						</ul>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>
