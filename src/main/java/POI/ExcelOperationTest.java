package POI;

import POI.datamodel.Person;
import POI.ORM.NewSheet;
import POI.ORM.NewXlsx;
import POI.ORM.Xlsx;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ExcelOperationTest {
    public static void main(String[] args) throws IOException {
        //Old Version from Apache POI
        String excelFilePath = "./src/main/resources/Books.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.print(" - ");
            }
            System.out.println();
        }

        workbook.close();
        inputStream.close();

        //Our new ORM Version
        NewXlsx xlsx = Xlsx.load(excelFilePath);
        NewSheet<Person> personSheet = xlsx.getSheet(Person.class);
        List<Person> people = personSheet.getAll();
        for(Person person : people) {
            System.out.println("name:" + person.name() + " age:" + person.age() + " gender:" + person.gender());
        }
    }
}
