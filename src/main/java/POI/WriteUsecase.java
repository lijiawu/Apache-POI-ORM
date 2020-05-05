package POI;

import POI.datamodel.Person;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public class WriteUsecase {
    public static void main(String[] args) throws IOException {
        //Old version, need to create every row and every cell in that row one by one
        Workbook wb = WorkbookFactory.create(false);
        Sheet sheet = wb.createSheet("Contact");
        Row row0 = sheet.createRow(0);
        Cell cell0 = row0.createCell(0);
        cell0.setCellValue("John");
        Cell cell1 = row0.createCell(1);
        cell1.setCellValue(22);
        Cell cell2 = row0.createCell(2);
        cell2.setCellValue(false);
        Row row1 = sheet.createRow(0);
        Cell cell3 = row1.createCell(0);
        cell3.setCellValue("Lina");
        Cell cell4 = row1.createCell(1);
        cell4.setCellValue(26);
        Cell cell5 = row1.createCell(2);
        cell5.setCellValue(true);
        try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
            wb.write(fileOut);
        }

        //Our ORM version
        POI.ORM.persistence.Sheet contactSheet = new POI.ORM.persistence.Sheet();
        Person John = new Person("John", 22, false);
        Person Lina = new Person("Lina", 26, true);
        contactSheet.addModel(John);
        contactSheet.addModel(Lina);

        List<Person> people = new LinkedList<>();
        people.add(John);
        people.add(Lina);

        // addAll
//        contactSheet.addAll(people);
//
//        contactSheet.addAll(people, 2);
//
//        contactSheet.remove(4);   // scope, behavior
//
//        contactSheet.removeAll(new Range(1, 3));
    }
}
