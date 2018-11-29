import java.util.Arrays;

public class InsertionSort {

    public int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int length = array.length;

        for (int j = 1; j < length; j++) {
            int key = array[j];
            int i = j - 1;

            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }

            array[i + 1] = key;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{};
        int[] test2 = new int[]{1};
        int[] test3 = new int[]{2, 1};
        int[] test4 = new int[]{5, 1, 2, 3, 5};
        int[] test5 = new int[]{1, 2, 5, 4, 1, 1};

        InsertionSort insertionSort = new InsertionSort();

        System.out.println(Arrays.toString(insertionSort.sort(test1)));
        System.out.println(Arrays.toString(insertionSort.sort(test2)));
        System.out.println(Arrays.toString(insertionSort.sort(test3)));
        System.out.println(Arrays.toString(insertionSort.sort(test4)));
        System.out.println(Arrays.toString(insertionSort.sort(test5)));
    }
}
