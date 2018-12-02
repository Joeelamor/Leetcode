// Question 723 Candy Crush 

class Solution {
    public int[][] candyCrush(int[][] board) {
        Set<Coordinates> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int cur = board[i][j];
                if (cur == 0) continue;
                if ((i - 2 >= 0 && board[i - 1][j] == cur && board[i - 2][j] == cur) ||                                                 
                   (i + 2 <= board.length - 1 && board[i + 1][j] == cur && board[i + 2][j] == cur) ||                                  
                   (j - 2 >= 0 && board[i][j - 1] == cur && board[i][j - 2] == cur) ||                                                 
                   (j + 2 <= board[i].length - 1 && board[i][j + 1] == cur && board[i][j + 2] == cur) ||                               
                   (i - 1 >= 0 && i + 1 <= board.length - 1 && board[i - 1][j] == cur && board[i + 1][j] == cur) ||                   
                   (j - 1 >= 0 && j + 1 <= board[i].length - 1 && board[i][j - 1] == cur && board[i][j + 1] == cur)) { 
                    set.add(new Coordinates(i, j));
                }
            }
        }
        if (set.isEmpty()) return board;     
        for (Coordinates c : set) {
            int x = c.i;
            int y = c.j;
            board[x][y] = 0;     
        }
        drop(board);
        return candyCrush(board);
    }
    private void drop(int[][] board) {                    
        for (int j = 0; j < board[0].length; j++) {
            int bot = board.length - 1;
            int top = board.length - 1;
            while (top >= 0) {
                if (board[top][j] == 0) {
                    top--;
                }
                else {
                    board[bot--][j] = board[top--][j];
                }
            }
            while (bot >= 0) {
                board[bot--][j] = 0;
            }
        }
    }
}

class Coordinates {
    int i;
    int j;
    Coordinates(int x, int y) {
        i = x;
        j = y;
    }
}