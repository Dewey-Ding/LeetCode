package medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_36 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
        /*
        * {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        };
        */
        System.out.println(isValidSudoku(board));


    }

    public static boolean isValidSudoku(char[][] board) {
        Set set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> column = new HashSet<>();
            Set<Character> block = new HashSet<>();
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j]!='.'&&!row.add(board[i][j])){
                    return false;
                }
                if(board[j][i]!='.'&&!column.add(board[j][i])){
                    return false;
                }
                int rowN = 3*(i/3)+j/3;
                int columeN = (i%3)*3+j%3;
                if(board[rowN][columeN]!='.'&&!block.add(board[rowN][columeN])){
                    return false;
                }
            }
        }
        return true;
    }


    /*
    *     public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        boolean[][] rowValids = new boolean[9][9];
        boolean[][] columnValids = new boolean[9][9];
        boolean[][] subBoxValids = new boolean[9][9];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int k = i / 3 * 3 + j / 3;
                    if (rowValids[i][num] || columnValids[j][num] || subBoxValids[k][num]) {
                        return false;
                    }
                    rowValids[i][num] = columnValids[j][num] = subBoxValids[k][num] = true;
                }
            }
        }
        return true;
    }
    * */
/*
    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }
    */
}
