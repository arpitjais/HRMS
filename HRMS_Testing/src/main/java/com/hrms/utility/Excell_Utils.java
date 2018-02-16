package com.hrms.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excell_Utils {
	// =========== Object
	private static XSSFSheet ExcellSh;
	private static XSSFWorkbook ExcellWb;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	// ============ Methods
	// This method is to set the File path and to open the Excel file
	public static void setExcelFile(String Path) throws Exception {
		try {
			FileInputStream ExcellFile = new FileInputStream(Path);
			// Access the required test data WorkBook
			ExcellWb = new XSSFWorkbook(ExcellFile);
			// ExcellSh = ExcellWb.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	// This method is to Read the test data from the Excel cell in String Formate
	public static String getCellData(int sheetNo, int RowNum, int ColNum) {
		try {
			ExcellSh = ExcellWb.getSheetAt(sheetNo);
			String CellData = ExcellSh.getRow(RowNum).getCell(ColNum).getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}

	}

	// This method is to Read the test data from the Excel cell in String Formate
	public static int getCellDataInt(int sheetNo, int RowNum, int ColNum) throws Exception {
		try {
			ExcellSh = ExcellWb.getSheetAt(sheetNo);
			int intcellData = (int) ExcellSh.getRow(RowNum).getCell(ColNum).getNumericCellValue();
			return intcellData;
		} catch (Exception ee) {
			return 0;
		}
	}

	// This method is to Write Data in the Excel cell
	public static void setCellData(String path, int sheetNo, int RowNum, int ColNum, String Result) throws Exception {
		try {
			FileInputStream WExcellFile = new FileInputStream(path);
			ExcellWb = new XSSFWorkbook(WExcellFile);// Access the required test data sheet
			ExcellSh = ExcellWb.getSheetAt(sheetNo);
			Row = ExcellSh.getRow(RowNum);
			// Cell = Row.createCell(ColNum);
			Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL); // Check
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(path);
			ExcellWb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	// To get No of Rows
	public static int getRowCount(int SheetIndex) {
		int row = ExcellWb.getSheetAt(SheetIndex).getLastRowNum();
		return row;
	}
}
