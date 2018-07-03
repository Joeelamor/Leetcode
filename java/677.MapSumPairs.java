// Problem 677 Map Sum Pairs

// Method 1:
class MapSum {
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        for(String str: map.keySet()) {
        	// Use String.startsWith(prefix) to find the string.
            if(str.startsWith(prefix)) { 
                sum += map.get(str);
            }
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */


// Method 2: edit method 1 String.startsWith(prefix) function
class MapSum {

    private Map<String, Integer> map;
    
    public MapSum() {
        map = new HashMap<>();    
    }
    
    public void insert(String key, int val) {
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        
        int count = 0;
        
        for (String key : map.keySet()) {
            
            String keyPrefix = prefix.length() > key.length() ? key : key.substring(0, prefix.length());
            if (keyPrefix.equals(prefix))
                count += map.getOrDefault(key, 0);
        }
        
        return count;
    }
}


// Method 3: use two hashMaps
class MapSum {
    Map<String, Integer> map;
    Map<String, Integer> original;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
        original = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        val -= original.getOrDefault(key, 0);
        String s = "";
        for (char c : key.toCharArray()) {
            s += c;
            map.put(s, map.getOrDefault(s, 0) + val);
        }
        original.put(key, original.getOrDefault(key, 0) + val);
    }
    
    public int sum(String prefix) {
        return map.getOrDefault(prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */


// Method 4: use trie

class MapSum {
    TrieNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode(0);
    }
    
    public void insert(String key, int val) {
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            if (node.children[key.charAt(i) - 'a'] == null)
                node.children[key.charAt(i) - 'a'] = new TrieNode(val);
            else
                node.children[key.charAt(i) - 'a'].sum += val; // update all pre nodes' sum along the path
            node = node.children[key.charAt(i) - 'a'];
        }
        if (node.isWord) { // key existed
            node.isWord = false;
            insert(key, -node.val); // update all pre nodes' sum along the path
        }
        node.val = val;
        node.isWord = true;
    }
    
    public int sum(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            node = node.children[prefix.charAt(i) - 'a'];
            if (node == null)
                return 0;
        }
        return node.sum;
    }

    class TrieNode {
        int val, sum;
        boolean isWord;
        TrieNode[] children;
        public TrieNode(int val) {
            sum = this.val = val;
            children = new TrieNode[26];
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */