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


// Method 2 : Use Trie

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board.length == 0)
            return res;
        TrieNode root = buildTree(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(res, board, i, j, root);
            }
        }
        return res;
    }
    
    public void helper(List<String> res, char[][] board, int i, int j, TrieNode cur) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || cur.children[board[i][j] - 'a'] == null)
            return;
        char c = board[i][j];
        cur = cur.children[c - 'a'];
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        board[i][j] = '#';
        helper(res, board, i + 1, j, cur);
        helper(res, board, i - 1, j, cur);
        helper(res, board, i, j + 1, cur);
        helper(res, board, i, j - 1, cur);
        board[i][j] = c; 
    }
    
    public TrieNode buildTree(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null)
                    cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }
        return root;
    }
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}



