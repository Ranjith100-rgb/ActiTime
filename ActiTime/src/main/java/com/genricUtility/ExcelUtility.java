package com.genricUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
		public String getDataFromExcel(String FilePath,String sheetname, String tcID, String ColHeader) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
			Workbook wb = WorkbookFactory.create(new FileInputStream(FilePath));
			Sheet sheet = wb.getSheet(sheetname);
			int rowCount = sheet.getLastRowNum();
			int testRow=0;
			int testCol=0;
			String actTcID="";
			String actColHeader="";
			String data;
			for(int i=0;i<=rowCount;i++)
			{
				actTcID=sheet.getRow(i).getCell(0).toString();
				if(actTcID.equals(tcID))
				{
					break;
				}
				testRow++;
			}
			int colCount=sheet.getRow(testRow-1).getLastCellNum();
			for(int j=0;j<colCount;j++)
			{
				actColHeader=sheet.getRow(testRow-1).getCell(j).toString();
				if(actColHeader.equals(ColHeader))
				{
					break;
				}
				testCol++;
			}
			data=sheet.getRow(testRow).getCell(testCol).toString();
			return data;
		}
}
