package practice1;

import java.util.Random;

public class Bubble {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 120000};

        System.out.println("=== Замеры времени (наносекунды) ===");
        System.out.println("N\tХудший\tЛучший\tСредний");

        for (int n : sizes) {
            long worstTime = measureWorst(n);
            long bestTime = measureBest(n);
            long avgTime = measureAverage(n);

            System.out.printf("%d\t%d\t%d\t%d%n", n, worstTime, bestTime, avgTime);
        }
    }

    private static long measureWorst(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        long start = System.nanoTime();
        Sort.selectionSort(arr);
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureBest(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        long start = System.nanoTime();
        Sort.selectionSort(arr);
        long end = System.nanoTime();
        return end - start;
    }

    private static long measureAverage(int n) {
        Random random = new Random(7777);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(1000);
        }
        long start = System.nanoTime();
        Sort.selectionSort(arr);
        long end = System.nanoTime();
        return end - start;
    }
}