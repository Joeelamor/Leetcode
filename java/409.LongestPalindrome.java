// Problem 409 Longest Palindrome

// Method 1: Use Set
public class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                count++;
            }
            else
                set.add(s.charAt(i));
        }
        return set.isEmpty()? count*2 : count*2 + 1;
    }
}

// Method 2: mathematic method
public class Solution {
    public int longestPalindrome(String s) {
        int[] lowerCase = new int[26];
        int[] upperCase = new int[26];
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 97)
                lowerCase[s.charAt(i) - 'a']++;
            else
                upperCase[s.charAt(i) - 'A']++;
        }
        for(int i = 0; i < 26; i++) {
            count += (lowerCase[i] / 2) * 2;
            count += (upperCase[i] / 2) * 2;
        }
        return count == s.length()? count: count + 1;
    }
} 