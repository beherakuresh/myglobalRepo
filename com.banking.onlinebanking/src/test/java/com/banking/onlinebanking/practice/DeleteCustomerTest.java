package com.banking.onlinebanking.practice;

import org.testng.annotations.Test;

import com.banking.GenericUtility.BaseClass;

public class DeleteCustomerTest extends BaseClass {
	@Test(groups="smoke")
public void deleteCustomer()
{
	System.out.println("delete the customer ");
}
	@Test(groups="smoke")
public void customerDeleted()
{
	System.out.println("customer deleted");
}
}
