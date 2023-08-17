package com.banking.onlinebanking.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchdataFromPropertiesFile {
	public static void main(String...args) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\k.properties");
		Properties p=new Properties();
		p.load(fis);
		String u=p.getProperty("url");
		String pass=p.getProperty("password");
		System.out.println(pass);
		System.out.println(u);
		
		
	}

}
