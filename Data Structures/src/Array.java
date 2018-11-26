public class Array {

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        for (int i : intArray) {
            System.out.print(i + " ");
        }

        System.out.println("");

        int[][] Array2D = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Array2D[i][j] = i + (j*10);
            }
        }

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.print(Array2D[row][col] + " ");
            }
            System.out.print("\n");
        }
    }
}
