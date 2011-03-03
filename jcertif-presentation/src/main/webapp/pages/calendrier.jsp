<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
        <link type="text/css" href="css/bottom.css" rel="stylesheet" />
<script type="text/javascript">  
    var vaadin = {  
        vaadinConfigurations : {  
            'vaadin_div' : {  
                appUri : '/jcertif-presentation/JCertifMain/',  
                pathInfo : '/',   
                themeUri : '../VAADIN/themes/jcertifruno',  
                versionInfo : {  
                    vaadinVersion : "6.2.0-INTERNAL-NONVERSIONED-DEBUG-BUILD",  
                    applicationVersion : "NONVERSIONED"  
                }  
            }  
        }  
    };  
</script>
<script type="text/javascript"
	src='../VAADIN/widgetsets/com.jcertif.presentation.gwt.MyWidgetSet/com.jcertif.presentation.gwt.MyWidgetSet.nocache.js'></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="vaadin_div" weight="200px"></div>
</body>
</html>