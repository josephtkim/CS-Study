import java.util.Arrays;

public class SelectionSort {

    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int length = array.length;

        // At each iteration, up to index j will be sorted.
        for (int j = 0; j < length; j++) {
            // Find minimum index
            int minIndex = j;

            for (int i = j + 1; i < length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }

            if (array[minIndex] < array[j]) {
                int temp = array[minIndex];
                array[minIndex] = array[j];
                array[j] = temp;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{};
        int[] test2 = new int[]{1};
        int[] test3 = new int[]{2, 1};
        int[] test4 = new int[]{3, 1, 1, 3, 1, 1, 3};
        int[] test5 = new int[]{5, 4, 3, 2, 1};

        SelectionSort s = new SelectionSort();

        System.out.println(Arrays.toString(s.sort(test1)));
        System.out.println(Arrays.toString(s.sort(test2)));
        System.out.println(Arrays.toString(s.sort(test3)));
        System.out.println(Arrays.toString(s.sort(test4)));
        System.out.println(Arrays.toString(s.sort(test5)));
    }
}
