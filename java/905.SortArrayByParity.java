// Question 905 Sort Array By Parity

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            while (left < A.length && A[left] % 2 == 0 )
                left++;
            while (right >= 0 && A[right] % 2 == 1)
                right--;
            if (left >= right)
                break;
            int tmp = A[left];
            A[left] = A[right];
            A[right] = tmp;
            left++;
            right--;
        }
        return A;
    }
}