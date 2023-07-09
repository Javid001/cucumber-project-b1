package io.loop.utilities;

public class TestExcel {

    public static void main(String[] args) {
        ExcelUtils excelUtils = new ExcelUtils("C:/Users/cavid/OneDrive/Desktop/Book1.xlsx","Sheet1");
        System.out.println("data from excel = " + excelUtils.getCellData(3,0));
    }
}
