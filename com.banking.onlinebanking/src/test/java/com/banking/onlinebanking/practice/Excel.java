package com.banking.onlinebanking.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static void main(String[] args) throws EncryptedDocumentException, Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("accountdetails");
		String value =sh.getRow(2).getCell(1).getStringCellValue();
		System.out.println(value);
		
		
	
	}
	
		
		
		

	}

	
	


