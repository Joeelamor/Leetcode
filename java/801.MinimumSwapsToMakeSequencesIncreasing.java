// Problem 801 Minimum Swaps To Make Sequences Increasing

class Solution {
    public int minSwap(int[] A, int[] B) {
        int swapRecord = 1, fixRecord = 0;
        for (int i = 1; i < A.length; i++) {
            // In this case, the ith manipulation should be same as the i-1th manipulation
            // fixRecord = fixRecord;
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) swapRecord++;
            // In this case, the ith manipulation should be the opposite of the i-1th manipulation
            // When A[2] and B[2] swap, A[3] and A[3] should fix. When A[2] and B[2] fix, A[3] and A[3] should swap
            else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                int tmp = swapRecord;
                swapRecord = fixRecord + 1;
                fixRecord = tmp;
            } else {
                // Either swap or fix is OK. Let's keep the minimum one
                int min = Math.min(swapRecord, fixRecord);
                swapRecord = min + 1;
                fixRecord = min;
            }
        }
        return Math.min(swapRecord, fixRecord);
    }
}