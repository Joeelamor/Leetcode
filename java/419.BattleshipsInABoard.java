// Problem 419 Battleships In A Board

/* Going over all cells, we can count only those that are the "first" cell of the 
 * battleship. First cell will be defined as the most top-left cell. We can check for first 
 * cells by only counting cells that do not have an 'X' to the left and do not have an 'X' 
 * above them.
 */
class Solution {
    public int countBattleships(char[][] board) {
        if (board.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.')
                    continue;
                if (i > 0 && board[i - 1][j] == 'X')
                    continue;
                if (j > 0 && board[i][j - 1] == 'X')
                    continue;
                count++;
            }
        }
        return count;
    }
}