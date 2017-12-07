// Problem 161 One Edit Distance

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1)
            return false;
        if (s.length() == t.length())
            return helper(s, t);
        else if (s.length() > t.length())
            return helper1(s, t);
        else
            return helper1(t, s);
    }
    
    private boolean helper(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i))
                count++;
        }
        return count == 1;
    }
    
    private boolean helper1(String s1, String s2) {
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
            if (s1.charAt(i) != s2.charAt(j))
                return s1.substring(i + 1).equals(s2.substring(j));
        }
        return true;
    }
}