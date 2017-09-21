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