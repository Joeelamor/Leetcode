// Problem 775 Global And Local Inversions

class Solution {
    /**All local inversions are global inversions.
     * If the number of global inversions is equal to the number of local inversions,
     * it means that all global inversions in permutations are local inversions.
     * It also means that we can not find A[i] > A[j] with i+2<=j.
     * In other words, max(A[i]) < A[i+2]
     */
    public boolean isIdealPermutation(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length - 2; i++) {
            max = Math.max(max, A[i]);
            if (max > A[i + 2])
                return false;
        }
        return true;
    }
}