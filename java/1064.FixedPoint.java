// Question 1064 Fixed Point

class Solution {
    public int fixedPoint(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; 
            if (A[mid] >= mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return A[right] == right ? right : -1;
    }
}