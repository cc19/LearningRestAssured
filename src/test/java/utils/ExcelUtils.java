package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

//Working with .xlsx file
public class ExcelUtils {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelUtils(String filePath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(sheetName);
    }

    public void getCellData(int rowNum, int colNum) {
        //This can get String values
        //  String cellVal = sheet.getRow(1).getCell(0).getStringCellValue();
        //System.out.println("Cell value is "+cellVal);

        //To get values in same format as they are in the excel, use data formatter
        DataFormatter df = new DataFormatter();
        Object value = df.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        System.out.println(value);
    }

    public void getRowCount() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("No. of rows "+rowCount);
    }
}
