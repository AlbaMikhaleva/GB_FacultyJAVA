package Level1.Lesson6;

public class HomeWorkApp6 {
    public static void main(String[] args) {

        Cat cat = new Cat("Мурка");
        cat.run(150);
        cat.swim(200);

        Dog dog1 = new Dog("Тузик");
        dog1.run(400);
        dog1.swim(8);

        Dog dog2 = new Dog("Шарик");
        dog2.run(600);
        dog2.swim(20);

        System.out.printf("Всего животных - %d шт. Кошек - %d , собак - %d .", (cat.getCountCat() + dog2.getCountDog()), cat.getCountCat(), dog2.getCountDog());
    }
}
