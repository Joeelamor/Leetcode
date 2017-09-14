// Problem 553 Optimal Division

/* X1/X2/X3/../Xn will always be equal to (X1/X2) * Y, no matter how you place parentheses. 
 * i.e no matter how you place parentheses, X1 always goes to the numerator and X2 always 
 * goes to the denominator. Hence you just need to maximize Y. And Y is maximized when it 
 * is equal to X3 *..*Xn. So the answer is always X1/(X2/X3/../Xn) = (X1 *X3 *..*Xn)/X2 */
class Solution {
    public String optimalDivision(int[] nums) {
        if(nums.length == 0)
            return "";
        if(nums.length == 1)
            return Integer.toString(nums[0]);
        if(nums.length == 2)
            return Integer.toString(nums[0]) + "/" + Integer.toString(nums[1]);
        String res = Integer.toString(nums[0]) + "/(" + Integer.toString(nums[1]);
        for(int i = 2; i < nums.length; i++) {
            res += "/" + Integer.toString(nums[i]);
        }
        res += ")";
        return res;
    }
}