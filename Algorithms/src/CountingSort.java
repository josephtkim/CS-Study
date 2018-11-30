import java.util.Arrays;

public class CountingSort {

    public int[] sort(int[] array, int k) {
        // Create array of size maximum value k + 1
        int[] counts = new int[k + 1];
        int[] output = new int[array.length];

        // Count each value in the array
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }

        // Increase each count by previous count
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        // Each value in the counts array
        // corresponds to index of value in output.
        // Go through array and place in correct position in output.
        for (int i = array.length-1; i >= 0; i--) {
            int value = array[i];
            int index = counts[value] - 1;
            output[index] = value;
            counts[value]--;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{4};
        int[] test2 = new int[]{5, 4, 3, 2, 1};
        int[] test3 = new int[]{1, 6, 2, 4, 1};
        int[] test4 = new int[]{6, 6, 7, 5, 4, 3, 2, 1, 1, 7};

        CountingSort cs = new CountingSort();

        test1 = cs.sort(test1, 4);
        test2 = cs.sort(test2, 5);
        test3 = cs.sort(test3, 6);
        test4 = cs.sort(test4, 7);

        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
        System.out.println(Arrays.toString(test4));
    }
}