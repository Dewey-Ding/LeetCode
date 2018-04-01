package medium;

public class SetMatrixZeroes_73 {
    public static void main(String[] args) {
        int[][] matric = {{0},{1}};
        setZeroes(matric);
        for (int i = 0; i < matric.length; i++) {
            for (int j = 0; j < matric[0].length; j++) {
                System.out.print(matric[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean rowZero = false, columnZero = false;
        int row = matrix.length, column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        rowZero = true;
                    }
                    if (j == 0) {
                        columnZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowZero) {
            for (int i = 0; i < column; i++) {
                matrix[0][i] = 0;
            }
        }
        if (columnZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
