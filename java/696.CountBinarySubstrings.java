// Problem 696 Count Binary Substrings

class Solution {
    public int countBinarySubstrings(String s) {
        int preLength = 0, curLength = 1, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLength++;
            }
            else {
                preLength = curLength;
                curLength = 1;
            }
            if (preLength >= curLength)
                res++;
        }
        return res;
    }
}