package practice2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Задание 1: Температура ---");
        double[] tempInput = {0.15, 0.75, 0.40, 0.05};
        System.out.println("Вход:  " + Arrays.toString(tempInput));
        TemperatureSort.sort(tempInput);
        System.out.println("Выход: " + Arrays.toString(tempInput));
        System.out.println();

        System.out.println("--- Задание 2: Дни недели ---");
        int[] daysInput = {7, 2, 7, 1};
        System.out.println("Вход:  " + Arrays.toString(daysInput));
        WeekdaysSort.sort(daysInput);
        System.out.println("Выход: " + Arrays.toString(daysInput));
        
        int[] daysInput2 = {3, 3, 5, 1};
        System.out.println("Вход:  " + Arrays.toString(daysInput2));
        WeekdaysSort.sort(daysInput2);
        System.out.println("Выход: " + Arrays.toString(daysInput2));
        System.out.println();

        System.out.println("--- Задание 3: Номера посылок ---");
        int[] parcelsInput = {329, 457, 657, 839};
        System.out.println("Вход:  " + Arrays.toString(parcelsInput));
        ParcelSort.sort(parcelsInput);
        System.out.println("Выход: " + Arrays.toString(parcelsInput));

        int[] parcelsInput2 = {21, 4, 105, 33};
        System.out.println("Вход:  " + Arrays.toString(parcelsInput2));
        ParcelSort.sort(parcelsInput2);
        System.out.println("Выход: " + Arrays.toString(parcelsInput2));
    }
}