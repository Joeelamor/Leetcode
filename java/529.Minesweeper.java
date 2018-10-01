// Question 529 Minesweeper

class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';  
            return board;
        }
        if (board[x][y] == 'E') {
            sweep(board, x, y);
        }
        return board;
    }
    
    private void sweep(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'E')
            return;
        int num = countMine(board, x, y);
        if (num == 0) {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int a = x + dirs[i][0];
                int b = y + dirs[i][1];
                sweep(board, a, b);
            }
        } else {
            board[x][y] = (char)(num + '0');
        }
        
    }
    
    private int countMine(char[][] board, int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int a = x + dirs[i][0];
            int b = y + dirs[i][1];
            if (a < 0 || b< 0 || a >= board.length || b >= board[0].length)
                continue;
            if (board[a][b] == 'M')
                count++;
        }
        return count;
    }
}