package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

public class ReadXLSData {
    
	 @DataProvider(name = "xlsTestData")
	    public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
	        // Use the method name as sheet name
	        String excelSheetName = m.getName();

	        File file = new File("D:\\Eclipse workplace\\SQAMAutomationDemo\\DemoAutomation\\src\\test\\resources\\testdata\\testDataLogin.xlsx");
	        FileInputStream fis = new FileInputStream(file);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet(excelSheetName);

	        if (sheet == null) {
	            throw new IllegalArgumentException("Sheet '" + excelSheetName + "' not found in Excel file.");
	        }

	        int totalRows = sheet.getLastRowNum(); // excludes header
	        Row headerRow = sheet.getRow(0);
	        int totalCols = headerRow.getLastCellNum();

	        String[][] testData = new String[totalRows][totalCols];
	        DataFormatter formatter = new DataFormatter();

	        for (int i = 1; i <= totalRows; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < totalCols; j++) {
	                if (row == null || row.getCell(j) == null) {
	                    testData[i - 1][j] = "";
	                } else {
	                    testData[i - 1][j] = formatter.formatCellValue(row.getCell(j));
	                }
	            }
	        }

	        workbook.close();
	        return testData;
	    }
	}