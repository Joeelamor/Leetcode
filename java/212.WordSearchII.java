// Problem 212 Word Search II

// Method 1: A stupid method.
class Solution {
    static boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        
        Set<String> res = new HashSet<>();
        for (String w : words) {
            visited = new boolean[board.length][board[0].length];
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if((w.charAt(0) == board[i][j]) && search(board, w, i, j, 0)){
                        res.add(w);
                    }
                }
            }
        }
        
        return new ArrayList<String>(res);
    }
    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) || 
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) || 
           search(board, word, i, j+1, index+1)){
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}



