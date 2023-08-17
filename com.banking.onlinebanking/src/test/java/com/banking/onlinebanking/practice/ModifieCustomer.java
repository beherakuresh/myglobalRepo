package com.banking.onlinebanking.practice;

import org.testng.annotations.Test;

import com.banking.GenericUtility.BaseClass;

public class ModifieCustomer extends BaseClass{
@Test(groups="smoke")
public void modifyCustomer()
{
	System.out.println("modify the customer");
}
	@Test(groups="smoke")
public void customerModified()
{
	System.out.println("customer modified sucessfully");
}
}
