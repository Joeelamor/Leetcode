Problem 28 Implement strStr()

/* In this question, it also needs to use indexOf() method to check the first 
// index.
public class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int m = needle.length();
        int n = haystack.length();
        if(m == 0 && n ==0)
            return 0;
        if(n != 0 && m == 0)
            return 0;
        if(m > n)
            return -1;
        else {
            while(i < n) {
                if(haystack.substring(i, n).indexOf(needle) != 0) {
                    i++;
                    if(n - i < m)
                        return -1;
                }
                else
                    break;
            }
        }
        return i;
    }
}