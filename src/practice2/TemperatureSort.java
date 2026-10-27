package practice2;

import java.util.ArrayList;
import java.util.List;

public class TemperatureSort {
    public static void sort(double[] arr) {
        if (arr.length == 0) return;
        int s = arr.length;
        List<List<Double>> buckets = new ArrayList<>(s);

        for (int i = 0; i < s; i++) {
            buckets.add(new ArrayList<>());
        }

        for (double val : arr) {
            if (val < 0 || val >= 1.0) {
                throw new IllegalArgumentException("Temperature must be in [0, 1)");
            }
            int index = Math.min(s - 1, (int) (val * s));
            buckets.get(index).add(val);
        }

        int index = 0;
        for (List<Double> bucket : buckets) {
            insertionSort(bucket);
            for (double val : bucket) {
                arr[index++] = val;
            }
        }
    }

    private static void insertionSort(List<Double> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            double key = bucket.get(i);
            int j = i - 1;
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }
}