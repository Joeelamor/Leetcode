// Question 977 Squares of a Sorted Array

class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int index = res.length - 1;
        int left = 0, right = A.length - 1;
        while (left <= right) {
            if (A[left] * A[left] > A[right] * A[right]) {
                res[index--] = A[left] * A[left];
                left++;
            } else {
                res[index--] = A[right] * A[right];
                right--;
            }
        }
        return res;
    }
}