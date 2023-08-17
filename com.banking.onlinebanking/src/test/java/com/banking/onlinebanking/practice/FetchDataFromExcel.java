package com.banking.onlinebanking.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		// TODO Auto-generated method stub
		//load the file in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		//create the workbook for the file loaded
		Workbook book = WorkbookFactory.create(fis);
		//navigate to required sheet
		Sheet sh=book.getSheet("Sheet1");
		int last=sh.getLastRowNum();
		for(int i=0;i<last;i++)
		{
			for(int j=0;j<2;j++) {
			System.out.print(sh.getRow(i).getCell(j).getStringCellValue()+"      ");
			}
		System.out.println();
			
		
		}
		
				
		
		
		
		
		

		

	}

}
