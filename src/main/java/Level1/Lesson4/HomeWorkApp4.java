package Level1.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp4 {

    public static final int SIZE = 3;
    public static final char DOT_HUMAN = 'X';
    public static final char DOT_ROBOT = 'O';
    public static final char DOT_EMPTY = '◦';
    public static final char HEADER_FIRST_SYMBOL = '◇';
    public static int lastTurnX;
    public static int lastTurnY;
    public static int turnsCount;
    public static int winAmount = 3;

    public static final String SPACE_MAP = " ";
    public static final char[][] MAP = new char[SIZE][SIZE];

    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();
        playGame();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();
        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP);

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + SPACE_MAP);
        }
        System.out.println();
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + SPACE_MAP);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP);
            }
            System.out.println();
        }
    }

    static void playGame() {
        while (true) {
            turnHuman();
            printMap();
            if (checkEndGame(DOT_HUMAN)) {
                break;
            }

            turnRobot();
            printMap();
            if (checkEndGame(DOT_ROBOT)) {
                break;
            }
        }
    }


    private static void turnRobot() {
        System.out.println("Ход Компьютера.");

        int rowNumber;
        int columnNumber;

        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        } while (!isCellFree(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_ROBOT;
        turnsCount++;
        lastTurnX = rowNumber;
        lastTurnY = columnNumber;

    }


    private static void turnHuman() {
        int rowNumber;
        int columnNumber;

        while (true) {
            System.out.print("Введите координату строки: ");
            rowNumber = in.nextInt() - 1;
            System.out.print("Введите координату строки: ");
            columnNumber = in.nextInt() - 1;

            if (isCellFree(rowNumber, columnNumber)) {
                break;
            } else {
                System.out.printf("Поле с координатами (%d,%d) занято. %n", rowNumber + 1, columnNumber + 1);
            }
        }
        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;
        lastTurnX = rowNumber;
        lastTurnY = columnNumber;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static boolean checkEndGame(char symbol) {

        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Вы выиграли!!!:)");
            } else {
                System.out.println("Вы проиграли!:(");
            }
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья.");
            return true;
        }
        return false;
    }

    public static boolean checkWin(char symbol) {
        /* || checkWinDiagonals(symbol);*/
        return checkWinRow(symbol) || checkWinColumn(symbol);
    }

    public static boolean checkWinRow(char symbol) {
        int countSymbol = 0;
        boolean result = false;
            for (int i = 0; i < SIZE; i++) {
                if (MAP[lastTurnX][i] == symbol) {
                    countSymbol++;
                } else {
                    countSymbol = 0;
                }

                if (countSymbol == winAmount) {
                    result = true;
                    break;
                }
            }
        return result;
    }
        public static boolean checkWinColumn ( char symbol){
            int countSymbol = 0;
            boolean result = false;
            for (int i = 0; i < SIZE; i++) {
                if (MAP[i][lastTurnY] == symbol) {
                    countSymbol++;
                } else {
                    countSymbol = 0;
                }

                if (countSymbol == winAmount) {
                    result = true;
                    break;
                }
            }
            return result;
        }
    /*public static boolean checkWinDiagonals(char symbol) {
    }*/

        public static boolean checkDraw () {
            return turnsCount == SIZE * SIZE;
        }
    }
