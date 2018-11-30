import java.util.Arrays;

public class RadixSort {
    // Modify counting sort to sort by digit
    public int[] countingSort(int[] array, int exp) {
        int[] counts = new int[10];
        int[] output = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int digitValue = (array[i] / exp) % 10;
            counts[digitValue]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i-1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int value = array[i];
            int digitValue = (value / exp) % 10;
            int index = counts[digitValue];
            output[index-1] = value;
            counts[digitValue]--;
        }

        return output;
    }

    public int[] radixSort(int[] array) {
        int maxVal = getMax(array);
        int exp = 1;

        while ((maxVal / exp) > 0) {
            array = countingSort(array, exp);
            exp *= 10;
        }

        return array;
    }

    public int getMax(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1};
        int[] test2 = new int[]{300, 293, 10, 19, 187, 54};
        int[] test3 = new int[]{54, 61, 73, 1, 7, 6, 4, 3, 1};
        int[] test4 = new int[]{109, 208, 307, 111, 222, 111, 222};

        RadixSort rs = new RadixSort();

        test1 = rs.radixSort(test1);
        test2 = rs.radixSort(test2);
        test3 = rs.radixSort(test3);
        test4 = rs.radixSort(test4);

        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
        System.out.println(Arrays.toString(test4));
    }
}