package com.banking.onlinebanking.practice;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DatabaseValidation {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		Statement s=con.createStatement();
		String query="select*from student;";
		ResultSet r=s.executeQuery(query);
		String expecteddata="amlan bangalore old";
		boolean flag=false;
		while(r.next())
		{
			
			String actualdata=r.getString(1)+" "+r.getString(2)+" "+r.getString(3);
			System.out.println(actualdata);
			if(actualdata.equalsIgnoreCase(expecteddata))
			{
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("data present in student table ");
		}
		else
		{
			System.out.println("data not found");
		}
		con.close();
		
	}

}


