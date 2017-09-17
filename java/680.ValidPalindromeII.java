// Problem 680 Valid Palindrome II

class Solution {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return palindrom(s, i + 1, j) || palindrom(s, i, j - 1);  
        }
        return true;
    }
    public boolean palindrom(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }
}