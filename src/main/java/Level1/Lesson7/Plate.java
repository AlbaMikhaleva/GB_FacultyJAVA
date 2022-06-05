package Level1.Lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    @Override
    public String toString() { //вывод на экран количество еды в тарелке
        return "В тарелке " + food + " еды.";
    }

    public void decreaseFood(int amount) { // уменьшение еды в тарелке
        food -= amount;
    }

    public void addFood(int dose) { // добавление еды в тарелку
        System.out.printf("Добавим в тарелку еды (%s ед.).%n", dose);
        food += dose;
    }
}
