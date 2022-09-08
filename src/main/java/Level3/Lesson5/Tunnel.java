package Level3.Lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static final Semaphore semaphore = new Semaphore(HomeWorkL3L5.CARS_COUNT / 2);

    public Tunnel(int length) {
        this.length = length;
        this.description = "Тоннель " + length + " метров";

    }

    @Override
    public void go(Car c, int stagePos, int stageCount) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();

                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();

            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
                if (stagePos == stageCount && HomeWorkL3L5.firstFinish) {
                    HomeWorkL3L5.firstFinish = false;
                    System.out.println(c.getName() + " WIN!!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

