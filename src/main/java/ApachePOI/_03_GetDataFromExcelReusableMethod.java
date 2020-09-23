package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _03_GetDataFromExcelReusableMethod {

    public static List<String> reusableMethodForGetData(String pathOfTheExcel , String sheetName){

        FileInputStream inStream = null;

        try {
            inStream = new FileInputStream( pathOfTheExcel );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create( inStream );
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheet( "Sheet1" );

        System.out.println(sheet.getPhysicalNumberOfRows());

        int maxRow = sheet.getPhysicalNumberOfRows();

        Row row;

        Cell cell;

        List<String> allData = new ArrayList<>(  );

        for(int i = 0 ; i<maxRow ; i++ ) {

            row = sheet.getRow( i );

            int cellCount= row.getLastCellNum();

            for(int j = 0 ; j<cellCount ; j++){

                cell = row.getCell( j );

                allData.add( cell.toString() );

            }

        }

        return allData;

    }
}