// Problem 290 Word Pattern

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> hashMap = new HashMap<>();
        String [] a = str.split(" ");
        if(pattern.length() != a.length)
            return false;
        for(int i = 0; i < pattern.length(); i++) {
            if(hashMap.containsKey(pattern.charAt(i))) {
                if(!hashMap.get(pattern.charAt(i)).equals(a[i]))
                    return false;
            }
            else {
                if(hashMap.containsValue(a[i]))
                    return false;
                hashMap.put(pattern.charAt(i), a[i]);
            }
        }
        return true;
    }
}