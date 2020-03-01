package medium;

public class DeleteOperationforTwoStrings_583 {
    public static void main(String[] args) {
        String word1 = "spake";
        String word2 = "park";
        System.out.println(minDistance(word1,word2));
    }
    public static int minDistance(String word1, String word2) {
        int row = word1.length();
        int column = word2.length();
        int[][] distances = new int[row+1][column+1];
        int max = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    distances[i][j] = distances[i-1][j-1]+1;
                    max = Math.max(distances[i][j],max);
                }else{
                    distances[i][j] = Math.max(distances[i-1][j],distances[i][j-1]);
                }
            }
        }

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                System.out.print(distances[i][j]);
            }
            System.out.println();
        }
        return word1.length()+word2.length()-2*max;
    }
}
