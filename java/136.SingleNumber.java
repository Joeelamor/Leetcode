// Problem 136 Single Number

/* We use bitwise XOR to solve this problem:
 * bitwise in Java
 * 1. 0 ^ N = N; 2. N ^ N = 0; */

public class Solution {
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for(int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}