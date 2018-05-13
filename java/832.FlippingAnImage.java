// Problem 832 Flipping An Image

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0, k = A[i].length - 1; j <= k; j++, k--) {
                int tmp = A[i][k];
                A[i][k] = A[i][j] ^ 1;
                A[i][j] = tmp ^ 1;
            }
        }
        return A;
    } 
}