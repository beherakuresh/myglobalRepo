package com.banking.onlinebanking.practice;

import org.testng.annotations.Test;



public class KureshTestng {
	@Test(dependsOnMethods="delete")
	public void create()
	{
		System.out.println("this is created");
	}
	@Test(dataProviderClass=TestngDataProvider.class,dataProvider="data1")
	public void update(String n,String t)
	{
	System.out.println(n+"    "+t);
	}
	@Test()
	public void delete()
	{
		System.out.println("this is deleted");
	}
	

}
