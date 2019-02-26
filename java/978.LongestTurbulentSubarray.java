// Question 978 Longest Turbulent Subarray

class Solution {
    public int maxTurbulenceSize(int[] A) {
        int res = 1;
        int idx = 0;
        for (int i = 1; i < A.length; i++) {
            int c = Integer.compare(A[i - 1], A[i]);
            if (c == 0)
                idx = i;
            else if (i == A.length - 1 || c * Integer.compare(A[i], A[i + 1]) != -1) {
                res = Math.max(res, i - idx + 1);
                idx = i;
            }
        }
        return res;
    }
}