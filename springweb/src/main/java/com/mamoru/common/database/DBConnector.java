package com.mamoru.common.database;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnector
{
	// Spring ApplicationContext
	@Autowired
	private ApplicationContext applicationContext;

	// Make BasicDataSource
	BasicDataSource MYSQL_DATASOURCE = null;

	// Instance
	private static DBConnector DB_CONNECTOR = new DBConnector();

	// Constructor
	private DBConnector()
	{
	}

	@PostConstruct
	public void init()
	{
		MYSQL_DATASOURCE = (BasicDataSource) applicationContext.getBean("basicDataSource");
	}

	public static DBConnector getInstance()
	{
		return DB_CONNECTOR;
	}


	public synchronized Connection getConnection() throws SQLException
	{
		return MYSQL_DATASOURCE.getConnection();
	}
}
