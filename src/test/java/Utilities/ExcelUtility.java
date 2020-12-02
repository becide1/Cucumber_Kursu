package Utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {

    public static List<List<String>> getListData(String path, String sheetName, int columnCount)
    {
        List<List<String>> donecekList=new ArrayList<>();

        Workbook workbook = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < rowCount; i++)
        {
            List<String> rowList = new ArrayList<>();
            Row row = sheet.getRow(i);
            
        }

        return donecekList;
    }






    public static void main(String[] args) {

        List<List<String>> gelenList= getListData("src/main/resources/ApacheExcel1.xlsx","testCitizen",2);


    }
}