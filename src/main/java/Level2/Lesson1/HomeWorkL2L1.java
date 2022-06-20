package Level2.Lesson1;

import Level2.Lesson1.Interface.Competitors;
import Level2.Lesson1.Interface.Obstacles;

public class HomeWorkL2L1 {

    public static void main(String[] args) {

        Competitors[] competitors = createArrayCompetitors();
        Obstacles[][] obstacles = createArrayObstacles();

        passObstacles(competitors, obstacles);


    }

// создание массива Участники
    private static Competitors[] createArrayCompetitors() {

        Human human = new Human(5, 3000);
        Cat cat = new Cat(7, 5000);
        Robot robot = new Robot(1, 10000);

        return new Competitors[]{human, cat, robot};

    }

//создание массива Препятствия
    private static Obstacles[][] createArrayObstacles() {

        Wall[] walls = new Wall[]{new Wall(2), new Wall(6), new Wall(10)};
        RunningTrack[] tracks = new RunningTrack[]{new RunningTrack(2000), new RunningTrack(5000), new RunningTrack(9000)};

        return new Obstacles[][]{walls, tracks};

    }

// метод для прохождения препятствий
    public static void passObstacles(Competitors[] competitors, Obstacles[][] obstacles) {
        for (Competitors competitor : competitors) {

            for (int i = 0; i < obstacles[0].length; i++) { //цикл прохождения препятствий (проходят по очереди Стена-Дорожка)
                if (competitor.jump(competitor.getMaxHeight(), obstacles[0][i].getDistanceSize(), competitor.toString())) {
                    break;
                } else {
                    if (competitor.run(competitor.getMaxLght(), obstacles[1][i].getDistanceSize(), competitor.toString())) {
                        break;
                    }
                }
            }
        }

    }
}


