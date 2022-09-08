package Level3.Lesson6;

import java.lang.reflect.Method;

public class MainClass {

    public static void main(String[] args) {
        //Object o = new Object();

        System.out.println("1");
        start(TestClass1.class.getDeclaredMethods());
        System.out.println();

        System.out.println("2");
        start(TestClass2.class.getDeclaredMethods());
        System.out.println();

        System.out.println("3");
        start(TestClass3.class.getDeclaredMethods());
        System.out.println();

        System.out.println("4");
        start(TestClass4.class.getDeclaredMethods());

    }

    public static void bubbleSort(Method[] arr){
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if(arr[j].getAnnotation(Test.class).prior() > arr[j+1].getAnnotation(Test.class).prior()) {
                    Method tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void start(Method[] methods) {
        try {
            Method mem = methods[0];
            boolean was;
            int testNum;

            try {
                was = false;
                for (Method o : methods) {
                    if (o.getAnnotation(BeforeSuite.class) != null) {
                        mem = o;
                        if (!was)
                            was = true;
                        else {
                            throw new RuntimeException();
                        }
                    }
                }
                if (!was)
                    throw new RuntimeException();
                else {
                    mem.invoke(null);
                }
            }
            catch (RuntimeException e1) {
                e1.printStackTrace();
            }

            testNum = 0;
            for (Method o : methods) {
                if(o.getAnnotation(Test.class) != null)
                    testNum++;
            }
            Method[] priorMethods = new Method[testNum];
            int i = 0;
            for (Method o : methods) {
                if(o.getAnnotation(Test.class) != null) {
                    priorMethods[i] = o;
                    i++;
                }
            }
            bubbleSort(priorMethods);
            for (Method o : priorMethods) {
                o.invoke(null);
            }

            try {
                was = false;
                for (Method o : methods) {
                    if (o.getAnnotation(AfterSuite.class) != null) {
                        mem = o;
                        if (!was)
                            was = true;
                        else {
                            throw new RuntimeException();
                        }
                    }
                }
                if (!was)
                    throw new RuntimeException();
                else {
                    mem.invoke(null);
                }
            }
            catch (RuntimeException e1) {
                e1.printStackTrace();
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

}



