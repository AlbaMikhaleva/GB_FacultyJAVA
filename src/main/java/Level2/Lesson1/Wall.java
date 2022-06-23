package Level2.Lesson1;

import Level2.Lesson1.Interface.Competitors;
import Level2.Lesson1.Interface.Obstacles;

public class Wall implements Obstacles {

    private final int HEIGHT;

    public Wall(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public int getDistnceSize() {
        return HEIGHT;
    }

    @Override
    public String toString() {
        return "Стена";
    }

    @Override
    public boolean passObstacle(Competitors competitor, Obstacles obstacles) {
        return competitor.jump(competitor.getMaxHeight(), obstacles.getDistnceSize());
    }

}
