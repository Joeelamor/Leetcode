// Problem 845 Longest Mountain in Array

// Method 1: two points
class Solution {
    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;
        int max = 0, n = A.length, i = 0, pre = 0, l = 0;
        while (i < n) {
            if (i + 1 < n && A[i] > A[i + 1]) {
                if (pre == 0) {
                    i++;
                    continue;
                }
                l = 1;
                while (i + 1 < n && A[i] > A[i + 1]) {
                    l++;
                    i++;
                }
                max = Math.max(max, pre + l);
                pre = 0;
                l = 0;
            } else if (i + 1 < n && A[i] < A[i + 1]) {
                while (i + 1 < n && A[i] < A[i + 1]) {
                    pre++;
                    i++;
                }
            } else {
                i++;
                pre = 0;
            }
        }
        return max;
    }
}

// Method 2 DP
class Solution {
    public int longestMountain(int[] A) {
        int len = A.length, max = 0;
        int[] up = new int[len], down = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) down[i] = down[i + 1] + 1;
        }
        for (int i = 0; i < len; i++) {
            if (i > 0 && A[i] > A[i - 1]) up[i] = up[i - 1] + 1;
            if (up[i] > 0 && down[i] > 0) max = Math.max(max, up[i] + down[i] + 1);
        }
        return max;
    }
}