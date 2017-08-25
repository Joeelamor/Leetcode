// Problem 633 Sum Of Square Numbers

class Solution {
    public boolean judgeSquareSum(int c) {
        if(c < 0)
            return false;
        int left = 0, right = (int)Math.sqrt(c);
        while(left <= right) {
            int num = left * left + right * right;
            if(num < c)
                left++;
            else if(num > c)
                right--;
            else
                return true;
        }
        return false;
    }
}