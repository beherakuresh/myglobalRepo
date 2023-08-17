package com.banking.GenericUtility;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class JavaUtility {
	public int randomNum()
	{
		Random r=new Random();
		int i=r.nextInt(500);
		return i;
	}
	public String getSystemDate()
	{
		Date d=new Date();
		
		
		String date=d.toString();
		return date;
	}
	public String getSystemDateInFormat()
	{
		SimpleDateFormat date= new SimpleDateFormat("dd/mm/yyyy hh-MM-ss");
		Date d=new Date();
		String systemdate=date.format(d);
		return systemdate;
		
	}

}
