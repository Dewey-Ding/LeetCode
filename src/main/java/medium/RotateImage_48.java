package medium;

public class RotateImage_48 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(matrix);
    }
    //分解问题
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < length/2; i++) {
            for (int j = 0; j < length; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[j][length-i-1];
                matrix[j][length-i-1] = tmp;
            }
        }
    }
}
