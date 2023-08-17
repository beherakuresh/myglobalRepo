package com.banking.GenericUtility;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con=null;
	public void connectDB() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IpathConstants.dburl,IpathConstants.dbusername,IpathConstants.dbpassword);
	}
	public String ExecuteQuery(String query,int columNo,String expData) throws Throwable
	{
		ResultSet result=con.createStatement().executeQuery(expData);
		boolean flag=false;
		while(result.next())
		{
			String data=result.getString(columNo);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
				
			}
		}
		if(flag)
		{
			System.out.println("data is verified");
			return expData;
		}
		else
		{
			System.out.println("data not verified");
			return "";
		}
	}
		public void closeDb() throws Throwable
		{
			con.close();
		}
		
		
				
		
		
	}
	

