// Problem 438 Find All Anagrams in a String

// A stupid method
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
