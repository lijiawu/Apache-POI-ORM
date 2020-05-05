package POI;

import java.io.IOException;

public class ExcelOperationTest {
    public static void main(String[] args) throws IOException {
//        //Old Version from Apache POI
//        String excelFilePath = "./src/main/resources/Books.xlsx";
//        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
//        Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
//        Sheet firstSheet = workbook.getSheetAt(0);
//        Iterator<Row> iterator = firstSheet.iterator();
//        while (iterator.hasNext()) {
//            Row nextRow = iterator.next();
//            Iterator<Cell> cellIterator = nextRow.cellIterator();
//
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//                switch (cell.getCellType()) {
//                    case STRING:
//                        System.out.print(cell.getStringCellValue());
//                        break;
//                    case BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue());
//                        break;
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue());
//                        break;
//                }
//                System.out.print(" - ");
//            }
//            System.out.println();
//        }
//
//        workbook.close();
//        inputStream.close();
//
//        //Our new ORM Version
//        NewXlsx xlsx = Xlsx.load(excelFilePath);
//        NewSheet<Person> personSheet = xlsx.getSheet(Person.class);
//
//        // Getall
//        List<Person> people = personSheet.getAll();
//        for(Person person : people) {
//            System.out.println("name:" + person.name() + " age:" + person.age() + " gender:" + person.gender());
//        }
//
//        // Get By Range
//        // 1. Range as in row & col range
//        // (a) User already know the person param count
//        people = personSheet.get(new Range("B2", "E6"));
//
//        // (b) User don't know person param count
//        int startRow = 2, endRow = 6;
//        int startCol = 2, endCol = startCol + Person.class.getFields().length;
//        String start = Character.toString('A' + startCol - 1) + Integer.toString(startRow);
//        String end = Character.toString('A' + endCol - 1) + Integer.toString(endRow);
//        people = personSheet.get(new Range(start, end));
//
//        // (c) Range presented by numbers
//        people = personSheet.get(new Range(startRow, startCol, endRow, endCol));
//
//        // 2. Range as in row range
//        people = personSheet.get(new Range(2, 6)); // set start col elsewhere???
    }
}
