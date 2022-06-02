package Level1.Lesson6;

// Создаем класс Собака, который наследует методы класса Животное
public class Dog extends Animal {

    private final String kind = "Собака"; // вид животного. :)
    private final String name; // имя Собаки, чтобы различать созданные объекты
    private final int lengthRunMax = 500; // максимальна дистанция бега
    private final int lengthSwimMax = 10; // максимальна дистанция плавания
    public static int countDog; // счетчик собак

    public Dog(String name) {
        countDog++;
        this.name = name;

    }

    public int getCountDog() {
        return countDog;
    }

    public int getLengthRunMax() {
        return lengthRunMax;
    }

    public int getLengthSwimMax() {
        return lengthSwimMax;
    }

    @Override
    public void run(int lengthRun) {
        if (lengthRun > getLengthRunMax()) {
            System.out.printf("%s %s не может столько пробежать.%n", kind, name);
        } else {
            System.out.printf("%s %s пробежала %d метров.%n", kind, name, lengthRun);
        }
    }

    @Override
    public void swim(int lengthSwim) {
        if (lengthSwim > getLengthSwimMax()) {
            System.out.printf("%s %s не может столько проплыть.%n", kind, name);
        } else {
            System.out.printf("%s %s проплыла %d метров.%n", kind, name, lengthSwim);
        }
    }
}
