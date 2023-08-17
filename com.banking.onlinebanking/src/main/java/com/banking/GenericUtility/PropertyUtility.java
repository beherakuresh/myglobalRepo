package com.banking.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
/**
 * this method is used to get the data from property file
 * @throws Throwable 
 */
	public String getProperty(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.filepath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(key);
		return value;
		
	}
}
