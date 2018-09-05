// Question 896 Monotonic Array

class Solution {
    public boolean isMonotonic(int[] A) {
        int flag = 0;
        for (int i = 0; i < A.length - 1; i++) {
            int c = Integer.compare(A[i], A[i + 1]);
            if (c != 0) {
                if (c != flag && flag != 0) 
                    return false;
                else
                    flag = c;
            }
        }
        return true;
    }
}