Problem 66 Plus One

public class Solution {
    public int[] plusOne(int[] digits) {
        int m = digits.length;
        for(int i = m - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;   //if there is no carry in last digit after 
                					plussing, then return digits.
            }
            else
                digits[i] = 0;   //if there is carry, then look at previous 
                					digit.
        }
        int[] result = new int[m+1];
        result[0] = 1;
        return result;
    }
}