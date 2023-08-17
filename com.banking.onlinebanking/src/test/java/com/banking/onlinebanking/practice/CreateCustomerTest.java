package com.banking.onlinebanking.practice;

import org.testng.annotations.Test;

import com.banking.GenericUtility.BaseClass;

public class CreateCustomerTest extends BaseClass{
	@Test(groups="smoke")
	public void createCustomer()
	{
		System.out.println("create the customer");
		
	}
	@Test(groups="smoke")
	public void customerCreated()
	{
		System.out.println("customer created");
	}

}
