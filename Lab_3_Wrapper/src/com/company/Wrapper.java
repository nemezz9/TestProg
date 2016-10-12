package com.company;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Тема: Класи-обгортки (Wrappers)
 * частина 1
 * Демонстрація роботи усіх методів класів: Byte, Double, Float, Integer, Long, Short,
 * частина 2
 * Демонстрація роботи усіх методів числових класів: BigInteger, BigDecimal
 * Для демонстрації обирати випадкові значення, які може зберігати відповідний тип але такі що
 * не вміщюються у вужчий тип, наприклад для
 * byte з диапазону [-128; 127], для short узяти значення більше ніж можна занести у byte,
 * у int більше ніж у short й т.д.
 * частина 3
 * Створити звичайні масиви фундаментального типу (int) та типу масив обгорток (Integer)
 * кількість елементів вводиться з клавіатури. Ініціалізувати їх значеннями
 * a[0] = 1, a[1] = 2, ... a[n-1] = n;
 * Виміряти час, необхідний для отримання суми. Вивести відформатований час: (хв. сек. мілі та мікро секунди) й обчислену суму.
 */
class Wrapper {
    private Random rand = new Random();
    private int lenOfArray = 1;

    Wrapper(int len) {
        lenOfArray = len;


    }
    public void Print()
    {
        byteMethod();
        shortMethod();
        intMethod();
        longMethod();
        floatMethod();
        doubleMethod();
        bigIntegerMethod();
        bigDecimalMethod();
    }

    private byte[] byteArrayRandom() {
        byte[] res = new byte[lenOfArray];
        rand.nextBytes(res);
        return res;
    }

    private double[] doubleArrayRandom() {
        double[] res = new double[lenOfArray];
        for (int i = 0; i < lenOfArray; i++) {
            res[i] = rand.nextDouble();
        }
        return res;
    }

    private float[] floatArrayRandom() {
        float[] res = new float[lenOfArray];
        for (int i = 0; i < lenOfArray; i++) {
            res[i] = rand.nextFloat();
        }
        return res;
    }

    private int[] intArrayRandom() {
        int[] res = new int[lenOfArray];
        for (int i = 0; i < lenOfArray; i++) {
            res[i] = rand.nextInt();
        }
        return res;
    }

    private short[] shortArrayRandom() {
        short[] res = new short[lenOfArray];
        for (int i = 0; i < lenOfArray; i++) {
            res[i] = (short) rand.nextInt();
        }
        return res;

    }

    private long[] longArrayRandom() {
        long[] res = new long[lenOfArray];
        for (int i = 0; i < lenOfArray; i++) {
            res[i] = rand.nextLong();
        }
        return res;
    }

    private String formatTime(long time) {
        //long nanoSeconds = time;
        long microSeconds = time;
        long milliSeconds = microSeconds / 1000;
        long seconds = milliSeconds / 1000;
        long minutes = seconds / 60;


        microSeconds -= (milliSeconds * 1000);
        milliSeconds -= (seconds * 1000);
        seconds -= minutes * 60;

        return String.format("Time spent: %d min %d sec %d millisec %d microsec ", minutes, seconds, milliSeconds, microSeconds);
    }

    private void byteMethod() {

        byte[] array = byteArrayRandom();
        Byte[] arrayWrap = new Byte[lenOfArray];

        long startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++)
            arrayWrap[i] = array[i];
        long Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("-------------------------------------\nTime of Byte Boxing " + formatTime(Time));

        startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++)
            array[i] = arrayWrap[i];
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of Byte Unboxing " + formatTime(Time));

        byte[] arr = new byte[lenOfArray];
        Byte[] arrwrap = new Byte[lenOfArray];

        for (int i = 0; i < lenOfArray; i++) {
            arr[i] = (byte) (i + 1);
            arrwrap[i] = (byte) (i + 1);
        }
        byte res = 0;
        startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++) {
            res += arr[i];
        }
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of sum of byte array " + formatTime(Time) + "\nSum = " + res);

        startTime = System.nanoTime();
        Byte res1 = 0;
        for (int i = 0; i < lenOfArray; i++) {
            res1 = (byte)(res1+ arrwrap[i]);
        }
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of sum of Byte array " + formatTime(Time) + "\nSum = " + res1);


        System.out.println(printMethods(array[0]));

    }

    private void doubleMethod() {
        double[] array = doubleArrayRandom();
        Double[] arrayWrap = new Double[lenOfArray];
        long startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++)
            arrayWrap[i] = array[i];
        long Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("-------------------------------------\nTime of Double Boxing " + formatTime(Time));

        startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++)
            array[i] = arrayWrap[i];
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of Double Unboxing " + formatTime(Time));


        double[] arr = new double[lenOfArray];
        Double[] arrwrap = new Double[lenOfArray];
        for (int i = 0; i < lenOfArray; i++) {
            arr[i] = (double) (i + 1);
            arrwrap[i] = (double) (i + 1);
        }
        double res = 0.0;
        startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++) {
            res += arr[i];
        }
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of sum of double array " + formatTime(Time) + "\nSum = " + res);

        startTime = System.nanoTime();
        Double res1 = 0.0;
        for (int i = 0; i < lenOfArray; i++) {
            res1 += arrwrap[i];
        }
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of sum of Double array " + formatTime(Time) + "\nSum = " + res1);




        System.out.println(printMethods(array[0]));
    }

    private void floatMethod() {
        float[] array = floatArrayRandom();
        Float[] arrayWrap = new Float[lenOfArray];
        long startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++)
            arrayWrap[i] = array[i];
        long Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("-------------------------------------\nTime of Float Boxing " + formatTime(Time));
        startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++)
            array[i] = arrayWrap[i];
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of Float Unboxing " + formatTime(Time));




        float[] arr = new float[lenOfArray];
        Float[] arrwrap = new Float[lenOfArray];
        for (int i = 0; i < lenOfArray; i++) {
            arr[i] = (float) (i + 1);
            arrwrap[i] = (float) (i + 1);
        }
        float res = 0;
        startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++) {
            res += arr[i];
        }
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of sum of float array " + formatTime(Time) + "\nSum = " + res);

        startTime = System.nanoTime();
        Float res1 = (float)0.0;
        for (int i = 0; i < lenOfArray; i++) {
            res1 += arrwrap[i];
        }
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of sum of Float array " + formatTime(Time) + "\nSum = " + res1);





        System.out.println(printMethods(array[0]));
    }

    private void intMethod() {
        int[] array = intArrayRandom();
        Integer[] arrayWrap = new Integer[lenOfArray];

        long startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++)
            arrayWrap[i] = array[i];
        long Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("-------------------------------------\nTime of Integer Boxing " + formatTime(Time));
        startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++)
            array[i] = arrayWrap[i];
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of Integer Unboxing " + formatTime(Time));

        int[] arr = new int[lenOfArray];
        Integer[] arrwrap = new Integer[lenOfArray];
        for (int i = 0; i < lenOfArray; i++) {
            arr[i] =  i + 1;
            arrwrap[i] =  i + 1;
        }
        int res = 0;
        startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++) {
            res += arr[i];
        }
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of sum of int array " + formatTime(Time) + "\nSum = " + res);

        startTime = System.nanoTime();
        Integer res1 = 0;
        for (int i = 0; i < lenOfArray; i++) {
            res1 += arrwrap[i];
        }
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of sum of Integer array " + formatTime(Time) + "\nSum = " + res1);


        System.out.println(printMethods(array[0]));
    }

    private void shortMethod() {
        short[] array = shortArrayRandom();
        Short[] arrayWrap = new Short[lenOfArray];
        long startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++)
            arrayWrap[i] = array[i];
        long Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("-------------------------------------\nTime of Short Boxing " + formatTime(Time));
        startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++)
            array[i] = arrayWrap[i];
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of Short Unboxing " + formatTime(Time));

        short[] arr = new short[lenOfArray];
        Short[] arrwrap = new Short[lenOfArray];
        for (int i = 0; i < lenOfArray; i++) {
            arr[i] =  (short)(i + 1);
            arrwrap[i] =  (short)(i + 1);
        }
        short res = 0;
        startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++) {
            res += arr[i];
        }
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of sum of short array " + formatTime(Time) + "\nSum = " + res);

        startTime = System.nanoTime();
        Short res1 = 0;
        for (int i = 0; i < lenOfArray; i++) {
            res1 = (short)(res1+arrwrap[i]);
        }
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of sum of Short array " + formatTime(Time) + "\nSum = " + res1);



        System.out.println(printMethods(array[0]));
    }

    private void longMethod() {
        long[] array = longArrayRandom();
        Long[] arrayWrap = new Long[lenOfArray];
        long startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++)
            arrayWrap[i] = array[i];
        long Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("-------------------------------------\nTime of Long Boxing " + formatTime(Time));

        startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++)
            array[i] = arrayWrap[i];
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of Long Unboxing " + formatTime(Time));

        long[] arr = new long[lenOfArray];
        Long[] arrwrap = new Long[lenOfArray];
        for (int i = 0; i < lenOfArray; i++) {
            arr[i] =  i + 1;
            arrwrap[i] =  (long)(i + 1);
        }
        long res = 0;
        startTime = System.nanoTime();
        for (int i = 0; i < lenOfArray; i++) {
            res += arr[i];
        }
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of sum of long array " + formatTime(Time) + "\nSum = " + res);

        startTime = System.nanoTime();
        Long res1 = (long)0;
        for (int i = 0; i < lenOfArray; i++) {
            res1 += arrwrap[i];
        }
        Time = TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime);
        System.out.println("\nTime of sum of Long array " + formatTime(Time) + "\nSum = " + res1);

        System.out.println(printMethods(array[0]));
    }

    private void bigIntegerMethod(){

        BigInteger bi = new BigInteger("-5646564989426713278516576516576261721237651564213732");
        BigInteger bi2 = new BigInteger("-2313223071015056146450107410651040144504510404101404105");
        System.out.println(printMethods(bi));
        String sb = "FirstValue = " + bi +
                "\nSecondValue = " + bi2 +
                "\nabs() = " + bi.abs() +
                "\nadd(value) = " + bi.add(bi2) +
                "\ndivide(value) = " + bi.divide(bi2) +
                "\nsubtract(value) = " + bi.subtract(bi2) +
                "\nmultiply(value) = " + bi.multiply(bi2) +
                "\nmin(value) = " + bi.min(bi2) +
                "\nmax(value) = " + bi.max(bi2) +
                "\nremainder(value) = " + bi.remainder(bi2);

        System.out.println(sb);

    }
    private void bigDecimalMethod(){
        BigDecimal bi = new BigDecimal("1.5456412424234879").setScale(30,BigDecimal.ROUND_HALF_UP);
        BigDecimal bi2 = new BigDecimal("0.5456412341234567").setScale(30, BigDecimal.ROUND_HALF_UP);

        System.out.println(printMethods(bi));
        String sb = "FirstValue = " + bi +
                "\nSecondValue = " + bi2 +
                "\n\nabs() = " + bi.abs() +
                "\nadd(value) = " + bi.add(bi2) +
                "\ndivide(value) = " + bi.divide(bi2, 30, BigDecimal.ROUND_HALF_UP) +
                "\nsubtract(value) = " + bi.subtract(bi2) +
                "\nmultiply(value) = " + bi.multiply(bi2) +
                "\nmin(value) = " + bi.min(bi2) +
                "\nmax(value) = " + bi.max(bi2) +
                "\nremainder(value) = " + bi.remainder(bi2);

        System.out.println(sb);
    }

    private String printMethods(Number element) {
        return "-------------------------------------\nClass: " + element.getClass() + "\n" +
                "byteValue() = " + element.byteValue() + "\n" +
                "shortValue() = " + element.shortValue() + "\n" +
                "integerValue() = " + element.intValue() + "\n" +
                "longValue() = " + element.longValue() + "\n" +
                "floatValue()  = " + element.floatValue() + "\n" +
                "doubleValue() = " + element.doubleValue() + "\n" +
                "toString() = " + element.toString() + "\n" +
                "hashCode() = " + element.hashCode() + "\n-------------------------------------\n";
    }


}
