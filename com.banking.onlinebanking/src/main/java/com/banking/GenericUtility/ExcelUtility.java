package com.banking.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String readDataFromExcel(String sheetname,int rnum,int cnum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook book=WorkbookFactory.create(fis);
		DataFormatter df=new DataFormatter();
		Sheet sh = book.getSheet(sheetname);
		String cvalue=df.formatCellValue(sh.getRow(rnum).getCell(cnum));
		return cvalue;
		
	}
	public void writeDataInExcel(String sheetname,int rnum,int cnum,String value)throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.excelpath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		sh.createRow(0).createCell(0).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IpathConstants.excelpath);
		book.write(fos);
		fos.flush();
	//	book.close();
		
	}
	public HashMap<String,String> fetchMultipleDataFromExcel(String sheetname,int keycellnum,int valuecellnum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.excelpath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		int lastrow=sh.getLastRowNum();
		HashMap<String, String> map=new HashMap<String, String>();
		for(int i=0;i<=lastrow;i++)
		{
			String key=sh.getRow(i).getCell(keycellnum).getStringCellValue();
			String value=sh.getRow(i).getCell(valuecellnum).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	public int getLastRownum(String sheetname) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.filepath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		int lastrownum=sh.getLastRowNum();
		return lastrownum;
		
	}
	public Object[][] dataproviderTestng(String sheetname) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		int lastrow=sh.getLastRowNum()+1;
		int lastcell=sh.getRow(0).getLastCellNum();
		Object obj[][]=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
		
		
	}
	
	


