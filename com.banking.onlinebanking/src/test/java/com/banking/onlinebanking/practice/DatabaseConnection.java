package com.banking.onlinebanking.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseConnection {

	public static void main(String[] args) throws SQLException
	{
		Connection con = null;
		ResultSet result= null;
		
		//register the database
		
		Driver driver = new Driver();
	
		DriverManager.registerDriver(driver);
		//get connection for database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		System.out.println("Database connected");
		//create statement
		Statement state=con.createStatement();
		//String query="insert into student values('rahul','hyderabad','manual')";
		//String query="select *from student;";
		//execute query
		String query="insert into student values('NarendraModi','delhi','rajniti')";
		try {
			//System.out.println("tey");

			state.executeUpdate(query); 
			//System.out.println("try");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
		
		
		
		
		System.out.println("executed");
		
	
	
		
	
		con.close();
		
		}
		
		

	
	}
