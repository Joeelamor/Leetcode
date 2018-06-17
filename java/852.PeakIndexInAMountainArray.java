// Problem 852 Peak Index In A Mountain Array

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}