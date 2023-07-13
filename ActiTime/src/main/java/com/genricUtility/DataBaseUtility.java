package com.genricUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility 

{ 	
	FilePathUtility fLib=new FilePathUtility();
	Driver driver=null;
	String URL;
	String USERNAME;
	String PASSWORD;
	Connection connection;
	ResultSet result;
	
	
	public DataBaseUtility()
	{
		try {
			String dataBasePath = fLib.getFilePathFromPropertyFile("DataBaseConfigData");
			URL=fLib.getDataFromPropertyFile(dataBasePath, "url");
			USERNAME=fLib.getDataFromPropertyFile(dataBasePath, "username");
			PASSWORD=fLib.getDataFromPropertyFile(dataBasePath, "password");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connectToDB() throws SQLException
	{
		
//		driver=new Driver();
//		DriverManager.registerDriver(driver);
//		DriverManager.getConnection(URL,USERNAME,PASSWORD);
		System.out.println("DataBase has been connected");
	}
	
	public ResultSet executeQuery(String Query) throws SQLException
	{
		result=connection.createStatement().executeQuery(Query);
		return result;
	}
	public int executeUpdate(String Query) throws SQLException
	{
		int result=connection.createStatement().executeUpdate(Query);
		return result;
	}
	
	public void closeDB() throws SQLException
	{
		
		System.out.println("Database connection has been disconnected");
//		connection.close();
	}
	
	public void executeAndVerify(String Query, int ColumnIndex, String expectedData) throws SQLException
	{
		boolean flag=false;
		result=connection.createStatement().executeQuery(Query);
		while (result.next()) 
		{
			if(result.getString(ColumnIndex).equals(expectedData))
			{
				flag=true;
				break;
			}
			
		}
		
		if(flag)
		{
			System.out.println("Found");
		}
		else
		{
			System.out.println("not found");
		}
	}
}
