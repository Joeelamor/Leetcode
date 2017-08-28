// Problem 438 Find All Anagrams in a String

// A stupid method: O(n^2) time
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length() || s == null || p == null)
            return res;
        for(int i = 0; i <= s.length() - p.length(); i++) {
            if(compare(s.substring(i, i + p.length()), p))
                res.add(i);
        }
        return res;            
    }
    
    public boolean compare(String s, String t) {
        int []str = new int[26];
        for(int i = 0; i < s.length(); i++) {
            str[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
            str[t.charAt(i) - 'a']--; 
        }
        for(int i: str) {
            if(i != 0)
                return false;
        }
        return true;
    }
}


// Method 2: O(n) time
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int []arr = new int[26];
        if(s == null || p == null || s.length() < p.length())
            return res;
        for(char c: p.toCharArray())
            arr[c - 'a']++;
        int left = 0, right = 0, count = p.length();
        while(right < s.length()) {
            if(arr[s.charAt(right) - 'a'] >= 1) {
               count--;
            }
            arr[s.charAt(right) - 'a']--;
            right++;
                
            if(count == 0)
                res.add(left);
            if(right - left == p.length()) {
                if(arr[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
            arr[s.charAt(left) - 'a']++;
            left++;                    
            }
        }
        return res;
    }
}