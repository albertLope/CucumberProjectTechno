package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _01_GetDataFromExcel {

    public static void main(String[] args) throws IOException {

        String path = "src/test/java/excelFiles/releaseNotes.xlsx";

        FileInputStream inStream =  new FileInputStream( path );

        Workbook  workbook = WorkbookFactory.create( inStream );

        Sheet sheet = workbook.getSheet( "Sheet1" );

        Row row = sheet.getRow( 0 );

        Cell cell = row.getCell( 0 );

        System.out.println(cell);

    }
}
