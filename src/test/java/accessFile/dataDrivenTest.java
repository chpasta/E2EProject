package accessFile;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class dataDrivenTest {

    public ArrayList<String> dataDriven(String testCaseName) throws IOException {

        ArrayList<String> a = new ArrayList<>();

        Properties properties = new Properties();

        FileInputStream fis = new FileInputStream("src/main/java/academy/data.properties");
        properties.load(fis);
        String file = properties.getProperty("excelFile");

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        int sheets = workbook.getNumberOfSheets();

        for (int i = 1; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testData")) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rows = sheet.iterator();
//                Row firstRow = rows.next();
//
//                Iterator<Cell> cells = firstRow.cellIterator();
//
//                int k = 0;
                int column = 1;

//                while (cells.hasNext()) {
//                    Cell value = cells.next();
//                    if (value.getStringCellValue().equalsIgnoreCase("")) {
//                        column = k;
//                    }
//                    k++;
//                }
//                System.out.println("column: " + column);
                while (rows.hasNext()) {
                    Row row = rows.next();
                    if (row.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
                        Iterator<Cell> cv = row.cellIterator();
                        while (cv.hasNext()) {

                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING) {
                                a.add(c.getStringCellValue());
                            } else {
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return a;
    }
}

