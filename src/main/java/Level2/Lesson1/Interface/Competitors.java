package Level2.Lesson1.Interface;

public interface Competitors extends Jumper, Runner {

    int getMaxLght();

    int getMaxHeight();

    @Override
    default boolean jump(int maxHeight, int distanceSize) {
        return maxHeight >= distanceSize;
    }

    @Override
    default boolean run(int maxLght, int distanceSize) {
        return maxLght >= distanceSize;
    }
}
