package Level2.Lesson4;

public class HomeWorkL2L4 {

    public static void main(String[] args) {

        final int SIZE = 10_000_000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        firstMethod(arr);
        System.out.println("Время исполнения первого метода: " + (System.currentTimeMillis() - a));


        long b = System.currentTimeMillis();
        secondMethod(arr, HALF);
        System.out.println("Время исполнения второго метода: " + (System.currentTimeMillis() - b));

    }

    private static void firstMethod(float[] arr) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void secondMethod(float[] arr, int half) {

        float[] leftArr = new float[half];
        float[] rightArr = new float[half];

        System.arraycopy(arr, 0, leftArr, 0, half);
        System.arraycopy(arr, half, rightArr, 0, half);

        Thread thread = new Thread(() -> {
            for (int i = 0; i < half; i++) {
                leftArr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < half; i++) {
                rightArr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread2.start();

        float[] mergedArray = new float[arr.length];
        System.arraycopy(leftArr, 0, mergedArray, 0, half);
        System.arraycopy(rightArr, 0, mergedArray, half, half);

    }
}
