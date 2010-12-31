package com.jcertif.dao.hibernate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractDAOTestCase {

	/**
	 * Fichier de nettoyage de la base de données.
	 */
	private static final String CLEAN_FILE = "com/jcertif/dao/hibernate/clean-dataset.xml";

	/**
	 * Un Logger.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AbstractDAOTestCase.class);

	/** Sufix for DBUnit files */
	private static final String DATASET_FILENAME_SUFFIX = "-dataset.xml";

	/**
	 * Session Factory Hibernate.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Datasource utilisé pour les tests.
	 */
	@Autowired
	private DataSource dataSource;

	/**
	 * Opération effectuée avant chaque test, rechargement du jeux de données.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUpTestDataWithinTransaction() throws Exception {

		final IDatabaseTester databaseTester = new DataSourceDatabaseTester(
				this.dataSource);

		// Nettoyage de la base de données.
		cleanDB();

		final IDataSet dataSet = loadDataSet();

		if (dataSet != null) {
			// DBUnit setup
			LOGGER.debug("Initializing DBUnit DataSet");
			databaseTester.setDataSet(dataSet);
			databaseTester.setSetUpOperation(getDatabaseSetupOperation());
			databaseTester.setTearDownOperation(getDatabaseTearDownOperation());
			databaseTester.onSetup();
		} else {
			LOGGER.debug("Cannot initialize DBUnit DataSet");
		}
	}

	/**
	 * Nettoyage de la base de données.
	 * 
	 * @throws DataSetException
	 * @throws DatabaseUnitException
	 * @throws SQLException
	 * @throws IOException
	 */
	private void cleanDB() throws DataSetException, DatabaseUnitException,
			SQLException, IOException {
		final File file = ResourceUtils
				.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + CLEAN_FILE);
		DatabaseOperation.CLEAN_INSERT.execute(new DatabaseConnection(
				this.dataSource.getConnection()), getXmlDataSet(file));
	}

	/**
	 * @return un dataset pour test unitaire.
	 * @throws Exception
	 */
	protected IDataSet loadDataSet() throws Exception {
		IDataSet dataSet = null;

		final String dataSetFileName = getDataSetFilename();

		try {
			final File file = ResourceUtils
					.getFile(ResourceUtils.CLASSPATH_URL_PREFIX
							+ dataSetFileName);
			dataSet = getXmlDataSet(file);
		} catch (FileNotFoundException e) {
			// Dataset are not mandatory, so a FileNotFoundException is
			// acceptable, just inform the user
			LOGGER.info("No dataset named '" + dataSetFileName
					+ "' was found in the classpath.");
		}

		return dataSet;
	}

	protected IDataSet getXmlDataSet(File file) throws DataSetException,
			IOException {
		return new FlatXmlDataSetBuilder().build(file);
	}

	protected String getDataSetFilename() {
		return StringUtils.replaceChars(this.getClass().getCanonicalName(),
				'.', File.separatorChar) + DATASET_FILENAME_SUFFIX;
	}

	protected DatabaseOperation getDatabaseSetupOperation() {
		return DatabaseOperation.CLEAN_INSERT;
	}

	protected DatabaseOperation getDatabaseTearDownOperation() {
		return DatabaseOperation.NONE;
	}

	protected void flush() {
		sessionFactory.getCurrentSession().flush();
	}

	protected void clear() {
		sessionFactory.getCurrentSession().clear();
	}

	protected void flushAndClear() {
		flush();
		clear();
	}

	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
