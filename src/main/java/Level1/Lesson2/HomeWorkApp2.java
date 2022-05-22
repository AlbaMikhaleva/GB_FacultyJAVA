package Level1.Lesson2;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        System.out.println(checkSum(20, 11));
        checkNumb(-10);
        System.out.println(checkNumb2(-10));
        printString("Привет", 5);
        System.out.println(checkLeapYear(2020));

    }

    /* 1. Написать метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно),
    если да – вернуть true, в противном случае – false.*/
    private static boolean checkSum(int a, int b) {
        int result = a + b;
        if (result >= 10 && result <= 20) {
            return true;
        } else {
            return false;
        }
    }

    /* 2. Написать метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом.*/
    private static void checkNumb(int a) {
        if (a >= 0) {
            System.out.println("Число положительное.");
        } else {
            System.out.println("Число отрицательное.");
        }
    }

    /* 3. Написать метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.*/
    private static boolean checkNumb2(int a) {
        if (a >= 0) {
            return false;
        } else {
            return true;
        }
    }

    /* 4. Написать метод, которому в качестве аргументов передается строка и число,
    метод должен отпечатать в консоль указанную строку, указанное количество раз;*/

    private static void printString(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    /* 5. * Написать метод, который определяет, является ли год високосным,
    и возвращает boolean (високосный - true, не високосный - false).
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.*/
    private static boolean checkLeapYear(int year) {
        if (((year % 4 == 0) || (year % 400 == 0)) && (year % 100 != 0)) {
            return true;
        } else {
            return false;
        }

    }
}

