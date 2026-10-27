package practice1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class MainBubble {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 120000};
        
        String filename = "results_bubble.csv";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("N;Худший;Лучший;Средний;N^2");
            
            for (int n : sizes) {
                long worstTime = measureWorst(n);
                long bestTime = measureBest(n);
                long avgTime = measureAverage(n);
                
                writer.printf("%d;%d;%d;%d;%d%n", n, worstTime, bestTime, avgTime, (long)n * n);
            }
            System.out.println("Файл " + filename + " успешно создан!");
            
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

    private static long measureWorst(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = n - i;
        long start = System.nanoTime();
        BubbleSort.sort(arr);
        return System.nanoTime() - start;
    }

    private static long measureBest(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        long start = System.nanoTime();
        BubbleSort.sort(arr);
        return System.nanoTime() - start;
    }

    private static long measureAverage(int n) {
        Random random = new Random(7777);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = random.nextInt(1000);
        long start = System.nanoTime();
        BubbleSort.sort(arr);
        return System.nanoTime() - start;
    }
}