// Problem 647 Palindrome Substrings

class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        if (s.length() < 2) return s.length();
        for (int i = 0; i < s.length(); i++) {
            findString(s, i, i);
            findString(s, i, i + 1);
        }
        return count;
    }
    
    private void findString(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
    }
}