// Problem 738 Monotone Increasing Digits

class Solution {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10)
            return N;
        char[] c = String.valueOf(N).toCharArray();
        int mark = c.length;
        for (int i = c.length - 1; i > 0; i--) {
            if (c[i] < c[i - 1]) {
                mark = i - 1;
                c[i - 1]--;
            }
        }
        for (int i = mark + 1; i < c .length; i++) {
            c[i] = '9';
        }
        return Integer.parseInt(new String(c));
    }
}