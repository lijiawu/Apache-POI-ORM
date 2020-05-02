package POI.UseCase;

import POI.ORM.persistence.annotation.Column;
import POI.ORM.persistence.annotation.Sheet;

@Sheet(name = "Players")
public class Player {
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private int meeples;
    @Column
    private String color;
    @Column
    private int score;

    public Player(final int id, final String name, final int meeples,
                  final String color, final int score) {
        this.id = id;
        this.name = name;
        this.meeples = meeples;
        this.color = color;
        this.score = score;
    }
}
