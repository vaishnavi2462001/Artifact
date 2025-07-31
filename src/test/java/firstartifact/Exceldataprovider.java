package firstartifact;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exceldataprovider {

    @DataProvider(name = "excelfiledata")
    public Object[][] provideexceldata() throws IOException {
        String excelpath = "src/test/resources/sample.xlsx";
        FileInputStream fis = new FileInputStream(excelpath);
        XSSFWorkbook w = new XSSFWorkbook(fis);
        XSSFSheet s = w.getSheetAt(0);

        int rc = s.getPhysicalNumberOfRows();
        int cc = s.getRow(0).getLastCellNum();

        Object[][] data = new Object[rc - 1][cc];

        for (int i = 1; i < rc; i++) {
            XSSFRow row = s.getRow(i);
            for (int j = 0; j < cc; j++) {
                data[i - 1][j] = row.getCell(j).toString();
            }
        }
        w.close();
        fis.close();

        return data;
    }

    @Test(dataProvider = "excelfiledata")
    public void testExcelData(String col1, String col2 /* add parameters as per column count */) {
        System.out.println("Column 1: " + col1 + ", Column 2: " + col2);
        // Your test logic here
    }
}
