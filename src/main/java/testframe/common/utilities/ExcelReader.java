package testframe.common.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelReader {

	public  List<Map<String, String>> getData(String excelFilePath, String sheetName)
			throws InvalidFormatException, IOException {
		Sheet sheet = getSheetByName(excelFilePath, sheetName);
		return readSheet(sheet);

	}

	public  List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
			throws InvalidFormatException, IOException {
		Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
		return readSheet(sheet);
	}

	@SuppressWarnings("unused")
	private  Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
		Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
		if (sheet != null){
			return sheet;
		}
		else{
			throw new IOException("Could not find Sheet Name :'"+ sheetName + "' in excel -" +excelFilePath);
		}
	}

	private  Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
		Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
		if (sheet != null){
			return sheet;
		}
		else{
			throw new IOException("Could not find Sheet Number :'"+ sheetNumber + "' in excel -" +excelFilePath);
		}
	}

	private  Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
		if(new File(excelFilePath).exists()){
			return WorkbookFactory.create(new File(excelFilePath));
		}
		else
			throw new IOException("Could not find excel file :'"+ excelFilePath + "'");
	}

	private  List<Map<String, String>> readSheet(Sheet sheet) {
		Row row;
		int totalRow = sheet.getPhysicalNumberOfRows();
		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
		int headerRowNumber = getHeaderRowNumber(sheet);
		if (headerRowNumber != -1) {
			int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
			int setCurrentRow = 1;
			for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
				row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
				LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
				}
				excelRows.add(columnMapdata);
			}
		}
		return excelRows;
	}


	private  int getHeaderRowNumber(Sheet sheet) {
		Row row;
		int totalRow = sheet.getLastRowNum();
		for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
			row = getRow(sheet, currentRow);
			if (row != null) {
				int totalColumn = row.getLastCellNum();
				for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
					Cell cell;
					cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					if (cell.getCellType() == CellType.STRING) {
						return row.getRowNum();

					} else if (cell.getCellType() == CellType.NUMERIC) {
						return row.getRowNum();

					} else if (cell.getCellType() == CellType.BOOLEAN) {
						return row.getRowNum();
					} else if (cell.getCellType() == CellType.ERROR) {
						return row.getRowNum();
					}
				}
			}
		}
		return (-1);
	}

	private  Row getRow(Sheet sheet, int rowNumber) {
		return sheet.getRow(rowNumber);
	}

	private  LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
		Workbook wb =sheet.getWorkbook();
		wb.setForceFormulaRecalculation(true);
		sheet.setForceFormulaRecalculation(true);
		FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

		LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
		Cell cell;

		if (row == null) {
			if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() != CellType.BLANK) {
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
						.getStringCellValue();
				columnMapdata.put(columnHeaderName, "");
			}
		} else {
			cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if (cell.getCellType() == CellType.FORMULA) 
				//cell.getCachedFormulaResultType();
				try{
					evaluator.evaluateFormulaCell(cell);}
			catch(Exception e){
				System.out.println(e);
			}
			if (cell.getCellType() == CellType.STRING) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex()).getStringCellValue();
					columnMapdata.put(columnHeaderName, cell.getStringCellValue());
				}
			} else if (cell.getCellType() == CellType.NUMERIC) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex()).getStringCellValue();
					columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
				}
			} else if (cell.getCellType() == CellType.BLANK) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex()).getStringCellValue();
					columnMapdata.put(columnHeaderName, "");
				}
			} else if (cell.getCellType() == CellType.BOOLEAN) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex()).getStringCellValue();
					columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
				}
			} else if (cell.getCellType() == CellType.ERROR) {
				if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType() != CellType.BLANK) {
					String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex()).getStringCellValue();
					columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
				}
			}
		}
		return columnMapdata;
	}

	public void checkAndCreateHeaderColumn(String excelFilePath, String sheetName,String columnName) throws InvalidFormatException, IOException{
		String columnHeaderName, sFoundCol ="N";

		Cell cell;
		Row row;
		Sheet sheet = getSheetByName(excelFilePath, sheetName);
		Workbook wb =sheet.getWorkbook();

		int totalColumn = sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();
		
		for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
			columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
			if(columnHeaderName.equalsIgnoreCase(columnName)){
				sFoundCol ="Y";
				break;
			}
		}

		if(sFoundCol == "N"){
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = WorkbookFactory.create(inputStream);
			Sheet sSheet = workbook.getSheet(sheetName);
			row = sSheet.getRow(sSheet.getFirstRowNum());
			cell = row.createCell(totalColumn++,CellType.STRING);
			cell.setCellValue(columnName);
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(new File(excelFilePath));
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();
		}
	}

	public void setValueInColumnforRow(String excelFilePath, String sheetName,String columnName,int rowNo,String setValue) throws Exception, IOException{
		String columnHeaderName, sFoundCol ="N";
		Cell cell;
		Row row;

		//Workbook wb =getWorkBook(excelFilePath);
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		Workbook workbook = WorkbookFactory.create(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNo);
		int totalColumn = sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();

		//Sheet sheet = getSheetByName(excelFilePath, sheetName);
		//Workbook wb =sheet.getWorkbook();
		//row = sheet.getRow(rowNo);
		//int totalColumn = sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();
		for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
			columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
			if(columnHeaderName.equalsIgnoreCase(columnName)){
				sFoundCol ="Y";
				cell = row.createCell(currentColumn,CellType.STRING);
				cell.setCellValue(setValue);
				break;
			}
		}
		inputStream.close();
		if (sFoundCol =="N"){
			workbook.close();
			checkAndCreateHeaderColumn(excelFilePath, sheetName, columnName);
			setValueInColumnforRow(excelFilePath,  sheetName, columnName, rowNo, setValue);
		}
		else if (sFoundCol =="Y"){
			FileOutputStream outputStream = new FileOutputStream(new File(excelFilePath));
			workbook.write(outputStream);
			outputStream.close();
		}
		workbook.close();
		if (sFoundCol =="N")
			throw new Exception("Could not find column '"+ columnName + "'  in excel file :'"+ excelFilePath + "' and sheet :'"+ sheetName + "'");
	}
	
	public void copyExcelFile(String fromLocation, String toLocation) throws IOException{
		
		File from = new File(fromLocation); 
		File to = new File(toLocation);
		FileUtils.copyFileToDirectory(from, to);
	}
	

}
