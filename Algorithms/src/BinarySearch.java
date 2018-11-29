/*
Iterative binary search
 */
public class BinarySearch {

    public int binarySearch(int[] array, int target) {
        if (array.length < 1) {
            System.out.println("Array is empty");
            return -1;
        }

        int lo = 0;
        int hi = array.length;

        while (lo <= hi) {
            int middle = (lo + hi) / 2;

            if (array[middle] == target) {
                System.out.println("Found!");
                return middle;
            } else if (target < array[middle]) {
                hi = middle - 1;
            } else {
                lo = middle + 1;
            }
        }

        System.out.println("Not found");
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        int[] test1 = new int[]{};
        int[] test2 = new int[]{1};
        int[] test3 = new int[]{1, 2};
        int[] test4 = new int[]{1, 2, 3};
        int[] test5 = new int[]{1, 2, 3, 5, 6, 7};

        System.out.println(bs.binarySearch(test1, 2));

        System.out.println(bs.binarySearch(test2, 1));

        System.out.println(bs.binarySearch(test3, 1));
        System.out.println(bs.binarySearch(test3, 2));

        System.out.println(bs.binarySearch(test4, 2));
        System.out.println(bs.binarySearch(test4, 3));

        System.out.println(bs.binarySearch(test5, 1));
        System.out.println(bs.binarySearch(test5, 3));
        System.out.println(bs.binarySearch(test5, 5));
        System.out.println(bs.binarySearch(test5, 7));
        System.out.println(bs.binarySearch(test5, 4));
    }
}

