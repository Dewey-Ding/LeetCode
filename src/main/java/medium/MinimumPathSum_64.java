package medium;

public class MinimumPathSum_64 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int colume = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colume; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i != 0 && j != 0) {
                    grid[i][j] += grid[i - 1][j] > grid[i][j - 1] ? grid[i][j - 1] : grid[i - 1][j];
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                }
            }
        }
        return grid[row - 1][colume - 1];
    }
}
