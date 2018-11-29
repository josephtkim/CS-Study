import java.util.Arrays;

public class BubbleSort {

    public int[] bubbleSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        for (int j = array.length - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }

        return array;
    }

    // Bubble sort that stops if no swaps made in one pass
    public int[] flagBubbleSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    swapped = true;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{5, 4, 3, 2, 1};
        int[] test2 = new int[]{4};
        int[] test3 = new int[]{6, 6, 5, 4, 3, 2};

        BubbleSort bs = new BubbleSort();

        /*
        test1 = bs.bubbleSort(test1);
        test2 = bs.bubbleSort(test2);
        test3 = bs.bubbleSort(test3);

        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
        */


        test1 = bs.bubbleSort(test1);
        test2 = bs.bubbleSort(test2);
        test3 = bs.bubbleSort(test3);

        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
    }
}
