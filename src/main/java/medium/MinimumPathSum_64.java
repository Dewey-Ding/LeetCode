package medium;

public class MinimumPathSum_64 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum2(grid));
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
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

    public static int minPathSum2(int[][] grid){
        int row = grid.length;
        int colume = grid[0].length;
        int dp[] = new int[colume];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colume; j++) {
                if(j==0){
                    dp[j] = dp[j];
                }else if(i==0){
                    dp[j] = dp[j-1];
                }else{
                    dp[j] = Math.min(dp[j-1],dp[j]);
                }
                dp[j] = dp[j]+grid[i][j];
            }
        }
        return dp[colume-1];
    }
}
