import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    public void merge(int[] array, int left, int middle, int right) {
        int M = middle - left + 1;
        int N = right - middle;

        int[] L = new int[M];
        int[] R = new int[N];

        for (int i = 0; i < M; i++) {
            L[i] = array[left + i];
        }

        for (int i = 0; i < N; i++) {
            R[i] = array[middle + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < M && j < N) {
            if (L[i] < R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < M) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < N) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1};
        int[] test2 = new int[]{7, 6, 5, 4, 3, 2, 1};
        int[] test3 = new int[]{9, 8, 7, 6, 5, 2, 1, 4, 1};
        int[] test4 = new int[]{10, 9, 1, 8, 1, 9, 1, 8};

        MergeSort m = new MergeSort();

        m.mergeSort(test1, 0, test1.length-1);
        m.mergeSort(test2, 0, test2.length-1);
        m.mergeSort(test3, 0, test3.length-1);
        m.mergeSort(test4, 0, test4.length-1);

        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
        System.out.println(Arrays.toString(test4));
    }
}
