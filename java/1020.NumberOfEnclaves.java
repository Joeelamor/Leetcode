// Question 1020 Number of Enclaves

class Solution {
    public int numEnclaves(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0)
            return 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i == 0 || j == 0 || i == A.length - 1 || j == A[0].length - 1) {
                    helper(A, i, j);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[i].length; j++) {
                if(A[i][j] == 1)
                    res++;
            }
        }
        return res;
    }
    private void helper(int[][] A, int i, int j) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] == 0)
            return;
        A[i][j] = 0;
        helper(A, i - 1, j);
        helper(A, i + 1, j);
        helper(A, i, j - 1);
        helper(A, i, j + 1);
    }
}