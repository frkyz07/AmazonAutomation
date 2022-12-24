package TestPackage;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProviderExample {


    @Test(dataProvider = "DriverTest")
    public void testCaseData(String greeting, String message, String id){

        System.out.println(greeting);
        System.out.println(message);
        System.out.println(id);
    }

    @DataProvider(name="DriverTest")
    public Object[][] getData() throws IOException {

      //  Object[][] data = {{"hello","text","1"},{"bye","message","2"}, {"solo","call","3"}};
        FileInputStream fis = new FileInputStream("filepath");
        XSSFWorkbook excel = new XSSFWorkbook(fis);
        XSSFSheet excelSheet = excel.getSheetAt(0);
        int rows = excelSheet.getPhysicalNumberOfRows();
        XSSFRow theRow = excelSheet.getRow(0);
        int rowNumbers = theRow.getLastCellNum();
        Object data[][] = new Object[rows-1][rowNumbers];

        return data;
    }

}
