<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<div id="header">
	<table border="0" width="100%">   
		<tr>
    		<td width="" align="left" >
        	    <div id="logo" align="left">
        			<a href="<%=request.getContextPath()%>/pages/home.jsp">
            			<img src="images/JCertif_Conf2011_2.png" alt="Logo JCertif 2011" title="" border="0" align="left" margin="0"/>
        			</a>
        		</div>
        	</td>
        	<td width="">
					<div id="slogan" align="right">
        				<font class=greenColor><b>Du 3 au 4 Septembre |</b></font> <font class=redColor><b>| Brazzaville, Congo</b></font> 
        			</div>
        	</td>
        </tr>
	</table>
    
    <div id="menu">
        <ul>
            <li><a class="current" href="<%=request.getContextPath()%>/pages/home.jsp" title=""><b>Acceuil</b></a></li>
            <li><a href="<%=request.getContextPath()%>/pages/inscription.jsp" title=""><b>Inscrivez-vous</b></a></li>
            <li><a href="<%=request.getContextPath()%>/pages/propositionPresentation.jsp" title=""><b>Proposer un sujet</b></a></li>           
            <li><a href="<%=request.getContextPath()%>/pages/calendrier.jsp" title=""><b>Calendrier</b></a></li>
            <li><a href="<%=request.getContextPath()%>/pages/presentateurs.jsp" title=""><b>Presentateurs</b></a></li>
            <li><a href="<%=request.getContextPath()%>/pages/faq.jsp" title=""><b>FAQ</b></a></li>
        </ul>
    </div>
</div>