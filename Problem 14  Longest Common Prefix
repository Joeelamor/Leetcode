Problem 14  Longest Common Prefix

/* In this problem, we use indexOf() method to find if there exist common prefix

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String s = strs[0];
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(s) != 0)
                s = s.substring(0, s.length() - 1);
        }
        return s;
    }
}