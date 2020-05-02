package POI.UseCase;

import POI.ORM.persistence.annotation.Column;
import POI.ORM.persistence.annotation.Sheet;

@Sheet(name = "Board")
public class Tile {
    @Column
    private int id;
    @Column
    private String type;
    @Column
    private int row;
    @Column
    private int col;
    @Column
    private int left;
    @Column
    private int right;
    @Column
    private int top;
    @Column
    private int bottom;
    @Column
    private int center;

    public Tile(int id, String type, int row, int col, int left,
                int right, int top, int bottom, int center) {
        this.id = id;
        this.type = type;
        this.row = row;
        this.col = col;
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        this.center = center;
    }
}
