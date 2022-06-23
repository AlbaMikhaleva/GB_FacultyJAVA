package Level2.Lesson1;

import Level2.Lesson1.Interface.Competitors;

public class Human implements Competitors {

     int maxHeight;
     int maxLght;

    public Human(int maxHeight, int maxLght) {
        this.maxHeight = maxHeight;
        this.maxLght = maxLght;
    }

    @Override
    public int getMaxLght() {
        return maxLght;
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public String toString() {
        return "Человек";
    }

   /* @Override
    public boolean jump(int maxHeight, int distanceSize, String type) {
        return Competitors.super.jump(maxHeight, distanceSize, type);
    }

    @Override
    public boolean run(int maxLght, int distanceSize, String type) {
        return Competitors.super.run(maxLght, distanceSize, type);
    }*/
}
