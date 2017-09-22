// Problem 214 Shortest Palindrome

/* The idea is to use two anchors j and i to compare the String from beginning and end.
 * If j can reach the end, the String itself is Palindrome. Otherwise, we divide the String 
 * by j, and get mid = s.substring(0, j) and suffix.
 */

We reverse suffix as beginning of result and recursively call shortestPalindrome to get result of mid then appedn suffix to get result.
class Solution {
    public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == s.charAt(j))
                j++;
        }
        if(j == s.length())
            return s;
        String suffix = s.substring(j);
        
        /* Here use recursion to avoid s.substring(0, j) is not a palindrome, e.g. s = "abcda", then suffix = "cad", 
         * s.substring(0 ,j) = "ab", so we need to use recursion to check "ab".
         */
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
}