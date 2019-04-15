// Question 1027 Longest Arithmetic Sequence

class Solution {
    public int longestArithSeqLength(int[] A) {
        int max = 2;
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                int count = dp[j].getOrDefault(diff, 1) + 1;
                max = Math.max(max, count);
                dp[i].put(diff, count);
            }
        }
        return max;
    }
}