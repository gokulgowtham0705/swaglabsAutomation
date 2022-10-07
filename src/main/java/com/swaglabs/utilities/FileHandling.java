package com.swaglabs.utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileHandling {
	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
//	static String globalpath =  "C:\\Users\\Gis0078\\eclipse-workspace\\com.swaglabs\\ExcelFiles\\SwaglabCrediatials.xlsx";
	static String globalpath ="D:\\\\Gokul\\\\Sample Excel datas\\\\SwaglabCrediatials.xlsx" ;
	int rowcount2;


	static List<String> usernameList = new ArrayList<String>();
	static List<String> PasswordList = new ArrayList<String>();


	public static int getrows(String globalpath2) throws IOException 
	{
		fi=new FileInputStream(globalpath2);
		wb= new XSSFWorkbook(fi);
		sheet= wb.getSheetAt(0);
		int row = sheet.getLastRowNum();
		return row;
	}

	public static int getcolumn(String path) throws IOException 
	{
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		sheet= wb.getSheetAt(0);
		int col = sheet.getRow(1).getLastCellNum();
		return col;
	}

	public static String[][] getcelldata(String path, String SheetName) throws IOException {
		fi=new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		sheet= wb.getSheet(SheetName);
		int rowcount = sheet.getLastRowNum();
		int columncount = sheet.getRow(1).getLastCellNum();
		String testdata[][] = new String[rowcount-1][columncount];

		return testdata;

	}

	public void getdata(String path2) throws IOException {
		fi = new FileInputStream(globalpath);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheetAt(0);	
		int rowcount2 = sheet.getLastRowNum();
		int columncount2 = sheet.getRow(1).getLastCellNum();
		Iterator<Row> iterator = sheet.iterator();

		while(iterator.hasNext()) {
			Row row =iterator.next();
			Iterator<Cell> celliterator = row.iterator();
			int i= 2;
			while(celliterator.hasNext()) {
				if(i%2==0) {
					usernameList.add(celliterator.next().toString());
				}
				else {
					PasswordList.add(celliterator.next().toString());
				}
				i++;
			}
		}
	}
//	D:\Gokul\Sample Excel datas
//	C:\\\\Users\\\\Gis0078\\\\eclipse-workspace\\\\com.swaglabs\\\\ExcelFiles\\\\SwaglabCrediatials.xlsx
	public static String[][] readExcel() throws IOException {
	
		
		fi = new FileInputStream("D:\\Gokul\\Sample Excel datas\\SwagTest.xlsx");
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheetAt(0);	
		int rowcount2 = sheet.getLastRowNum();
		int columncount2 = sheet.getRow(1).getLastCellNum();
		String[][] data = new String[rowcount2][columncount2];
		for(int i=1;i<=rowcount2; i++) {
			row = sheet.getRow(i);
			for(int j=0;j<columncount2;j++) {
				cell =row.getCell(j);
				DataFormatter dft = new  DataFormatter();
				String value = dft.formatCellValue(cell);
				data[i-1][j] = value; 
			
				//System.out.println(value);	
			
			
			}
			//System.out.println(rowcount2);	
			//System.out.println(columncount2);	
		}
		return data;
	}

	public static void main(String[] args) throws IOException {
		FileHandling fh = new FileHandling();
		//fh.getdata(path);
		
		
         	fh.readExcel();
         	
               	
	
		
	}
		








}
