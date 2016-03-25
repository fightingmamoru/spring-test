package com.common.database;

import com.mamoru.common.database.DBConnector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 테스트를 위한 설정 (with spring-test)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"classpath*:spring/root-context.xml",
		"classpath*:spring/springwebServlet/servlet-context-common.xml",
		"classpath*:spring/springwebServlet/servlet-context-datasource.xml"})
public class DBConnectorTest
{
	// LOGGER
	private static Logger LOGGER = LogManager.getLogger(DBConnectorTest.class);

	@Test
	public void testDBConnection()
	{
		Connection connection = null;
		PreparedStatement pstmt = null;

		try
		{
			DBConnector dbConnector = DBConnector.getInstance();

			connection = dbConnector.getConnection();

			String sql = "SELECT USER_ID \n" +
						 "FROM TEST_USERS ";

			pstmt = connection.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next())
			{
				LOGGER.debug("[Data List] " + rs.getString("USER_ID"));
			}
		}
		catch (Exception e)
		{
			LOGGER.error(e);
		}
		finally
		{
			try
			{
				connection.close();
			}
			catch (SQLException e)
			{
				LOGGER.error(e);
			}

			try
			{
				pstmt.close();
			}
			catch (SQLException e)
			{
				LOGGER.error(e);
			}
		}
	}
}