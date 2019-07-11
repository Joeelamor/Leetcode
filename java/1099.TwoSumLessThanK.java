// Question 1099 Two Sum Less Than K

class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int max = -1, left = 0, right = A.length - 1;
        while (left < right) {
            if (A[left] + A[right] == K) {
                right--;
            } else if (A[left] + A[right] < K) {
                max = Math.max(A[left] + A[right], max);
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}