package Level2.Lesson1;

import Level2.Lesson1.Interface.Obstacles;

public class RunningTrack implements Obstacles {

    final int lght;

    public RunningTrack(int lght) {
        this.lght = lght;
    }

    @Override
    public int getDistanceSize() {
        return lght;
    }

}
