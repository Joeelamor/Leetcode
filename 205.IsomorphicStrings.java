// Problem 205 Isomorphic Strings

// Use HashMap
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() <= 1)
            return true;
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)).equals(t.charAt(i)))
                    continue;
                else
                    return false;
            }
            else {
                if(!map.containsValue(t.charAt(i)))
                    map.put(s.charAt(i), t.charAt(i));
                else
                    return false;
            }
        }
        return true;
    }
}