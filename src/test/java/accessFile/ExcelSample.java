package accessFile;

import java.io.IOException;
import java.util.ArrayList;

public class ExcelSample {

    public static void main(String[] args) throws IOException {

        dataDrivenTest dataDrivenTest = new dataDrivenTest();
        ArrayList data = dataDrivenTest.dataDriven("fed");

        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));
    }
}
