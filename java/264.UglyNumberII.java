// Problem 264 Ugly Number II

// Failed method(Time Limit Exceeded)
public class Solution {
    public int nthUglyNumber(int n) {
        int count = 0;
        int i = 1;
        while(count < n) {
            if(isUgly(i)) {
                count++;
                i++;
            }
            else
                i++;
        }
        return i - 1;
    }
    public boolean isUgly(int num) {
        if(num <= 0)
            return false;
        if(num == 1)
            return true;
        if(num % 2 == 0)
            return isUgly(num/2);
        if(num % 3 == 0)
            return isUgly(num/3);
        if(num % 5 == 0)
            return isUgly(num/5);
        return false;
    }
}

// Right method
/* The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
 * because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:

 * (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
 * (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
 * (3) 1×5, 2×5, 3×5, 4×5, 5×5, …

 * We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.
 * Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.
 * Every step we choose the smallest one, and move one step after,including nums with same value. */

public class Solution {
    public int nthUglyNumber(int n) {
        int []as = new int[n];
        as[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            as[i] = min;
            if(factor2 == min)
                factor2 = 2 * as[++index2];
            if(factor3 == min)
                factor3 = 3 * as[++index3];
            if(factor5 == min)
                factor5 = 5 * as[++index5];
        }
        return as[n - 1];
    }
}

