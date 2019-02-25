// Question 999 Available Captures for Rook

class Solution {
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (board[i][j] == 'R') 
                    return cap(board,i,j,0,1) + cap(board,i,j,0,-1) + cap(board,i,j,1,0) + cap(board,i,j,-1,0);
        return 0;
    }
    
    int cap(char[][] board, int x, int y, int dx, int dy) {
        while (x >= 0 && x < board.length && y >= 0 && y < board[x].length && board[x][y] != 'B') {
            if (board[x][y] == 'p') 
                return 1;
            x += dx; 
            y += dy;
      }
      return 0;
    }    
}

