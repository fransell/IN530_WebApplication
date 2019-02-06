package it.uniroma3.persistence;

import java.sql.*;

import org.apache.log4j.Logger;

public class DataSource {
	final static Logger logger = Logger.getLogger(DataSource.class);
	private String dbURI =  "jdbc:mysql://localhost:3306/studenti";
	private String userName = "root";
	private String password = "admin";

	public Connection getConnection() throws PersistenceException {
		Connection connection = null;
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    connection = DriverManager.getConnection(dbURI,userName, password);
		} catch (ClassNotFoundException e) {
			logger.error(e);
			throw new PersistenceException(e.getMessage());
		} catch(SQLException e) {
			logger.error(e);
			throw new PersistenceException(e.getMessage());
		}
		return connection;
	}
} 
