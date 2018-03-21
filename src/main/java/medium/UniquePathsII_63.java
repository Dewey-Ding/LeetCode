package medium;

public class UniquePathsII_63 {
    public static void main(String args[]){
        int[][] obstacleGrid = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        obstacleGrid[0][0]=1;
        int row = obstacleGrid.length;
        int colume = obstacleGrid[0].length;
        for(int i = 0;i<row;i++){
            for (int j = 0; j <colume ; j++) {
                if(i==0&&j==0){
                    continue;
                }
                if(obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]=0;
                }else if(i>0&&j>0){
                    obstacleGrid[i][j] = obstacleGrid[i][j-1]+obstacleGrid[i-1][j];
                }else if(i==0){
                    obstacleGrid[i][j] = obstacleGrid[i][j-1];
                }else if(j==0){
                    obstacleGrid[i][j] = obstacleGrid[i-1][j];
                }
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}

