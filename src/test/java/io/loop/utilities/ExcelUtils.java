package io.loop.utilities;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;



public class ExcelUtils {

    private Sheet workSheet;
    private Workbook workBook;
    private String path;
    private static final Logger LOG = LogManager.getLogger(Driver.class);



    public ExcelUtils(String path, String sheetName) {
        this.path = path;
        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(path);
            // Access the required test data sheet
            workBook = WorkbookFactory.create(ExcelFile);
            workSheet = workBook.getSheet(sheetName);

        } catch (Exception e) {
            LOG.error(e.getMessage());
            throw new RuntimeException(e);
        }


    }
    public String getCellData(int rowNum, int colNum){
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        } catch (Exception e){
            LOG.error(e.getMessage());
            throw new RuntimeException();
        }
    }
}
