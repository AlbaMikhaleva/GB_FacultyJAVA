package Level1.Lesson7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }


    public void eat(Plate plate) {  //метод приема еды
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            System.out.println(name + " кушает....");
            satiety = true;
        } else {
            System.out.println("В тарелке недостаточно еды!");
            satiety = false;
        }
    }

    public void checkSatiety() { // проверка сытости котов
        if (satiety == true) {
            System.out.println(name + " наелся.");
        } else {
            System.out.println(name + " остался голодным.");
        }
    }

}
