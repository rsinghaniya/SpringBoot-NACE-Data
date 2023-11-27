package com.nace.analysis.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nace.analysis.domain.NaceDataDto;

public class NaceDataExcelHelper {

	public static List<NaceDataDto> excelToNaceData(InputStream is) {
		List<NaceDataDto> response = new ArrayList<>();
		try {
			DataFormatter formatter = new DataFormatter();
			Workbook workbook = new XSSFWorkbook(is);
			workbook.setMissingCellPolicy(MissingCellPolicy.RETURN_NULL_AND_BLANK);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			
			int rowNum = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				if (rowNum == 0) {
					rowNum++;
					continue;
				}
				
				NaceDataDto naceDataRespose = new NaceDataDto();
				Cell currentCell;
				for(int cellIndex=0; cellIndex<currentRow.getLastCellNum(); cellIndex++) {
					currentCell = currentRow.getCell(cellIndex, MissingCellPolicy.CREATE_NULL_AS_BLANK);
					
					switch (cellIndex) {
					case 0:
						naceDataRespose.setOrderId(formatter.formatCellValue(currentCell));
						break;
					case 1:
						naceDataRespose.setLevel(formatter.formatCellValue(currentCell));
						break;
					case 2:
						naceDataRespose.setCode(formatter.formatCellValue(currentCell));
						break;
					case 3:
						naceDataRespose.setParent(formatter.formatCellValue(currentCell));
						break;
					case 4:
						naceDataRespose.setDescription(subString(formatter.formatCellValue(currentCell)));
						break;
					case 5:
						naceDataRespose.setItemIncludes(subString(formatter.formatCellValue(currentCell)));
						break;
					case 6:
						naceDataRespose.setItemIncludesExtra(subString(formatter.formatCellValue(currentCell)));
						break;
					case 7:
						naceDataRespose.setRulings(subString(formatter.formatCellValue(currentCell)));
						break;
					case 8:
						naceDataRespose.setItemExcludes(subString(formatter.formatCellValue(currentCell)));
						break;
					case 9:
						naceDataRespose.setRefIsicRev(formatter.formatCellValue(currentCell));
						break;
					default:
						break;
					}
				}
				
				response.add(naceDataRespose);
			}
			workbook.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}
	

	private static String subString(String cellValue) {
		String newString = null;
		if(cellValue.length()>200) {
			newString = cellValue.substring(0, 200);
		}else {
			newString = cellValue;
		}
		
		return newString;
	}
}
