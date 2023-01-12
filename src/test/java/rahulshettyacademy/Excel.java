package rahulshettyacademy;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Excel {

    DataFormatter formatter = new DataFormatter();

   // @DataProvider(name = "driveTestExcel")
    @Test
    public void getExcelData() throws IOException {


        FileInputStream fis = new FileInputStream("C:\\Users\\ASUS\\Desktop\\dataDemo.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int rowNumber = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colNumber = row.getLastCellNum();

        Object[][] data = new Object[rowNumber - 1][colNumber];

        for (int i = 0; i < data.length; i++) {
            row = sheet.getRow(i + 1);

            for (int j = 0; j < data[0].length; j++) {

                XSSFCell cell=row.getCell(j);
                data[i][j] = formatter.formatCellValue(cell);
                System.out.println(row.getCell(j));
            }
            System.out.println();
        }

    }

}
