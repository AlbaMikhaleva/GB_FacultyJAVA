package Level2.Lesson1;

import Level2.Lesson1.Interface.Obstacles;

public class Wall implements Obstacles {

    final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public int getDistanceSize() {
        return height;
    }
}
