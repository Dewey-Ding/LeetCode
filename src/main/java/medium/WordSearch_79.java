package medium;

public class WordSearch_79 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCB"));
    }

    public static boolean exist(char[][] board, String word) {
        int[] counts = new int[26];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                counts[board[i][j] - 'A']++;
            }
        }
        for (int i = 0; i < word.length(); i++) {
            if (--counts[word.charAt(i) - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }
}
