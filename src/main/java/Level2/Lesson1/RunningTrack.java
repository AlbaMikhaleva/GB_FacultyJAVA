package Level2.Lesson1;

import Level2.Lesson1.Interface.Competitors;
import Level2.Lesson1.Interface.Obstacles;

public class RunningTrack implements Obstacles {

    private final int LGHT;

    public RunningTrack(int LGHT) {
        this.LGHT = LGHT;
    }

    public int getDistnceSize() {
        return LGHT;
    }

    @Override
    public String toString() {
        return "Беговая Дорожка";
    }

    @Override
    public boolean passObstacle(Competitors competitor, Obstacles obstacles) {
        return competitor.run(competitor.getMaxLght(), obstacles.getDistnceSize());
    }

}
