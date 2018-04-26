// Problem 821 Shortest Distance To A Character

class Solution {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) continue;
            res[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n - 1; i++) {
            if (res[i] == Integer.MAX_VALUE) continue;
            res[i + 1] = Math.min(res[i] + 1, res[i + 1]);
        }
        for (int i = n - 1; i > 0; i--) {
            res[i - 1] = Math.min(res[i] + 1, res[i - 1]);
        }
        return res;
    }
}