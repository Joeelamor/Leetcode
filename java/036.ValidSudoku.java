// Problem 36 Valid Sudoku

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    String str = "(" + board[i][j] +")";
                    if (!set.add(i + str) || !set.add(str + j) || !set.add(i / 3 + str + j / 3))
                        return false;
                }
            } 
        } 
        return true;
    }
}