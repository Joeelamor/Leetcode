// Question 1004 Max Consecutive Ones III

class Solution {
    public int longestOnes(int[] A, int K) {
        int max = 0, i = 0, zero = 0;
        for (int j = 0; j < A.length; j++) {
            zero += A[j] == 0 ? 1 : 0;
            while (zero > K) {
                zero -= A[i++] == 0 ? 1 : 0;
            }
            max = Math.max(max, j - i  + 1);
        }
        return max;
    }
}