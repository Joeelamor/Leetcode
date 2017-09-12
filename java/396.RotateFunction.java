// Problem 396 Rotate Function

/* F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]
 * F(k-1) = 0 * Bk-1[0] + 1 * Bk-1[1] + ... + (n-1) * Bk-1[n-1]
 *        = 0 * Bk[1] + 1 * Bk[2] + ... + (n-2) * Bk[n-1] + (n-1) * Bk[0]
 * F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] + (1-n)Bk[0]
 *               = (Bk[0] + ... + Bk[n-1]) - nBk[0]
 *               = sum - nBk[0]
 * then F(k) = F(k-1) + sum - nBk[0] => F(k-1) = F(k) - sum + nBk[0] */
 
class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length == 0)
            return 0;
        int sum = 0, iteration = 0, len = A.length;
        for(int i = 0; i < len; i++) {
            sum += A[i];
            iteration += A[i] * i;
        }
        int max = iteration;
        for(int i = 1; i < len; i++) {
            iteration = iteration - sum + A[i - 1] * len;
            max = Math.max(max, iteration);
        }
        return max;
    }
}