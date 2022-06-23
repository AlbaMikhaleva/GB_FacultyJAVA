package Level2.Lesson1.Interface;

import Level2.Lesson1.RunningTrack;

public interface Obstacles {

    int getDistnceSize();

    boolean passObstacle (Competitors competitor, Obstacles obstacles);

}