package Level3.Lesson4;

public class HomeWorkL3L4 {

        static String str = "A";

        public static void main(String[] args) {
            Object lock = new Object();

            class MyTask implements Runnable {
                private final String b;
                private final String nextB;

                public MyTask(String b, String nextB) {
                    this.b = b;
                    this.nextB = nextB;
                }

                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        synchronized (lock) {
                            try {
                                while (!str.equals(b))
                                    lock.wait();
                                System.out.print(b);
                                str = nextB;
                                Thread.sleep(1);
                                lock.notifyAll();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }

            new Thread(new MyTask("A", "B")).start();
            new Thread(new MyTask("B", "C")).start();
            new Thread(new MyTask("C", "A")).start();
        }
    }

