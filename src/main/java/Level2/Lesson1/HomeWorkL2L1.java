package Level2.Lesson1;

import Level2.Lesson1.Interface.Competitors;
import Level2.Lesson1.Interface.Obstacles;

public class HomeWorkL2L1 {

    public static void main(String[] args) {

        Competitors[] competitors = createArrayCompetitors();
        Obstacles[] obstacles = createArrayObstacles();

        passAllObstacles(competitors, obstacles);

    }

    // метод прохождения препятствий
    private static void passAllObstacles(Competitors[] competitors, Obstacles[] obstacles) {
        for (Competitors c: competitors
             ) {
            for (Obstacles obstacle : obstacles) {
                if (obstacle.passObstacle(c, obstacle)) {
                    System.out.printf("Участник %s приодалел препятствие %s %s метров и идет дальше", c, obstacle, obstacle.getDistnceSize());
                    System.out.println();
                } else {
                    System.out.printf("Участник %s НЕ приодалел препятствие %s %s метров и сходит с дистанции", c, obstacle, obstacle.getDistnceSize());
                    System.out.println();
                    break;
                }
            }

        }
    }

    // создание массива Участники
    private static Competitors[] createArrayCompetitors() {

        Human human = new Human(3, 3000);
        Cat cat = new Cat(5, 3000);
        Robot robot = new Robot(1, 5000);

        return new Competitors[]{human, cat, robot};

    }

    //создание массива Препятствия
    private static Obstacles[] createArrayObstacles() {

        return new Obstacles[]{new Wall(2), new RunningTrack(1000), new Wall(5), new RunningTrack(5000), new Wall(8), new RunningTrack(7000)};
    }

}


