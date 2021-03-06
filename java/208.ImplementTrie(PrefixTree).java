// Problem 208 Implement Trie (Prefix Tree)

class Trie {
    static class TrieNode {
        TrieNode[] children;
        boolean endFlag;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode prev = root;
        for (int i = 0; i < word.length(); i++) {
            if (prev.children[word.charAt(i) - 'a'] == null) 
                prev.children[word.charAt(i) - 'a'] = new TrieNode();
            prev = prev.children[word.charAt(i) - 'a'];
        }
        prev.endFlag = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) 
                return false;
            else
                cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur.endFlag;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.children[prefix.charAt(i) - 'a'] == null) 
                return false;
            else
                cur = cur.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */