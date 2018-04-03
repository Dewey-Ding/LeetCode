package medium;

public class WordSearch_79 {
    public static void main(String[] args) {
        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        System.out.println(exist(board, "AAB"));
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] flag = new int[board.length][board[0].length];
                    if (helper(board, flag, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean helper(char[][] board, int[][] flag, int i, int j, int index, String word) {
        if (index == word.length() - 1) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || flag[i][j] == 1 || board[i][j] != word.charAt(index + 1)) {
            return false;
        }
        flag[i][j] = 1;
        if (helper(board, flag, i - 1, j, index + 1, word) || helper(board, flag, i + 1, j, index + 1, word)
                || helper(board, flag, i, j - 1, index + 1, word) || helper(board, flag, i, j + 1, index + 1, word)) {
            return true;
        }
        flag[i][j] = 0;
        return false;
    }


    /*13ms
    * sample 13 ms submission
class Solution {
    public boolean exist(char[][] board, String word) {
        int lenX = board.length;
        if (lenX == 0) {return false;}
        int lenY = board[0].length;
        if (lenY == 0) {return false;}
        if (word.length() == 0) {return false;}
        char wordStart = word.charAt(0);
        boolean[][] visited = new boolean[lenX][lenY];
        for (int x = 0; x < lenX; x++) {
            for (int y = 0; y < lenY; y++) {
                if (board[x][y] == wordStart) {
                    if (wordVerify(board,word,x,y,0,visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean wordVerify(char[][] board, String word, int x, int y, int wordIndex, boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false; //Out-of-bounds check
        }
        if (visited[x][y] == true) {
            return false; //Already used
        }
        if (board[x][y] != word.charAt(wordIndex)) {
            return false; //Wrong letter
        }
        if (wordIndex == word.length() - 1) {
            return true; //Last index reached, return true
        }
        //Standard logic
        visited[x][y] = true;
        boolean trueResult = false;
        trueResult = wordVerify(board,word,x+1,y,wordIndex+1,visited);
        if (trueResult) {return true;}
        trueResult = wordVerify(board,word,x-1,y,wordIndex+1,visited);
        if (trueResult) {return true;}
        trueResult = wordVerify(board,word,x,y+1,wordIndex+1,visited);
        if (trueResult) {return true;}
        trueResult = wordVerify(board,word,x,y-1,wordIndex+1,visited);
        if (trueResult) {return true;}
        visited[x][y] = false;
        return false;
    }
}
    *
    * */
    /*

    public static boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
        int[][] flag = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0)){
                    flag[i][j]=1;
                    if(helper(board,flag,i,j,0,word)){return true;}
                }
            }
        }
        return false;
    }
    public static boolean helper(char[][] board,int[][] flag,int i,int j,int index,String word){
        if(index==word.length()-1){
            return true;
        }else if(index<word.length()){
            //像上走
            if(i!=0&&word.charAt(index+1)==board[i-1][j]&&flag[i-1][j]==0){
                flag[i-1][j]=1;
                return helper(board,flag,i-1,j,index+1,word);
            }
            //像左走
            if(j!=0&&word.charAt(index+1)==board[i][j-1]&& flag[i][j-1]==0){
                flag[i][j-1]=1;
                return helper(board,flag,i,j-1,index+1,word);
            }
            //像右走
            if(j!=board[0].length-1&&word.charAt(index+1)==board[i][j+1]&&flag[i][j+1]==0){
                flag[i][j+1]=1;
                return helper(board,flag,i,j+1,index+1,word);
            }
            //像下走
            if(i!=board.length-1&&word.charAt(index+1)==board[i+1][j]&&flag[i+1][j]==0){
                flag[i+1][j]=1;
                return helper(board,flag,i+1,j,index+1,word);
            }
            return false;
        }else {
            return false;
        }
    }

    */

/*    public static boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
        if(board.length*board[0].length<word.length()){
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0)){
                    int[][] flag = new int[board.length][board[0].length+1];
                    flag[i][j]=1;
                    helper(board,flag,i,j,0,word);
                    if(flag[board.length-1][board[0].length]==1){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void helper(char[][] board,int[][] flag,int i,int j,int index,String word){
        if(index==word.length()-1){
            flag[board.length-1][board[0].length]=1;
            return;
        }else if(index<word.length()){
            //像上走
            if(i!=0&&word.charAt(index+1)==board[i-1][j]&&flag[i-1][j]==0){
                flag[i-1][j]=1;
                helper(board,flag,i-1,j,index+1,word);
                flag[i-1][j]=0;
            }
            //像左走
            if(j!=0&&word.charAt(index+1)==board[i][j-1]&& flag[i][j-1]==0){
                flag[i][j-1]=1;
                helper(board,flag,i,j-1,index+1,word);
                flag[i][j-1]=0;
            }
            //像右走
            if(j!=board[0].length-1&&word.charAt(index+1)==board[i][j+1]&&flag[i][j+1]==0){
                flag[i][j+1]=1;
                helper(board,flag,i,j+1,index+1,word);
                flag[i][j+1]=0;
            }
            //像下走
            if(i!=board.length-1&&word.charAt(index+1)==board[i+1][j]&&flag[i+1][j]==0){
                flag[i+1][j]=1;
                helper(board,flag,i+1,j,index+1,word);
                flag[i+1][j]=0;
            }
            //return false;
        }else {
            return;
        }
    }*/
}
