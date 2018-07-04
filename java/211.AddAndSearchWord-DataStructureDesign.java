// Problem 211 Add And Search Word - Data Structure Design

class WordDictionary {
    
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) 
                node.children[word.charAt(i) - 'a'] = new TrieNode();
            node = node.children[word.charAt(i) - 'a'];
        }
        node.endFlag = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
        return helper(word, 0, node);
    }
    private boolean helper(String word, int start, TrieNode cur) {
        if (start == word.length())
            return cur.endFlag;
        char c = word.charAt(start);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null) {
                    if (helper(word, start + 1, cur.children[i]))
                        return true;
                }
            }
        } else {
            if (cur.children[c - 'a'] == null)
                return false;
            else {
                return helper(word, start + 1, cur.children[c - 'a']);
            }
        }
        return false;
    }
    
    class TrieNode {
        boolean endFlag;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */