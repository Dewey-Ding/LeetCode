package medium;

import java.util.ArrayList;
import java.util.List;

public class spiralorder_54 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2,3}};
        List<Integer> result = spiralOrder(matrix);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length==0||matrix[0].length==0){
            return result;
        }
        int row_end = matrix.length-1;
        int column_end = matrix[0].length-1;
        int row_start = 0,column_start = 0;
        while(row_start<=row_end&&column_start<=column_end){
            for (int column = column_start; column <= column_end; column++) {
                result.add(matrix[row_start][column]);
            }
            for (int row = row_start+1; row <= row_end; row++) {
                result.add(matrix[row][column_end]);
            }
            if(row_start<row_end&&column_start<column_end) {
                for (int column = column_end - 1; column >= column_start; column--) {
                    result.add(matrix[row_end][column]);
                }
                for (int row = row_end - 1; row >= row_start + 1; row--) {
                    result.add(matrix[row][column_start]);
                }
            }
            row_end--;
            row_start++;
            column_start++;
            column_end--;
        }
        return result;
    }
}
