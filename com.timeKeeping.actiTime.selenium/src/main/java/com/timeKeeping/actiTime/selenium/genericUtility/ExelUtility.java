package com.timeKeeping.actiTime.selenium.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExelUtility{
	public String fetchDataFromExelFile(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/ExelData10am.xlsx");
		Workbook workBook= WorkbookFactory.create(fis);
		Sheet sheet=workBook.getSheet(sheetName);
		return sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();	
	}

}
