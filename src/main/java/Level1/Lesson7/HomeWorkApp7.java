package Level1.Lesson7;

public class HomeWorkApp7 {
    public static void main(String[] args) {

        Cat[] cat = {new Cat("Кузя", 20, false),
                new Cat("Васька", 15, false),
                new Cat("Сёмка", 30, false)};

        Plate plate = new Plate(50);
        System.out.println(plate);

        for (Cat c : cat
        ) {
            c.eat(plate);
            c.checkSatiety();
        }
        System.out.println();

        System.out.println(plate);
        plate.addFood(60);
        System.out.println(plate);

    }
}
