import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int p = partition(array, left, right);
            quickSort(array, left, p - 1);
            quickSort(array, p + 1, right);
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int partition(int[] array, int left, int right) {
        int value = array[right];

        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] < value) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i+1, right);
        return i + 1;
    }


    public void randomizedQuickSort(int[] array, int left, int right) {
        if (left < right) {
            int p = randomPartition(array, left, right);
            randomizedQuickSort(array, left, p - 1);
            randomizedQuickSort(array, p + 1, right);
        }
    }

    public int randomPartition(int[] array, int left, int right) {
        // Get a random index
        Random r = new Random();
        int randIndex = left + r.nextInt(right - left + 1);

        // Swap with rightmost index
        swap(array, randIndex, right);

        // return the partition as usual
        return partition(array, left, right);
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{4, 3, 2, 1};
        int[] test2 = new int[]{5, 2, 1, 4, 1};
        int[] test3 = new int[]{1, 4, 4, 1, 5, 4, 1};
        int[] test4 = new int[]{6, 5, 4, 3, 2, 1, 6, 5, 4, 3, 2, 1, 6, 5, 4, 3, 2, 1};

        QuickSort qs = new QuickSort();

        /*
        qs.quickSort(test1, 0, test1.length-1);
        qs.quickSort(test2, 0, test2.length-1);
        qs.quickSort(test3, 0, test3.length-1);
        qs.quickSort(test4, 0, test4.length-1);

        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
        System.out.println(Arrays.toString(test4));
        */

        qs.randomizedQuickSort(test1, 0, test1.length-1);
        qs.randomizedQuickSort(test2, 0, test2.length-1);
        qs.randomizedQuickSort(test3, 0, test3.length-1);
        qs.randomizedQuickSort(test4, 0, test4.length-1);

        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
        System.out.println(Arrays.toString(test4));
    }
}
