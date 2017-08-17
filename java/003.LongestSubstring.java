// Problem 3 Longest Substring Without Repeating Characters

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s.length() == 0)
            return 0;
        for(int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            int j;
            for(j = i; j < s.length(); j++) {
                if(map.containsKey(s.charAt(j)))
                    break;
                map.put(s.charAt(j), 0);
            }
            max = Math.max(max, j-i);                
        }
        return max;
    }
}


/// another method

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        if(s.length() == 0)
            return 0;
        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j)))
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            map.put(s.charAt(j), j);
            max = Math.max(max, j-i+1);                
        }
        return max;
    }
}
