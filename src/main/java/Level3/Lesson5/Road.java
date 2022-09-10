package Level3.Lesson5;

public class Road extends Stage {
    private long finishTime;
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";

    }
    @Override
    public void go(Car c, int stagePos, int stageCount) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            if (stagePos == stageCount && HomeWorkL3L5.firstFinish) {
                HomeWorkL3L5.firstFinish = false;
                System.out.println(c.getName() + " WIN!!!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
