package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _02_GetMultipleDataFromExcel {

    public static void main(String[] args) {

        String path = "src/test/java/excelFiles/releaseNotes.xlsx";

        FileInputStream inStream = null;
        try {
            inStream = new FileInputStream( path );
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

        System.out.println(allData);

    }

}
