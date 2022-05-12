package accessFile;

import academy.Base;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

public class dataDrivenFile extends Base {
    public static Properties prop;

    public static void main(String[] args) throws IOException {

        prop = new Properties();
        String excelFile = prop.getProperty("excelFile");
        FileInputStream fileInputStream = new FileInputStream("/Users/carloscavalcante/Documents/Java/Tutorial-TD/Excel1.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case NUMERIC:
                        System.out.println(cell.getNumericCellValue() + "(Integer)\t");
                        break;
                    case STRING:
                        System.out.println(cell.getStringCellValue() + "(String)\t");
                        break;
                }
                System.out.println("");
            }
        }
    }
}
