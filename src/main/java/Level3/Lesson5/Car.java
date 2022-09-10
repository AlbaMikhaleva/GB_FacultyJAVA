package Level3.Lesson5;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private final Race race;
    private final int speed;
    private final String name;
    private final CountDownLatch cdlReady;
    private final CountDownLatch cdlFinish;
    private static final CountDownLatch countDownLatch = new CountDownLatch(HomeWorkL3L5.CARS_COUNT);

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch cdlReady, CountDownLatch cdlFinish) {
        this.race = race;
        this.speed = speed;
        this.cdlReady = cdlReady;
        this.cdlFinish = cdlFinish;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;

    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            countDownLatch.countDown();
            cdlReady.countDown();
        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        //long startTime = System.currentTimeMillis();
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this, i + 1, race.getStages().size());
        }
        cdlFinish.countDown();
    }
}

