package medium;

public class Searcha2DMatrix_74 {
    public static void main(String[] args) {
        int[][] matric = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matric, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, column = matrix[0].length;
        int left = 0, right = row * column - 1;
        if (matrix[0][0] > target || matrix[right / column][right % column] < target) {
            return false;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid / column][mid % column] == target) {
                return true;
            } else if (matrix[mid / column][mid % column] > target) {
                right = mid - 1;
            } else if (matrix[mid / column][mid % column] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}
