package com.jcertif.facade.util;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.springframework.util.ResourceUtils;

/**
 * Utilitaire d'injection de données.
 * 
 * @author rossi.oddet
 * 
 */
public class JDDInjector {

	public static void cleanInsert(String script) throws Exception {
		IDataSet dataSetInsert = new FlatXmlDataSetBuilder().build(new StringReader(script));

		IDataSet dataSetClean = new FlatXmlDataSetBuilder().build(ResourceUtils
				.getFile("classpath:clean-dataset.xml"));

		ResourceBundle rb = ResourceBundle.getBundle("jdbc");
		String driverClass = rb.getString("jdbc.driver.classname");
		String url = rb.getString("jdbc.url");
		String user = rb.getString("jdbc.username");
		String password = rb.getString("jdbc.password");

		Connection connection = DriverManager.getConnection(url, user, password);
		IDatabaseConnection connectionDB = new MySqlConnection(connection, null);
		Class.forName(driverClass);
		DatabaseOperation.CLEAN_INSERT.execute(connectionDB, dataSetClean);

		DatabaseOperation.CLEAN_INSERT.execute(connectionDB, dataSetInsert);

	}

}
