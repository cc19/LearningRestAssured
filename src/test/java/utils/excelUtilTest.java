package utils;

public class excelUtilTest {

    public static void main(String[] args) {
        String filePath = "./Data/RA_data.xlsx";
        String sheetName = "Sheet1";
        ExcelUtils eu = new ExcelUtils(filePath,sheetName);
        eu.getRowCount();
        eu.getCellData(1,0);
        eu.getCellData(1,1);
        eu.getCellData(1,2);
    }
}
