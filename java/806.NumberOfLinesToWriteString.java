// Problem 806 Number of Lines To Write String

class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int line = 1, width = 0;
        for (char c: S.toCharArray()) {
            if (width + widths[c - 'a'] > 100) {
                line++;
                width = 0;
            }
            width += widths[c - 'a'];
        }
        return new int[]{line, width};
    }
}