package practice2;

public class WeekdaysSort {
    public static void sort(int[] arr) {
        if (arr.length == 0) return;

        int min = 1;
        int max = 7;
        int range = max - min + 1;
        int[] count = new int[range];

        for (int val : arr) {
            if (val < 1 || val > 7) {
                throw new IllegalArgumentException("Day must be between 1 and 7");
            }
            count[val - min]++;
        }

        int index = 0;
        for (int offset = 0; offset < count.length; offset++) {
            for (int repeat = 0; repeat < count[offset]; repeat++) {
                arr[index++] = offset + min;
            }
        }
    }
}