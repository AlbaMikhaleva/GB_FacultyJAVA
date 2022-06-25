package Level2.Lesson2;

public class HomeWorkL2L2 {

    public static void main(String[] args) throws MyArraySizeException {

        String[][] array = new String[][]{{"1", "1", "1", "1","1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "2"}};

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4)
                throw new MyArraySizeException("Размер массива неверный. В строке " + (i+1) + " - " + array[i].length + " столбцов.");
        }
        try {
            sumElementsOfArray(array);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }


    private static void sumElementsOfArray(String[][] array) throws MyArrayDataException {

        int columns = array[0].length;
        int rows = array.length;
        int sum = 0;
        int[][] arrayInt = new int[rows][columns];
        int i;
        int j;

        for (i = 0; i < rows; i++) {
            for (j = 0; j < columns; j++) {
                try {
                    arrayInt[i][j] = Integer.parseInt(array[i][j]);
                    sum += arrayInt[i][j];
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке не число. Адрес ячейки: " + i + " " + j);
                }
            }
        }
        System.out.println(sum);
    }
}
