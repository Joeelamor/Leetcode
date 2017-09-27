// Problem 151 Reverse Words In A String

public class Solution {
    public String reverseWords(String s) {
        String []strs = s.trim().split("\\s+");
        String res = "";
        for (int i = strs.length - 1; i >= 1; i--) {
            res += strs[i] + " ";
        }
        return res + strs[0];
    }
}