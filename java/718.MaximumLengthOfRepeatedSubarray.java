// Problem 718 Maximum Length Of Repeated Subarray

// In this problem, I use DP to record each position the maximum length of repeated subarray.
class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] l = new int[A.length+1][B.length+1];
        
        for (int i = 0; i <= A.length; i++)
            l[i][B.length] = 0;
        
        for (int i = 0; i <= B.length; i++)
            l[A.length][i] = 0;
        
        int max = 0;
        
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >=0; j--) {
                if (A[i] == B[j])
                    l[i][j] = l[i+1][j+1] + 1;
                else
                    l[i][j] = 0;
                
                if (l[i][j] > max)
                    max = l[i][j];
            }
        }
        
        return max;
    }
}