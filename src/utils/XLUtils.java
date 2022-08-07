package utils;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils 
{
	public static FileInputStream fi;
	public static Workbook wb;
	public static Sheet sw;
	public static Row row;
	public static Cell cell;
	public static FileOutputStream fo; 
	public static CellStyle style;
	public static int getRowcount(String xlfile, String xlSheet) throws IOException
	{
	 fi = new FileInputStream(xlfile);
	 wb =new XSSFWorkbook(fi);
	 sw= wb.getSheet(xlSheet);
	 int rowcount = sw.getLastRowNum();
	wb.close(); fi.close(); 
	 return rowcount;
	
		
	}
	public static int  getcoloumcount (String xlfile, String xlSheet,int rownum) throws IOException
	{
		fi= new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sw = wb.getSheet(xlSheet);
		row = sw.getRow(rownum);
		short columcount =row.getLastCellNum();
		wb.close(); fi.close(); 
		return columcount;
	}
	public static String getStringCelldata(String xlfile, String Xlsheet, int rownum, int coulumnum) throws IOException
	{
		fi= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		sw= wb.getSheet(Xlsheet);
		row= sw.getRow(rownum);
		String data;
		try {
			cell = row.getCell(coulumnum);
			data=cell.getStringCellValue();
		} catch (Exception e) {
			data = " NO DATA!";
		} 
		wb.close(); fi.close();
		return data;
		
		
	}
	public static double getNumericCelldata(String xlfile, String Xlsheet,int rownum,int coulumnum) throws IOException
	{
	fi= new FileInputStream(xlfile);
	wb= new XSSFWorkbook(fi);
	sw= wb.getSheet(Xlsheet);
	row= sw.getRow(rownum);
	double data;
	try {
		cell= row.getCell(coulumnum);
		data=cell.getNumericCellValue();
	} catch (Exception e) {
		data= 0.0 ;
	}
	wb.close(); fi.close();
	return data;
		
	}
	public static void setcellvalue(String xlfile, String Xlsheet,int rownum,int coulumnum, String data) throws IOException
	{
	fi= new FileInputStream(xlfile);
	wb= new XSSFWorkbook(fi);
	sw= wb.getSheet(Xlsheet);
	row= sw.getRow(rownum);
	cell= row.createCell(coulumnum);
	cell.setCellValue(data);
	fo= new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close(); fi.close(); fo.close();
		}
	
	public static void fillgreencolor(String xlfile, String Xlsheet,int rownum,int coulumnum) throws IOException
	{
		fi= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		sw= wb.getSheet(Xlsheet);
		row= sw.getRow(rownum);
		cell= row.getCell(coulumnum);
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo= new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close(); fi.close(); fo.close();
		
		
	} 
	}
