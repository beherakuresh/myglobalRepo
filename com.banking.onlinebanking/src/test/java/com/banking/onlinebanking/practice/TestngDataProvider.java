package com.banking.onlinebanking.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngDataProvider 
{
	@Test(dataProvider="data1")
	public void dataprovider(String name,String title)
	{
		System.out.println(name+" @"+title);
	}
	@DataProvider
	public   Object[][]  data1()
	{
		Object d[][]=new Object[2][2];
		d[0][0]="kuresh";
		d[0][1]="behera";
		
		d[1][0]="ram";
		d[1][1]="sahoo";
		return d;
		
			
		
	}

}
