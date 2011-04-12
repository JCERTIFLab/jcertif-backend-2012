<%@page import="com.jcertif.facade.util.JDDInjector"%>
<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.mysql.jdbc.Driver,org.dbunit.operation.DatabaseOperation,org.dbunit.dataset.xml.FlatXmlDataSetBuilder,org.dbunit.dataset.IDataSet,java.io.StringReader,org.springframework.util.ResourceUtils,java.util.ResourceBundle,java.sql.DriverManager,org.dbunit.database.IDatabaseConnection,org.dbunit.ext.mysql.MySqlConnection,java.sql.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Administration JCERTIF 2011</title>
</head>

<body>

	<%
		String script = request.getParameter("script");

		if (script != null) {
			JDDInjector.cleanInsert(script);
	%>
	<div>Opération terminée</div>
	<%
		} else {
			
	%>

	<form action="" method="post">

		Script <br />
		<textarea name="script" rows="30" cols="150"></textarea>
		<br /> <input type="submit" value="inserer" />
	</form>

	<%
		}
	%>

</body>
</html>
