package Level2.Lesson1.Interface;

public interface Competitors {

     default boolean jump(int maxHeight, int distanceSize, String type) {
        if (maxHeight >= distanceSize) {
            System.out.printf("%s перепрыгнул стену высотой %s метров.", type, distanceSize);
            System.out.println();
            return false;
        } else {
            System.out.printf("%s НЕ перепрыгнул стену высотой %s метров и сходит с дистанции.", type, distanceSize);
            System.out.println();
            return true;
        }
    }


     default boolean run(int maxLght, int distanceSize, String type) {
        if (maxLght >= distanceSize) {
            System.out.printf("%s пробежал %s метров.", type, distanceSize);
            System.out.println();
            return false;
        } else {
            System.out.printf("%s НЕ пробежал %s метров и сходит с дистанции.", type, distanceSize);
            System.out.println();
            return true;
        }

    }

     int getMaxLght ();
     int getMaxHeight();

}
