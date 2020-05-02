package POI.ORM.Mock;

import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FakeRow implements Row {

    private List<Cell> cells;

    public FakeRow() {
        cells = new ArrayList<>();
        cells.add(new FakeCell(CellType.STRING));
        cells.add(new FakeCell(CellType.NUMERIC));
        cells.add(new FakeCell(CellType.BOOLEAN));
    }

    @Override
    public Cell createCell(int column) {
        return null;
    }

    @Override
    public Cell createCell(int column, CellType type) {
        return new FakeCell();
    }

    @Override
    public void removeCell(Cell cell) {

    }

    @Override
    public void setRowNum(int rowNum) {

    }

    @Override
    public int getRowNum() {
        return 0;
    }

    @Override
    public Cell getCell(int cellnum) {
        return cells.get(cellnum);
    }

    @Override
    public Cell getCell(int cellnum, MissingCellPolicy policy) {
        return null;
    }

    @Override
    public short getFirstCellNum() {
        return 0;
    }

    @Override
    public short getLastCellNum() {
        return 0;
    }

    @Override
    public int getPhysicalNumberOfCells() {
        return 0;
    }

    @Override
    public void setHeight(short height) {

    }

    @Override
    public void setZeroHeight(boolean zHeight) {

    }

    @Override
    public boolean getZeroHeight() {
        return false;
    }

    @Override
    public void setHeightInPoints(float height) {

    }

    @Override
    public short getHeight() {
        return 0;
    }

    @Override
    public float getHeightInPoints() {
        return 0;
    }

    @Override
    public boolean isFormatted() {
        return false;
    }

    @Override
    public CellStyle getRowStyle() {
        return null;
    }

    @Override
    public void setRowStyle(CellStyle style) {

    }

    @Override
    public Iterator<Cell> cellIterator() {
        return null;
    }

    @Override
    public Sheet getSheet() {
        return null;
    }

    @Override
    public int getOutlineLevel() {
        return 0;
    }

    @Override
    public void shiftCellsRight(int firstShiftColumnIndex, int lastShiftColumnIndex, int step) {

    }

    @Override
    public void shiftCellsLeft(int firstShiftColumnIndex, int lastShiftColumnIndex, int step) {

    }

    @Override
    public Iterator<Cell> iterator() {
        return null;
    }
}
