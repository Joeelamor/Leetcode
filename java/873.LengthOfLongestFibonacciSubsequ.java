// Problem 873 Length Of Longest Fibonacci Subsequence

// Method 1: use dp

class Solution {
    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length == 0) return 0;
        int[][] dp = new int[A.length][A.length];
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
            for (int j = 0; j < i; j++) {
                Integer k = map.get(A[i] - A[j]);
                if (A[i] - A[j] < A[j] && k != null) {
                    dp[i][j] = dp[j][k] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 2;
                }
            }
        }
        return max;
    }
}

// method 2: brute force

class Solution {
    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < A.length; i++)
            map.put(A[i], i);
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int left = i, right = j, count = 0;
                while (map.containsKey(A[left] + A[right])) {
                    int tmp = right;
                    right = map.get(A[left] + A[right]);
                    left = tmp;
                    count++;
                }
                if (count != 0) {
                    count += 2;
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
}