package com.mamoru.common.database;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectTest
{
	public static void main(String[] args) throws SQLException
	{
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://124.50.85.159:3307/fightingmamoru");
		dataSource.setUsername("fightingmamoru");
		dataSource.setPassword("mncd0218!");

		Connection connection = dataSource.getConnection();

		String sql = "SELECT USER_ID \n" +
					 "FROM TEST_USERS ";

		PreparedStatement pstmt = connection.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next())
		{
			System.out.println("[Data List] " + rs.getString("USER_ID"));
		}

		pstmt.close();
		connection.close();
		dataSource.close();
	}
}
