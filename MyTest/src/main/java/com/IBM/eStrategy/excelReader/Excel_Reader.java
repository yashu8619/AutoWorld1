package com.IBM.eStrategy.excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {
	
	public String path;
	public FileOutputStream fos = null;
	public FileInputStream fis;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow row;
	public XSSFCell cell;
	
	 public Excel_Reader(String path) {		 
		 this.path=path;		 
		 try {
			 fis=new FileInputStream(path);		
			 wb=new XSSFWorkbook(fis);			
		 	} catch (Exception e) {
		 	  e.printStackTrace();			
		}		 
	 }
	
	 @SuppressWarnings("deprecation")
	public String[][] getDatafromSheet ( String sheetName, String ExcelName) {
		 String dataset[][]=null;
		 
		 
		 // get sheet from excelfile
		 try {
			sh= wb.getSheet(sheetName);
			 // count no of rows having data
			 int totalRow=sh.getLastRowNum()+1;
			 // count no of columns
			 int totalColumn=sh.getRow(0).getLastCellNum();
			 // create array of rows and column
			 dataset=new String[totalRow-1][totalColumn];
			 
			 // this for loop will run on rows
			 for(int i=1;i<totalRow;i++ ) {
				 row=sh.getRow(i);
				 
				// this for loop will run on columns
				 for(int j=0;j<totalColumn;j++ ) {
					 cell=row.getCell(j);
					 
			    // if the cell is of string type
				 if(cell.getCellType()==cell.CELL_TYPE_STRING) 			 
					dataset[i-1][j]=cell.getStringCellValue();		     
				 else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
				 {
					dataset[i-1][j]=String.valueOf(cell.getNumericCellValue());
				 } 	else
					dataset[i-1][j]=String.valueOf(cell.getBooleanCellValue());
				 }
				 
			}
			 
			 return dataset;
		} catch (Exception e) {
			System.out.println("exception in reading xcel file is "+e.getMessage());
			e.printStackTrace();
		}
			 
				return dataset; 		 
			 
		 }
		 			 
			 @SuppressWarnings("deprecation")
			public String getCellData( String sheetName, String colName, int rowNum) {
				 
			 try {
				int col_Num=0;
				 int index=wb.getSheetIndex(sheetName);
				 sh=wb.getSheetAt(index);
				 row=sh.getRow(0);
				 for ( int i=0;i< row.getLastCellNum();i++) {
					 if(row.getCell(i).getStringCellValue().equals(colName)) {
						 col_Num=i;
						 break;
					 }			 
				 }
				 
				 row=sh.getRow(rowNum-1);
				 cell=row.getCell(col_Num);
				 if(cell.getCellType()==cell.CELL_TYPE_STRING) {
					 return cell.getStringCellValue();
				 } else if (cell.getCellType()==cell.CELL_TYPE_BLANK) {
					 return "";
				 }
			} catch (Exception e) {				
				e.printStackTrace();
			}
			 
				return null;	 

			 }		 		 
	 }


