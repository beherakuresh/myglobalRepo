package com.banking.onlinebanking.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.GenericUtility.IpathConstants;

public class FetchDataFromExcel_Dataprovider 
{	
	@Test(dataProvider="getDataFromExcel")
	public void readdata(String NAME,String COURSE)
	{
		System.out.println(NAME+"   "+COURSE);
	}
	@DataProvider
	public Object[][] getDataFromExcel() throws Throwable
	{
		
		FileInputStream fis=new FileInputStream(IpathConstants.excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("data");
		int lastr=sh.getLastRowNum()+1;
		int lastc=sh.getRow(0).getLastCellNum();
		Object o[][]=new Object[lastr][lastc];
		for(int i=0;i<lastr;i++)
		{
			for(int j=0;j<lastc;j++)
			{
				o[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		return o;
		
		
		
	}
	
	

}
