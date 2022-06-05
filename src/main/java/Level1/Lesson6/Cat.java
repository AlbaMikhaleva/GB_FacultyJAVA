package Level1.Lesson6;

// Создаем класс Кошка, который наследует методы класса Животное
public class Cat extends Animal {

    private final String kind = "Кошка"; // вид животного. Все кошки - кошки :)

    private final String name; // имя Кошки, чтобы различать созданные объекты
    private final int lengthRunMax = 200; // максимальна дистанция бега
    private final int lengthSwimMax = 0; // максимальна дистанция плавания
    public static int countCat; // счетчик кошек

    public Cat(String name) {
        this.name = name;
        countCat++;
    }

    public int getCountCat() {
        return countCat;
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
    public void swim(int lengthSwim) { // при любой переданной переменной lengthSwim кошки не умеют плавать)
        System.out.println("Кошки не умеет плавать!");
    }
}
