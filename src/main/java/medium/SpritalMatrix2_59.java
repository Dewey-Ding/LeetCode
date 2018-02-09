package medium;

public class SpritalMatrix2_59 {
    public static void main(String[] args) {
        int[][] result = generateMatrix(0);
        for (int i = 0; i <result.length ; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
        System.out.println(generateMatrix(3));
    }
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int row_start = 0,column_start = 0,row_end = n-1,column_end=n-1;
        int count = 1;
        while (count<=n*n){
            for (int i = column_start; i <= column_end; i++) {
                result[row_start][i] = count++;
            }
            for (int i = row_start+1; i <= row_end ; i++) {
                result[i][column_end] = count++;
            }
            for (int i = column_end-1; i >=column_start ; i--) {
                result[row_end][i] = count++;
            }
            for (int i = row_end-1; i >=row_start+1 ; i--) {
                result[i][column_start] = count++;
            }
            row_start++;
            row_end--;
            column_start++;
            column_end--;
        }
        return result;
    }
}
